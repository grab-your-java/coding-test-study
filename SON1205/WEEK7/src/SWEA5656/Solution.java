package SWEA5656;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//시간 초과가 어디서 날까?
public class Solution {
    static int[][] copiedMap;
    static int result;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            result = Integer.MAX_VALUE;

            int N = sc.nextInt();
            int W = sc.nextInt();
            int H = sc.nextInt();

            int[][] map = new int[H][W];
            copiedMap = new int[H][W];

            int[] selected = new int[N];

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    copiedMap[i][j] = map[i][j] = sc.nextInt();
                }
            }

            permH(map, selected, 0);

            System.out.println("#" + tc + " " + result);
        }
    }

    static void permH(int[][] map, int[] selected, int cnt) {
        if (result == 0) {
            return;
        }

        if (cnt == selected.length) {
            breakingBlock(map, selected);

            countingRemains(map);

            initializeMap(map);

            return;
        }

        for (int i = 0; i < map[0].length; i++) {
            selected[cnt] = i;
            permH(map, selected, cnt + 1);
        }
    }

    static void breakingBlock(int[][] map, int[] selected) {
        for (int i = 0; i < selected.length; i++) {
            if (map[map.length - 1][selected[i]] == 0) {
                return;
            }

            int r = -1;
            for (int j = 0; j < map.length; j++) {
                if (map[j][selected[i]] != 0) {
                    r = j;
                    break;
                }
            }

            if (r == -1) {
                return;
            }

            bfs(map, r, selected[i]);

            move(map);
        }
    }

    //여기서 실수함....
    static void move(int[][] map) {
        for (int i = 0; i < map[0].length; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] != 0) {
                    stack.push(map[j][i]);
                    map[j][i] = 0;
                }
            }

            int idx = map.length - 1;
            while (!stack.isEmpty()) {
                map[idx--][i] = stack.pop();
            }
        }
    }

    static void bfs(int[][] map, int r, int c) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(r);
        queue.offer(c);
        queue.offer(map[r][c]);

        while (!queue.isEmpty()) {
            int tmpR = queue.poll();
            int tmpC = queue.poll();
            int tmpMap = queue.poll();
            map[tmpR][tmpC] = 0;

            for (int i = 0; i < dr.length; i++) {
                for (int j = 1; j < tmpMap; j++) {
                    int nr = tmpR + j * dr[i];
                    int nc = tmpC + j * dc[i];

                    if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) {
                        continue;
                    }

                    if (map[nr][nc] != 0) {
                        queue.offer(nr);
                        queue.offer(nc);
                        queue.offer(map[nr][nc]);
                    }
                }
            }
        }
    }

    static void initializeMap(int[][] to) {
        for (int i = 0; i < copiedMap.length; i++) {
            for (int j = 0; j < copiedMap[0].length; j++) {
                to[i][j] = copiedMap[i][j];
            }
        }
    }

    static void countingRemains(int[][] map) {
        int sum = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 0) {
                    sum++;
                }
            }
        }

        if (sum < result) {
            result = sum;
        }
    }
}
