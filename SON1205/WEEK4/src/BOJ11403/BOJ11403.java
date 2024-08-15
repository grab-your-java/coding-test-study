package BOJ11403;

import java.util.Scanner;

//time over
public class BOJ11403 {
    static int N;
    static int[][] map;
    static int[][] available;
    static boolean[] visited;
    static int from;
    static int to;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        N = sc.nextInt();

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        available = new int[N][N];
        visited = new boolean[N];

        //로직
        for (int i = 0; i < N; i++) {
            from = i;
            for (int j = 0; j < N; j++) {
                to = j;
                dfs(from, 0);
            }
        }

        //출력
        for (int[] ints : available) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int now, int depth) {
        if (now == to && depth != 0) {
            available[from][to] = 1;
            return;
        } else if (depth >= N - 1) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (map[now][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i,depth + 1);
                visited[i] = false;
            }
        }
    }
}
