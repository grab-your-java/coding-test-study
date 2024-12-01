package SWEA1952;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int[] prices = new int[4];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = sc.nextInt();
            }

            int[] plans = new int[13];
            for (int i = 1; i < plans.length; i++) {
                plans[i] = sc.nextInt();
            }

            int[] minPrice = new int[13];

            dp(prices, plans, minPrice);

            System.out.println("#" + tc + " " + Math.min(minPrice[12], prices[3]));
        }
    }

    private static void dp(int[] prices, int[] plans, int[] minPrice) {
        for (int i = 1; i < plans.length; i++) {
            int tmp = plans[i] * prices[0];

            minPrice[i] = Math.min(tmp + minPrice[i - 1], prices[1] + minPrice[i - 1]);

            if (i < 3) {
                continue;
            }

            minPrice[i] = Math.min(prices[2] + minPrice[i - 3], minPrice[i]);
        }
    }
}

