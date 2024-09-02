package boj_1012;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int R, C, K;
    static boolean[][] planted;
    static int bugCnt;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        while (T-- > 0) {
            R = sc.nextInt();
            C = sc.nextInt();
            K = sc.nextInt();

            planted = new boolean[R][C];
            bugCnt = 0;

            while (K-- > 0) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                planted[r][c] = true;
            }

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (planted[r][c]) {
                        bfs(r, c);
                        bugCnt++;
                    }
                }
            }

            sb.append(bugCnt).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int r, int c) {
        Queue<Integer> queue = new ArrayDeque<>();
        planted[r][c] = false;
        queue.add(r);
        queue.add(c);

        while (!queue.isEmpty()) {
            int cr = queue.poll();
            int cc = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && planted[nr][nc]) {
                    planted[nr][nc] = false;
                    queue.add(nr);
                    queue.add(nc);
                }
            }
        }
    }
}
