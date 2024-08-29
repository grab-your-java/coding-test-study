package BOJ_NandM;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15657 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        output = new int[M];

        comH(input, 0, 0);
        System.out.print(sb.toString());
    }

    static int[] output;
    static StringBuilder sb = new StringBuilder();

    static void comH(int[] input, int start, int cnt) {
        if (cnt == output.length) {
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < input.length; i++) {
            output[cnt] = input[i];
            comH(input, i, cnt + 1);
        }
    }
}
