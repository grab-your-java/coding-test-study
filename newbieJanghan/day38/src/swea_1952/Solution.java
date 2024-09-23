package swea_1952;

import java.util.Scanner;

public class Solution {
    static int[] prices;
    static int[] daysPerMonth;
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            // inputs
            prices = new int[4];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = sc.nextInt();
            }

            daysPerMonth = new int[12];
            for (int i = 0; i < daysPerMonth.length; i++) {
                daysPerMonth[i] = sc.nextInt();
            }

            min = Integer.MAX_VALUE;
            dfs(0, 0);

            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int month, int acc) {
        if (month >= 12) { // if month exceed 12 because of 3 months plan
            min = Math.min(min, acc);
            return;
        }

        for (int i = 0; i < prices.length; i++) {
            int curPrice = calPrice(i, daysPerMonth[month]);
            if (acc + curPrice > min) {
                continue;
            }

            dfs(calMonth(i, month), acc + curPrice);
        }
    }

    static int calPrice(int i, int days) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                return prices[i];
            default:
                return days * prices[i];
        }
    }

    static int calMonth(int price, int month) {
        switch (price) {
            case 2:
                return month + 3;
            case 3:
                return 12;
            default:
                return month + 1;
        }
    }
}
