package SWEA1949;

import java.util.Scanner;

public class Solution {
    static int result;
    static boolean[][] visited;
    static boolean chance;
    static int tmp;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] map = new int[N][N];
            int highest = 0;
            result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] > highest) {
                        highest = map[i][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == highest) {
                        System.out.println(i + " " + j);
                        tmp = 1;
                        chance = true;
                        visited = new boolean[N][N];
                        dfs(map, K, i, j);
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    static void dfs(int[][] map, int K, int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= map.length || nc < 0 || nc >= map.length) {
                continue;
            }

            if (visited[nr][nc] || (!chance && map[nr][nc] >= map[r][c]) || (chance && map[nr][nc] - map[r][c] >= K)) {
                if (tmp > result) {
                    result = tmp;
                }
                continue;
            }

            if (map[nr][nc] - map[r][c] < 0) {
                tmp++;
                System.out.println(1 + "result= " + result +", tmp= " + tmp + ", nr= " + nr + ", nc= " + nc);
                dfs(map, K, nr, nc);
            } else if (map[nr][nc] - map[r][c] < K) {
                if (chance) {
                    tmp++;
                    chance = false;
                    System.out.println(2 + "result= " + result +", tmp= " + tmp + ", nr= " + nr + ", nc= " + nc);
                    dfs(map, K, nr, nc);
                    chance = true;
                }
            }

            tmp--;
        }
        visited[r][c] = false;
    }

//    static void bfs(int[][] map, int K, int r, int c) {
//        Deque<int[]> queue = new ArrayDeque<>();
//        int[][] visited = new int[map.length][map.length];
//        queue.offer(new int[]{r, c});
//        visited[r][c] = 1;
//
//        while (!queue.isEmpty()) {
//            int[] tmp = queue.poll();
//
//            for (int i = 0; i < dc.length; i++) {
//                int nr = tmp[0] + dr[i];
//                int nc = tmp[1] + dc[i];
//
//                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map.length) {
//                    continue;
//                }
//
//                if (visited[nr][nc] != 0 || map[tmp[0]][tmp[1]] - map[nr][nc] < -K) {
//                    continue;
//                }
//
//
//            }
//        }
//    }
}
