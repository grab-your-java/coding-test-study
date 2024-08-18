package swea_1486_장훈이의_높은_선반;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + t + " ");

            int N = sc.nextInt();
            int criterion = sc.nextInt();
            int[] heights = new int[N];
            for (int i = 0; i < N; i++) {
                heights[i] = sc.nextInt();
            }

            sb.append(TowerBuilder.getMinHeightDiff(heights, criterion));

            System.out.println(sb);
        }
    }

    static class TowerBuilder {
        static int[] HEIGHTS;
        static int MIN_CRITERION;
        static int BUILDING;

        static int getMinHeightDiff(int[] heights, int criterion) {
            HEIGHTS = heights;
            MIN_CRITERION = criterion;
            BUILDING = Integer.MAX_VALUE;

            dfs(0, 0);
            return BUILDING - MIN_CRITERION;
        }

        static private void dfs(int start, int accHeight) {
            if (accHeight >= MIN_CRITERION) {
                BUILDING = Math.min(BUILDING, accHeight);
            }

            for (int i = start; i < HEIGHTS.length; i++) {
                if (accHeight + HEIGHTS[i] < BUILDING) {
                    dfs(i + 1, accHeight + HEIGHTS[i]);
                }
            }
        }
    }
}
