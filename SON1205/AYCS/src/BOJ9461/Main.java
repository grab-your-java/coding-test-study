package BOJ9461;

import java.util.Scanner;

public class Main {
    static long[] memo = new long[101];

    static {
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;
        memo[4] = 2;
        memo[5] = 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            findLength(sc.nextInt());
        }
    }

    private static void findLength(int num) {
        if (num == 1 || num == 2 || num == 3 || num == 4 || num == 5) {
            System.out.println(memo[num]);
            return;
        }

        if (memo[num] == 0) {
            for (int i = 6; i <= num; i++) {
                if (memo[i] == 0) {
                    memo[i] = memo[i - 1] + memo[i - 5];
                }
            }
        }

        System.out.println(memo[num]);
    }
}
