package swea_4012_요리사;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // ingredients count
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            CookBalancer balancer = new CookBalancer(map);
            System.out.println("#" + t + " " + balancer.exec());
        }

    }

    static class CookBalancer {
        private final int[][] SYNERGY_MAP;
        private final int INGREDIENT_COUNT;
        private final int COMB_SIZE;
        private boolean[] combined;
        private int MIN_DIFF = Integer.MAX_VALUE;

        CookBalancer(int[][] synergies) {
            SYNERGY_MAP = synergies;
            INGREDIENT_COUNT = synergies.length;
            this.COMB_SIZE = synergies.length / 2;
        }

        int exec() {
            combined = new boolean[INGREDIENT_COUNT];
            dfs(0, 0);

            return MIN_DIFF;
        }

        void dfs(int depth, int start) {
            if (depth == COMB_SIZE) {
                int[] a = new int[COMB_SIZE];
                int[] b = new int[COMB_SIZE];
                int aIdx = 0, bIdx = 0;
                for (int i = 0; i < INGREDIENT_COUNT; i++) {
                    if (combined[i]) {
                        a[aIdx++] = i;
                    } else {
                        b[bIdx++] = i;
                    }
                }

                MIN_DIFF = Math.min(MIN_DIFF, Math.abs(calSynergy(a) - calSynergy(b)));
                return;
            }

            for (int i = start; i < INGREDIENT_COUNT; i++) {
                combined[i] = true;
                dfs(depth + 1, i + 1);
                combined[i] = false;
            }
        }

        private int calSynergy(int[] comb) {
            int temp = 0;
            for (int i : comb) {
                for (int j : comb) {
                    temp += SYNERGY_MAP[i][j];
                }
            }

            return temp;
        }
    }
}
