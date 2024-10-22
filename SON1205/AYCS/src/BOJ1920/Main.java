package BOJ1920;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] input = new int[N];

        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        int M = sc.nextInt();

        int[] results = new int[M];

        for (int i = 0; i < M; i++) {
            results[i] = isExist(input, sc.nextInt());
        }

        for (int n : results) {
            System.out.println(n);
        }
    }

    private static int isExist(int[] input, int num) {
        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (input[mid] == num) {
                return 1;
            } else if (input[mid] < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }
}
