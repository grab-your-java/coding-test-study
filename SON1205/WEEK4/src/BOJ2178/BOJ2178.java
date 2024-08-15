package BOJ2178;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ2178 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int N;
    static int M;
    static boolean[][] visited;
    static int[][] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = sc.next().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j] - '0';
            }
        }

        visited = new boolean[N][M];
        distance = new int[N][M];
        distance[0][0] = 1;

        visited[0][0] = true;
        bfs(0, 0);

        System.out.println(distance[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }

                queue.offer(new int[]{nx, ny});
                distance[nx][ny] = distance[now[0]][now[1]] + 1;
                visited[nx][ny] = true;
            }
        }
    }
}
