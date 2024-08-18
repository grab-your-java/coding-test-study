package SWEA1249;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] line = sc.next().split("");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            result = new int[N][N];
            visited = new boolean[N][N];

            bfs(0, 0);

            System.out.println("#" + tc + " " + result[N - 1][N - 1]);
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static int[][] result;
    static boolean[][] visited;

    static void bfs(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            visited[tmp[0]][tmp[1]] = true;

            for (int i = 0; i < dx.length; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (nx < 0 || nx >= visited.length || ny < 0 || ny >= visited.length) {
                    continue;
                }

                int cnt = result[tmp[0]][tmp[1]] + map[nx][ny];

                if (visited[nx][ny]) {
                    if (result[nx][ny] > cnt) {
                        result[nx][ny] = cnt;
                        queue.offer(new int[]{nx, ny});
                    }
                    continue;
                }

                if (!visited[nx][ny]) {
                    result[nx][ny] = cnt;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

}
