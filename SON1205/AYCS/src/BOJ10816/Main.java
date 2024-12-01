package BOJ10816;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        int M = sc.nextInt();

        int[] results = new int[M];

        for (int i = 0; i < M; i++) {
            results[i] = countingExist(input, sc.nextInt());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            sb.append(results[i]);

            if (i != results.length - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }

    private static int countingExist(int[] input, int num) {
//        System.out.println("upper(input, num) = " + upper(input, num));
//        System.out.println("lower(input, num) = " + lower(input, num));
        return upper(input, num) - lower(input, num);
    }

    private static int lower(int[] input, int num) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (input[mid] >= num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    private static int upper(int[] input, int num) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (input[mid] <= num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}
