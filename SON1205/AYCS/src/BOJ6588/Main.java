package BOJ6588;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean[] prime = new boolean[1_000_001];

    static {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i < prime.length; i++) {
            //i가 소수일 때
            if (prime[i]) {
                //i*i미만은 이미 처리되었으므로 i*i부터 시작
                //i의 배수들을 지워간다
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt();

            if (N == 0) break;

            boolean findCase = true;

            for (int i = 3; i <= N / 2; i++) {
                if (prime[i] && prime[N - i]) {
                    System.out.println(N + " = " + i + " + " + (N - i));
                    findCase = false;
                    break;
                }
            }

            if (findCase) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}
