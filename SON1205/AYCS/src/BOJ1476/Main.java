package BOJ1476;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int tmp = 0;
        int year = 15 * tmp + E;

        while (!((year % 28 == 0 ? 28 : year % 28) == S && (year % 19 == 0 ? 19 : year % 19) == M)) {
            tmp++;
            year = 15 * tmp + E;
        }

        System.out.println(year);
    }
}
