package SWEA햄버거다이어트;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            L = sc.nextInt();

            ingredient = new int[N][2];
            result = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                    ingredient[i][j] = sc.nextInt();
                }
            }

            for (int i = 1; i <= N; i++) {
                visited = new boolean[N + 1];
                output = new int[i];
                combi(0, 0, i);
            }

            Collections.sort(result);

            System.out.println("#" + tc + " " + result.get(result.size() - 1));
        }
    }

    static int N;
    static int L;
    static boolean[] visited;
    static int[] output;

    static int[][] ingredient;

    static List<Integer> result;

    static void combi(int start, int depth, int M) {
        if (depth == M) {
            //logic
            int totalKcal = 0;

            for (int i = 0; i < output.length; i++) {
                totalKcal += ingredient[output[i]][1];
            }

            if (totalKcal <= L) {
                int totalScore = 0;
                for (int i = 0; i < output.length; i++) {
                    totalScore += ingredient[output[i]][0];
                }

                result.add(totalScore);
            }

            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                combi(i + 1, depth + 1, M);
                visited[i] = false;
            }
        }
    }
}