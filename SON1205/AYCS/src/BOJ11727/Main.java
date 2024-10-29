package BOJ11727;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] memo = new int[1001];

        memo[1] = 1;
        memo[2] = 3;

        for (int i = 3; i <= n; i++) {
            memo[i] = (2 * memo[i - 2] + memo[i - 1]) % 10_007;
        }

        System.out.println(memo[n]);
    }
}
