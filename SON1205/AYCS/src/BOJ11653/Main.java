package BOJ11653;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        primeFactor(N);
    }

    private static void primeFactor(int num) {
        if (num == 1) {
            return;
        }

        int i = 2;

        while (i <= num) {
            while (num != 1 && num % i == 0) {
                System.out.println(i);
                num /= i;
            }

            i++;
        }
    }
}
