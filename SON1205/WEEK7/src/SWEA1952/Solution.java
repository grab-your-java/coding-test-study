package SWEA1952;

import java.util.Scanner;

public class Solution {
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            result = Integer.MAX_VALUE;

            int[] fee = new int[4];
            for (int i = 0; i < fee.length; i++) {
                fee[i] = sc.nextInt();
            }

            int[] plan = new int[12];
            for (int i = 0; i < plan.length; i++) {
                plan[i] = sc.nextInt();
            }

            expectTotalFee(fee, plan, 0, 0);

            System.out.println("#" + tc + " " + result);
        }
    }

    static void expectTotalFee(int[] fee, int[] plan, int month, int tmp) {
        if (month >= 12) {
            if (tmp < result) {
                result = tmp;
            }
            return;
        }

        if (plan[month] == 0) {
            expectTotalFee(fee, plan, month + 1, tmp);
            return;
        }

        if (tmp > result) {
            return;
        }

        expectTotalFee(fee, plan, month + 1, tmp + fee[0] * plan[month]);

        expectTotalFee(fee, plan, month + 1, tmp + fee[1]);

        expectTotalFee(fee, plan, month + 3, tmp + fee[2]);

        expectTotalFee(fee, plan, month + 12, tmp + fee[3]);
    }
}
