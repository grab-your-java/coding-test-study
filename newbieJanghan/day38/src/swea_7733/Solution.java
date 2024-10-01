package swea_7733;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int N, min, max;
    static int[][] tastes;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            N = sc.nextInt();
            tastes = new int[N][N];
            min = 100;
            max = 1;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int taste = sc.nextInt();
                    min = Math.min(min, taste);
                    max = Math.max(max, taste);

                    tastes[r][c] = taste;
                }
            }

            int count = 1; // 덩어리가 없으면 1이므로
            for (int taste = min; taste <= max; taste++) {
                count = Math.max(count, countByTaste(taste));
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    static int countByTaste(int taste) {
        int count = 0;
        visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c] && tastes[r][c] > taste) {
                    count++;
                    bfs(taste, r, c);
                }
            }
        }

        return count;
    }

    // up, right, down, left
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static void bfs(int taste, int r, int c) {
        Queue<Integer> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.add(r);
        queue.add(c);

        while (!queue.isEmpty()) {
            int cr = queue.poll();
            int cc = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                while (0 <= nr && nr < N && 0 <= nc && nc < N && tastes[nr][nc] > taste && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(nr);
                    queue.add(nc);
                }
            }
        }
    }
}
