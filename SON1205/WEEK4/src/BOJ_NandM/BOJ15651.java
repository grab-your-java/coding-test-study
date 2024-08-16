package BOJ_NandM;

import java.util.Scanner;

public class BOJ15651 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = i + 1;
        }

        output = new int[M];

        permPi(0);
        System.out.println(sb.toString());
    }

    static int N;
    static int M;
    static int[] input;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    static void permPi(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            output[cnt] = input[i];
            permPi(cnt + 1);
        }
    }
}
