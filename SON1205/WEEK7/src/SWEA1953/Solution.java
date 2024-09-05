package SWEA1953;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
    static int[][] visited;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int H = sc.nextInt();
            int W = sc.nextInt();

            int r = sc.nextInt();
            int c = sc.nextInt();

            int time = sc.nextInt();

            int[][] map = new int[H][W];

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            visited = new int[H][W];
            bfs(map, r, c, time);

            int result = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (visited[i][j] != 0) {
                        result++;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    static void bfs(int[][] map, int r, int c, int time) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(r);
        queue.offer(c);
        queue.offer(map[r][c]);
        visited[r][c] = 1;

        while (!queue.isEmpty()) {
            int tmpR = queue.poll();
            int tmpC = queue.poll();
            int tmpTunnel = queue.poll();

            if (visited[tmpR][tmpC] >= time) {
                break;
            }

            switch (tmpTunnel) {
                case 1:
                    for (int i = 0; i < dr.length; i++) {
                        int nr = tmpR + dr[i];
                        int nc = tmpC + dc[i];

                        if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) {
                            continue;
                        }

                        if (visited[nr][nc] != 0 || map[nr][nc] == 0) {
                            continue;
                        }

                        if ((i % 2 == 0 && map[nr][nc] == 3) || (i % 2 == 1 && map[nr][nc] == 2)) {
                            continue;
                        }

                        if (map[nr][nc] == 4 + (7 + i) % 4 || map[nr][nc] == 4 + (8 + i) % 4) {
                            continue;
                        }

                        visited[nr][nc] = visited[tmpR][tmpC] + 1;
                        queue.offer(nr);
                        queue.offer(nc);
                        queue.offer(map[nr][nc]);
                    }
                    break;
                case 2: case 3:
                    for (int i = 0; i < dr.length; i++) {
                        int nr = tmpR + dr[i];
                        int nc = tmpC + dc[i];

                        if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) {
                            continue;
                        }

                        if (visited[nr][nc] != 0 || map[nr][nc] == 0) {
                            continue;
                        }

                        if ((i % 2 == 0 && map[nr][nc] == 3) || (i % 2 == 1 && map[nr][nc] == 2)) {
                            continue;
                        }

                        if (map[nr][nc] == 4 + (7 + i) % 4 || map[nr][nc] == 4 + (8 + i) % 4) {
                            continue;
                        }

                        if (tmpTunnel % 2 == 0 && 0 == i % 2) {
                            visited[nr][nc] = visited[tmpR][tmpC] + 1;
                            queue.offer(nr);
                            queue.offer(nc);
                            queue.offer(map[nr][nc]);
                        }

                        if (tmpTunnel % 2 == 1 && 1 == i % 2) {
                            visited[nr][nc] = visited[tmpR][tmpC] + 1;
                            queue.offer(nr);
                            queue.offer(nc);
                            queue.offer(map[nr][nc]);
                        }
                    }
                    break;
                case 4: case 5: case 6: case 7:
                    for (int i = tmpTunnel; i <= tmpTunnel + 1; i++) {
                        int tmp = i % 4;
                        
                        int nr = tmpR + dr[tmp];
                        int nc = tmpC + dc[tmp];

                        if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) {
                            continue;
                        }

                        if (visited[nr][nc] != 0 || map[nr][nc] == 0) {
                            continue;
                        }

                        if ((tmp % 2 == 0 && map[nr][nc] == 3) || (tmp % 2 == 1 && map[nr][nc] == 2)) {
                            continue;
                        }

                        if (map[nr][nc] == 4 + (7 + tmp) % 4 || map[nr][nc] == 4 + (8 + tmp) % 4) {
                            continue;
                        }

                        visited[nr][nc] = visited[tmpR][tmpC] + 1;
                        queue.offer(nr);
                        queue.offer(nc);
                        queue.offer(map[nr][nc]);
                    }
                    break;
            }
        }
    }
}