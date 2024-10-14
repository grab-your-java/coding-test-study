package BOJ_1676;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int factor2Cnt = 0, factor5Cnt = 0;

        int quotient = n;
        while (quotient > 0) {
            factor2Cnt += quotient /= 2;
        }

        quotient = n;
        while (quotient > 0) {
            factor5Cnt += quotient /= 5;
        }

        System.out.println(Math.min(factor2Cnt, factor5Cnt));
    }
}
