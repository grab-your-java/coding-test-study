package swea_1952_수영장;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 1; t <= T; t++) {
            int[] pricesByPlan = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] visitDaysByMonth = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println("#" + t + " " + new Calculator(pricesByPlan, visitDaysByMonth).exec());
        }
    }

    private static class Calculator {
        private final int[] pricesByPlan;
        private final int[] visitDaysByMonth;
        private int minPrice = Integer.MAX_VALUE;

        Calculator(int[] pricesByPlan, int[] visitDaysByMonth) {
            this.pricesByPlan = pricesByPlan;
            this.visitDaysByMonth = visitDaysByMonth;
        }

        int exec() {
            dfs(0, 0);
            return minPrice;
        }

        void dfs(int month, int accPrice) {
            // calculate
            if (month >= 12) {
                minPrice = Math.min(minPrice, accPrice);
                return;
            }

            if (visitDaysByMonth[month] == 0) {
                dfs(month + 1, accPrice);
            } else {
                for (int plan = 0; plan < 4; plan++) {
                    int price = pricesByPlan[plan];
                    int days = visitDaysByMonth[month];

                    int assumedPrice = calPriceByPlan(plan, price, days);
                    int assumedMonthAfter = getMonthAfterByPlan(plan);

                    if (accPrice + assumedPrice < minPrice) {
                        dfs(month + assumedMonthAfter, accPrice + assumedPrice);
                    }
                }
            }
        }

        private int calPriceByPlan(int plan, int price, int days) {
            return plan == 0 ? price * days : price;
        }

        private int getMonthAfterByPlan(int plan) {
            if (plan == 2) {
                return 3;
            } else if (plan == 3) {
                return 12;
            } else {
                return 1;
            }
        }

    }
}
