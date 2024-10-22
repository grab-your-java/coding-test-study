package SWEA.수영장_1952;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1952_수영장 {
    static boolean[] check;
    static int[] res;
    static int min;
    static int[] plan;
    static int mD;
    static int dP;
    static int mP;
    static int m3P;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            dP = sc.nextInt();
            mP = sc.nextInt();
            m3P = sc.nextInt();
            int yP = sc.nextInt();
            min = yP;
            check = new boolean[12];
            plan = new int[12];
            for (int i = 0; i < 12; i++) {
                plan[i] = sc.nextInt();
            }
            mD = mP / dP; // 한달권 구매할 최소일수
            if (mP % dP != 0)
                mD++;
 
            for (int i = 1; i < 4; i++) {
                res = new int[i];
                com(0, 0);
            }
            int price = 0;
            for (int i = 0; i < 12; i++) {
                if (plan[i] >= mD) {
                    price += mP;
                } else {
                    price += plan[i] * dP;
                }
            }
            if (price < min)
                min = price;
            if (4 * m3P < min)
                min = 4 * m3P;
 
            System.out.println("#" + tc + " " + min);
        }
    }
 
    private static void com(int cnt, int start) {
        if (cnt == res.length) {
            int[] checkPlan = Arrays.copyOf(plan, 12);
            int price = res.length * m3P;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < res.length; j++) {
                    if (i == res[j]) {
                        checkPlan[i] = 0;
                        checkPlan[i + 1] = 0;
                        checkPlan[i + 2] = 0;
                    }
                }
            }
            for (int i = 0; i < 12; i++) {
                if (checkPlan[i] >= mD) {
                    price += mP;
                } else {
                    price += checkPlan[i] * dP;
                }
            }
            if (price < min)
                min = price;
            return;
        }
        for (int i = start; i < 10; i++) {
            if (!check[i]) {
                check[i] = true;
                res[cnt] = i;
                com(cnt + 1, i + 3);
                check[i] = false;
            }
        }
 
    }

}
