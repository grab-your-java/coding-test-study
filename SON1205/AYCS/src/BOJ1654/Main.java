package BOJ1654;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        long[] input = new long[K];

        for (int i = 0; i < K; i++) {
            input[i] = sc.nextLong();
        }

        Arrays.sort(input);

        long result = findMadi(input, N);

        System.out.println(result);
    }

    private static long findMadi(long[] input, int N) {
        long start = 1;
        long end = Integer.MAX_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;

            long tmp = 0;
            for (int i = 0; i < input.length; i++) {
                tmp += input[i] / mid;
            }

            if (tmp >= N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }
}
