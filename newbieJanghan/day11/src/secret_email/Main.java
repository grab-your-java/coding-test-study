package secret_email;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        int N = string.length();
        int R = 1;
        int C = N;

        for (int i = 2; i < N; i++) {
            if (N % i == 0 && R < i && i <= N / i) {
                System.out.println("i: " + i);
                R = i;
                C = N / R;
            }
        }
        System.out.println("R: " + R + ", C: " + C);

        char[][] matrix = new char[R][C];
        int charIdx = 0;
        for (int r = 0; r < R; r++) {
            if (charIdx >= N) break;
            for (int c = 0; c < C; c++) {
                matrix[r][c] = string.charAt(charIdx++);
            }
        }

        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                System.out.print(matrix[r][c]);
            }
        }

    }
}