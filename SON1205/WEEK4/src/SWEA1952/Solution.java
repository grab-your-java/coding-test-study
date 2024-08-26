package SWEA1952;

import java.util.Scanner;

public class Solution {
    static int minPrice;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            minPrice = Integer.MAX_VALUE;

            int[] fee = new int[4];

            for (int i = 0; i < fee.length; i++) {
                fee[i] = sc.nextInt();
            }

            int[] plan = new int[12];
            for (int i = 0; i < plan.length; i++) {
                plan[i] = sc.nextInt();
            }

            findMinPrice(fee, plan, 0, 0);

            System.out.println("#" + tc + " " + minPrice);
        }
    }

    static void findMinPrice(int[] fee, int[] plan, int tmp, int count) {
        if (count >= plan.length) {
            if (tmp < minPrice) {
                minPrice = tmp;
            }
            return;
        }

        if (plan[count] != 0) {
            for (int i = 0; i < fee.length; i++) {
                if (i == 0) {
                    findMinPrice(fee, plan, tmp + plan[count] * fee[i], count + 1);
                } else if (i == 1) {
                    findMinPrice(fee, plan, tmp + fee[i], count + 1);
                } else if (i == 2) {
                    findMinPrice(fee, plan, tmp + fee[i], count + 3);
                } else {
                    findMinPrice(fee, plan, tmp + fee[i], count + 12);
                }
            }
        } else {
            findMinPrice(fee, plan, tmp, count + 1);
        }
    }
}
