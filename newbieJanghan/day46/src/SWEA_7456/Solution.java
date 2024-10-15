package SWEA_7456;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            int N = sc.nextInt(), M = sc.nextInt();
            boolean[][] adjArr = new boolean[N + 1][N + 1];
            while (M-- > 0) {
                int a = sc.nextInt(), b = sc.nextInt();
                adjArr[a][b] = adjArr[b][a] = true;
            }

            int cnt = 0;
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    cnt++;
                    q.add(i);
                }

                while (!q.isEmpty()) {
                    int a = q.poll();
                    for (int b = 1; b <= N; b++) {
                        if (!visited[b] && adjArr[a][b]) {
                            q.add(b);
                            visited[b] = true;
                            adjArr[a][b] = adjArr[b][a] = false;
                        }
                    }
                }
            }

            sb.append(cnt).append("\n");

        }

        System.out.println(sb);
    }
}
