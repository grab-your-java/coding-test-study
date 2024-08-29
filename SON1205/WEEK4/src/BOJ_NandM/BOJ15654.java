package BOJ_NandM;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15654 {
    static int M;
    static int[] input;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] output;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        M = sc.nextInt();

        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        visited = new boolean[N];
        output = new int[M];
        comb(0);
        System.out.print(sb.toString());

    }

    static void comb(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[cnt] = input[i];
                comb(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
