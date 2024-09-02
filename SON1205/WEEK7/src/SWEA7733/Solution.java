package SWEA7733;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            int[][] cheese = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = sc.nextInt();
                }
            }

            int result = 0;

            int idx = 0;
            while (idx < 100) {
                int cnt = 0;
                boolean[][] visited = new boolean[N][N];

                for (int p = 0; p < N; p++) {
                    for (int q = 0; q < N; q++) {
                        if (!visited[p][q] && cheese[p][q] > idx) {
                            cnt++;
                            dfs(cheese, visited, idx, p, q);
                        }
                    }
                }

                if (result < cnt) {
                    result = cnt;
                }

                if (cnt == 0) {
                    break;
                }

                idx++;
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    static void dfs(int[][] cheese, boolean[][] visited, int high, int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= cheese.length || nc < 0 || nc >= cheese.length) {
                continue;
            }

            if (visited[nr][nc] || cheese[nr][nc] <= high) {
                continue;
            }

            dfs(cheese, visited, high, nr, nc);
        }
    }
}
