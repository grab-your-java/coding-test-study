package swea_1953;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int N, M, R, C, L;
    static int[][] map;
    static boolean[][] visited;
    static int count;

    // up, down, left, right
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] directionType = {
            {false, false, false, false},
            {true, true, true, true}, // up down left right
            {true, true, false, false}, // up down
            {false, false, true, true}, // left right
            {true, false, false, true}, // up right
            {false, true, false, true}, // down right
            {false, true, true, false}, // down left
            {true, false, true, false} // up left
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            N = sc.nextInt();
            M = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            L = sc.nextInt();

            map = new int[N][M];
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    map[n][m] = sc.nextInt();
                }
            }

            visited = new boolean[N][M];
            count = 0;
            bfs();

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        visited[R][C] = true;
        count++;

        queue.add(1); // round;
        queue.add(R);
        queue.add(C);

        while (!queue.isEmpty()) {
            int round = queue.poll();
            if (round == L) {
                break;
            }

            int r = queue.poll(), c = queue.poll();
            int type = map[r][c];

            for (int d = 0; d < 4; d++) {
                if (!directionType[type][d]) { // the pipe doesn't have this direction
                    continue;
                }

                int nr = r + dr[d];
                int nc = c + dc[d];
                if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && checkEntry(d, nr, nc)) {
                    visited[nr][nc] = true;
                    count++;
                    queue.add(round + 1);
                    queue.add(nr);
                    queue.add(nc);
                }
            }
        }
    }

    public static boolean checkEntry(int directionFrom, int arrivalR, int arrivalC) {
        int entrancePoint = directionFrom < 2 ? Math.abs(directionFrom - 1) : Math.abs(directionFrom - 5);
        return directionType[map[arrivalR][arrivalC]][entrancePoint];
    }
}
