package SWEA2817;

import java.util.Scanner;

public class Solution {
    static boolean[] visited;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            result = 0;

            int N = sc.nextInt();
            int K = sc.nextInt();

            int[] input = new int[N];

            for (int i = 0; i < N; i++) {
                input[i] = sc.nextInt();
            }

            visited = new boolean[N];

            subset(input, K, 0);

            System.out.println("#" + tc + " " + result);
        }
    }

    static void subset(int[] input, int k, int cnt) {
        if (cnt == visited.length) {
            int sum = 0;

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sum += input[i];
                }

                if (sum > k) {
                    return;
                }
            }

            if (sum == k) {
                result++;
            }
            return;
        }

        visited[cnt] = true;
        subset(input, k, cnt + 1);
        visited[cnt] = false;
        subset(input, k, cnt + 1);
    }
}
