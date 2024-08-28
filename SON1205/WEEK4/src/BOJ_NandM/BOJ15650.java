package BOJ_NandM;

import java.util.Scanner;

public class BOJ15650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N];

        combi(0, 0);
    }

    static int N;
    static int M;
    static boolean[] visited;

    static void combi(int start, int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(i + 1 + " ");
                }
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
