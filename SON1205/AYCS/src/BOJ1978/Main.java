package BOJ1978;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int result = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if (isPrime(num)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
