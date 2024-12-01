package BOJ1463;

import java.util.Scanner;

public class Main {
    static int[] results = new int[1_000_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 2; i <= N; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                results[i] = Math.min(Math.min(results[i / 3] + 1, results[i / 2] + 1), results[i - 1] + 1);
            } else if (i % 3 == 0) {
                results[i] = Math.min(results[i / 3] + 1, results[i - 1] + 1);
            } else if (i % 2 == 0) {
                results[i] = Math.min(results[i / 2] + 1, results[i - 1] + 1);
            } else {
                results[i] = results[i - 1] + 1;
            }
        }

        System.out.println(results[N]);
    }
}
