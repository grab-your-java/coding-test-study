package SWEA2105;

import java.util.Scanner;

public class AnotherSolution {
    static int max;
    static int[][] map;

    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {1, -1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            max = 0;

            int N = sc.nextInt();
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
                    boolean[][] visited = new boolean[N][N];
                    boolean[] mapVisited = new boolean[101];
                    visited[i][j] = true;
                    mapVisited[map[i][j]] = true;
                    dfs(1, i, j, i, j, 0, visited, mapVisited);
                }
            }

            if (max == 0) {
                max = -1;
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    static void dfs(int cnt, int r, int c, int initR, int initC, int dir, boolean[][] visited, boolean[] mapVisited) {
        for (int i = dir; i < dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= map.length || nc >= map.length) {
                continue;
            }

            if (dir == 2 && max >= cnt * 2) {
                return;
            }

            if (nr == initR && nc == initC && cnt > 2) {
                max = Math.max(max, cnt);
            }

            if (!visited[nr][nc] && !mapVisited[map[nr][nc]]) {
                visited[nr][nc] = true;
                mapVisited[map[nr][nc]] = true;
                dfs(cnt + 1, nr, nc, initR, initC, i, visited, mapVisited);
                visited[nr][nc] = false;
                mapVisited[map[nr][nc]] = false;
            }
        }
    }
}

