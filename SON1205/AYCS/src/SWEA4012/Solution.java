package SWEA4012;

import java.util.Scanner;

public class Solution {
    static long result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            result = Integer.MAX_VALUE;

            int N = sc.nextInt();

            int[][] input = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    input[i][j] = sc.nextInt();
                }
            }

            boolean[] visited = new boolean[N];

            combi(input, visited, 0, 0);

            System.out.println("#" + tc + " " + result);
        }
    }

    private static void combi(int[][] input, boolean[] visited, int cnt, int depth) {
        if (depth == visited.length) {
            if (cnt == visited.length / 2) {
                long sumA = calculateSumA(input, visited, 0);
                long sumB = calculateSumB(input, visited, 0);

                result = Math.min(Math.abs(sumA - sumB), result);
            }

            return;
        }

        visited[depth] = true;
        combi(input, visited, cnt + 1, depth + 1);
        visited[depth] = false;
        combi(input, visited, cnt, depth + 1);
    }

    private static long calculateSumA(int[][] input, boolean[] visited, int sum) {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                for (int j = 0; j < visited.length; j++) {
                    if (i != j && visited[j]) {
                        sum += input[i][j];
                    }
                }
            }
        }

        return sum;
    }

    private static long calculateSumB(int[][] input, boolean[] visited, int sum) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                for (int j = 0; j < visited.length; j++) {
                    if (i != j && !visited[j]) {
                        sum += input[i][j];
                    }
                }
            }
        }

        return sum;
    }
}
