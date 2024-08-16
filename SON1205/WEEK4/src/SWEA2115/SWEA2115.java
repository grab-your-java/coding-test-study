package SWEA2115;

import java.util.Scanner;

public class SWEA2115 {

    static int dx = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int C = sc.nextInt();

            int[][] honey = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    honey[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i <= N * N - M; i++) {
                int A = 0;
                int B = 0;

                if (i / M != (i + M - 1) / M) {
                    continue;
                }

                for (int j = 0; j < M; j++) {
                    A += honey[(i + j) / N][(i + j) % N];
                }

                for (int j = i + M; j < N * N; j++) {
                    if (j / M != (j + M - 1) / M) {
                        continue;
                    }

                    for (int k = 0; k < M; k++) {
                        B += honey[(j + k) / N][(j + k) % N];
                    }


                }
            }


        }
    }

    static void chooseHoney(int x, int y) {

    }
}
