package BOJ17471;

import java.util.Scanner;

public class BOJ17471 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] people = new int[N];

        for (int i = 0; i < N; i++) {
            people[i] = sc.nextInt();
        }

        int[][] graph = new int[N][];

        for (int i = 0; i < N; i++) {
            int cnt = sc.nextInt();
            graph[i] = new int[cnt];

            for (int j = 0; j < cnt; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        boolean[] visited = new boolean[N];
    }


}
