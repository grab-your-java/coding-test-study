package BOJ_NandM;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15656 {
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
        permPi(input, 0);
        System.out.print(sb.toString());
    }

    static int[] output;
    static StringBuilder sb = new StringBuilder();

    static void permPi(int[] input, int cnt) {
        if (cnt == output.length) {
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < input.length; i++) {
            output[cnt] = input[i];
            permPi(input, cnt + 1);
        }
    }
}
