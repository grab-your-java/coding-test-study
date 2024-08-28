package BOJ_NandM;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15655 {
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
        visited = new boolean[N];
        combi(input, 0,0);
        System.out.print(sb.toString());
    }

    static boolean[] visited;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    static void combi(int[] input, int start, int cnt) {
        if (cnt == output.length) {
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[cnt] = input[i];
                combi(input, i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
