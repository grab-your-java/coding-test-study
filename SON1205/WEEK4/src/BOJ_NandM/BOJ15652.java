package BOJ_NandM;

import java.util.Scanner;

public class BOJ15652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        output = new int[M];

        combi(0, 0);

        System.out.println(sb.toString());
    }

    static int N;
    static int M;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    static void combi(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            output[depth] = i + 1;
            combi(i, depth + 1);
        }
    }
}
