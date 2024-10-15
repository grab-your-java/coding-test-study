package BOJ11728;

import java.util.*;

public class AnotherSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] input1 = new int[N];
        int[] input2 = new int[M];
        int[] result = new int[N + M];

        for (int i = 0; i < N; i++) {
            input1[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            input2[i] = sc.nextInt();
        }

        Arrays.sort(input1);
        Arrays.sort(input2);

        sort(input1, input2, result);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);

            if (i != result.length - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }

    private static void sort(int[] input1, int[] input2, int[] result) {
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < input1.length && j < input2.length) {
            if (input1[i] < input2[j]) {
                result[index++] = input1[i++];
            } else {
                result[index++] = input2[j++];
            }
        }

        while (i < input1.length) {
            result[index++] = input1[i++];
        }

        while (j < input2.length) {
            result[index++] = input2[j++];
        }
    }
}
