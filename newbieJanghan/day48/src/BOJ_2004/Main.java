package BOJ_2004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int factor2Cnt = countPrimeFactor(2, n) - countPrimeFactor(2, n-m) - countPrimeFactor(2, m);
        int factor5Cnt = countPrimeFactor(5, n) - countPrimeFactor(5, n-m) - countPrimeFactor(5, m);

        System.out.println(Math.min(factor2Cnt, factor5Cnt));
    }

    public static int countPrimeFactor(int factor, int factorialNumber) {
        int count = 0;

        while (factorialNumber >= factor) {
            int quotient = factorialNumber / factor;
            count += quotient;
            factorialNumber = quotient;
        }

        return count;
    }
}
