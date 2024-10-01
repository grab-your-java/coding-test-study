package swea_2105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] desserts;
    static int dessertCnt;
    // ↘ ↗ ↖ ↙
    static int[] dr = {1, -1, -1, 1};
    static int[] dc = {1, 1, -1, -1};

    static boolean[] collectedDesserts;
    static int originR;
    static int originC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            desserts = new int[N][N];
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer((br.readLine()));
                for (int c = 0; c < N; c++) {
                    desserts[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            dessertCnt = -1;
            collectedDesserts = new boolean[101];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    originR = r;
                    originC = c;
                    search(r, c, 0, 0);
                }
            }
            sb.append("#").append(t).append(" ").append(dessertCnt).append("\n");
        }
        System.out.println(sb);
    }

    static void search(int r, int c, int d, int accCnt) {
        if (d == 3 && (r == originR && c == originC)) {
            dessertCnt = Math.max(dessertCnt, accCnt);
        }

        for (int nd = d; nd <= d + 1 && nd < 4; nd++) {
            int nr = r + dr[nd];
            int nc = c + dc[nd];

            if (available(nr, nc)) {
                collectedDesserts[desserts[nr][nc]] = true;
                search(nr, nc, nd, accCnt + 1);
                collectedDesserts[desserts[nr][nc]] = false;
            }
        }
    }

    static boolean available(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < N && !collectedDesserts[desserts[nr][nc]];
    }
}
