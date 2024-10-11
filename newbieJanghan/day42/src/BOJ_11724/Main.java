package BOJ_11724;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() + 1, M = sc.nextInt();

        boolean[][] adjArr = new boolean[N][N];
        int count = 0;
        while (count++ < M) {
            int a = sc.nextInt(), b = sc.nextInt();
            adjArr[a][b] = adjArr[b][a] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];

        int answer = 0;
        for (int i = 1; i < N; i++) {
            if (!visited[i]) {
                q.add(i);
                answer++;
            }

            while (!q.isEmpty()) {
                int a = q.poll();
                for (int b = 1; b < N; b++) {
                    if (adjArr[a][b] && !visited[b]) {
                        q.add(b);
                        visited[b] = true;

                        adjArr[a][b] = adjArr[b][a] = false;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
