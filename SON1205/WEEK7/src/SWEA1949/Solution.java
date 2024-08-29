package SWEA1949;

import java.util.Scanner;

public class Solution {
    static int result;
    static boolean[][] visited;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] map = new int[N][N];
            int highest = 0;
            result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] > highest) {
                        highest = map[i][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == highest) {
//                        System.out.println(i + " " + j);
                        visited = new boolean[N][N];
                        dfs(map, true, highest, 1, K, i, j);
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    static void dfs(int[][] map, boolean chance, int now, int tmp, int K, int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= map.length || nc < 0 || nc >= map.length) {
                continue;
            }

            if (visited[nr][nc] || (!chance && map[nr][nc] >= now) || (chance && map[nr][nc] - now >= K)) {
//                System.out.println(nr + " " + nc + " " + tmp);
                if (tmp > result) {
                    result = tmp;
                }

                if (i == dr.length - 1) {
                    visited[r][c] = false;
                }

//                visited[r][c] = false;

                continue;
            }

            if (map[nr][nc] - now < 0) {
//                System.out.println(1 + "result= " + result + ", chance= " + chance + ", tmp= " + tmp + ", nr= " + nr + ", nc= " + nc);
                dfs(map, chance, map[nr][nc], tmp + 1, K, nr, nc);
            } else if (map[nr][nc] - now < K) {
                if (chance) {
//                    System.out.println(2 + "result= " + result + ", tmp= " + tmp + ", nr= " + nr + ", nc= " + nc);
                    dfs(map, false, map[r][c] - 1, tmp + 1, K, nr, nc);
                }
            }
            visited[nr][nc] = false;
        }
    }
}
