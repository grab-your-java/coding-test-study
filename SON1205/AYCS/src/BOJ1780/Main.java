package BOJ1780;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] input = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                input[i][j] = sc.nextInt();
            }
        }

        int[] result = new int[3];

        countingNum(input, result, 0, 0, N);

        for (int i : result) {
            System.out.println(i);
        }
    }

    private static void countingNum(int[][] input, int[] result, int startR, int startC, int N) {
        if (!isSame(input, startR, startC, N)) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    countingNum(input, result, startR + N / 3 * i, startC + N / 3 * j, N / 3);
                }
            }
        } else {
            result[input[startR][startC] + 1]++;
        }
    }

    private static boolean isSame(int[][] input, int startR, int startC, int N) {
        int mark = input[startR][startC];

        for (int i = startR; i < startR + N; i++) {
            for (int j = startC; j < startC + N; j++) {
                if (mark != input[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
