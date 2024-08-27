package SWEA2115;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int M, C;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();

            int[][] honey = new int[N][N];

            int result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    honey[i][j] = sc.nextInt();
                }
            }

            //중복이 되지 않는 그룹 2개 만들기
            //합이 C보다 크다면 그 중에 몇 개만 고르기
            //고른 것들의 제곱합 구하기
            //그것들의 최대값
            int re = 0;
            for (int i = 0; i <= N * N - 2 * M; i++) {
                for (int j = i + M; j < N * N; j++) {
                    if (!(checkingInline(honey, i, M) && checkingInline(honey, j, M))) {
                        continue;
                    }

                    int tmpResult = 0;
                    max = 0;

                    visited = new boolean[M];
                    subset(honey, i, 0);

                    tmpResult += max;
                    max = 0;

                    visited = new boolean[M];
                    subset(honey, j, 0);

                    tmpResult += max;

                    if (tmpResult > result) {
                        result = tmpResult;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    static boolean checkingInline(int[][] honey, int num, int m) {
        int tmp = num / honey.length;
        for (int i = 1; i < m; i++) {
            if ((num + i) / honey.length != tmp) {
                return false;
            }
        }
        return true;
    }

    // 조합을 먼저 구하고 시작할까
    // 조건이 안맞을 때 조합을 구할까
    // 일부 tc 틀림 -> 결국 부분집합을 모두 구해서 하나하나 확인해야 함
    // 2번째 tc에서 7 2 9
    // 2개 보다 1개짜리 9가 제일 큼
//    static void combi(int[][] honey, int idx, int start, int cnt, int m) {
//        if (cnt == m) {
//            int tmp = 0;
//            for (int i = 0; i < m; i++) {
//                if (visited[i]) {
//                    tmp += honey[(idx + i) / honey.length][(idx + i) % honey.length];
//                }
//            }
//
//            System.out.println(Arrays.toString(visited));
//
//            if (tmp > C) {
//                return;
//            }
//
//            tmp = 0;
//            for (int i = 0; i < m; i++) {
//                if (visited[i]) {
//                    tmp += Math.pow(honey[(idx + i) / honey.length][(idx + i) % honey.length], 2);
//                }
//            }
//
//            if (tmp > max) {
//                max = tmp;
//            }
//
//            return;
//        }
//
//        for (int i = start; i < visited.length; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                combi(honey, idx, i + 1, cnt + 1, m);
//                visited[i] = false;
//            }
//        }
//    }


    static void subset(int[][] honey, int idx, int cnt) {
        if (cnt == M) {
            int tmp = 0;
            for (int i = 0; i < M; i++) {
                if (visited[i]) {
                    tmp += honey[(idx + i) / honey.length][(idx + i) % honey.length];
                }
            }

            if (tmp > C) {
                return;
            }

            tmp = 0;
            for (int i = 0; i < M; i++) {
                if (visited[i]) {
                    tmp += Math.pow(honey[(idx + i) / honey.length][(idx + i) % honey.length], 2);
                }
            }

            if (tmp > max) {
                max = tmp;
            }
            return;
        }

        visited[cnt] = true;
        subset(honey, idx, cnt + 1);
        visited[cnt] = false;
        subset(honey, idx, cnt + 1);
    }

}
