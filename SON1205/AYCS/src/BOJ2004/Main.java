package BOJ2004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int count5 = five_power_n(N) - five_power_n(N - M) - five_power_n(M);
        int count2 = two_power_n(N) - two_power_n(N - M) - two_power_n(M);

        System.out.println(Math.min(count5, count2));
    }

    static int five_power_n(long num) {
        int count = 0;

        while(num >= 5) {
            count += num/5;
            num /= 5;
        }
        return count;
    }

    static int two_power_n(long num) {
        int count = 0;

        while(num >= 2) {
            count += num/2;
            num /= 2;
        }
        return count;
    }

//    private static int multiplesOf2(int n, int m) {
//        int cnt = 0;
//
//        for (int i = 0; i <= n - m; i++) {
//            int tmp = 0;
//            int num = i;
//
//            while (num > 0 && num % 2 == 0) {
//                tmp++;
//                num /= 2;
//            }
//
//            cnt -= tmp;
//        }
//
//
//        for (int i = m + 1; i <= n; i++) {
//            int tmp = 0;
//            int num = i;
//
//            while (num > 0 && num % 2 == 0) {
//                tmp++;
//                num /= 2;
//            }
//
//            cnt += tmp;
//        }
//
//        return cnt;
//    }
//
//    private static int multiplesOf5(int n, int m) {
//        int cnt = 0;
//
//        for (int i = m + 1; i <= n; i++) {
//            int tmp = 0;
//            int num = i;
//
//            while (num > 0 && num % 5 == 0) {
//                tmp++;
//                num /= 5;
//            }
//
//            cnt += tmp;
//        }
//
//        for (int i = 1; i <= n - m; i++) {
//            int tmp = 0;
//            int num = i;
//
//            while (num > 0 && num % 5 == 0) {
//                tmp++;
//                num /= 5;
//            }
//
//            cnt -= tmp;
//        }
//
//        return cnt;
//    }
}
