package BOJ_NandM;

import java.util.Scanner;

public class BOJ15649 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N];
        output = new int[M];

        perm(0);
    }

    static int N;
    static int M;
    static boolean[] visited;
    static int[] output;

    static void perm(int cnt) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i] + " ");
            }

            System.out.println(sb.toString());
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[cnt] = i + 1;
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
