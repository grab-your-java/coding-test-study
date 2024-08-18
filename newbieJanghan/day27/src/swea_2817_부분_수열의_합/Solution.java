package swea_2817_부분_수열의_합;

import java.util.Scanner;

public class Solution {
    static int N, K, count;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = sc.nextInt();
            }

            dfs(0, 0);
            System.out.println("#" + t + " " + count);
        }
    }

    static void dfs(int start, int acc) {
        if (acc == K) {
            count++;
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            if (acc + numbers[i] <= K) {
                dfs(i + 1, acc + numbers[i]);
            }
        }
    }
}
