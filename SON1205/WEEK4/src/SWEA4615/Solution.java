package SWEA4615;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    final static int B = 1;
    final static int W = 2;

    static int[] dr = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] map = new int[N][N];

            //initialize game
            map[N / 2 - 1][N / 2 - 1] = W;
            map[N / 2 - 1][N / 2] = B;
            map[N / 2][N / 2 - 1] = B;
            map[N / 2][N / 2] = W;

            //logic
            for (int i = 0; i < M; i++) {
                int r = sc.nextInt() - 1;
                int c = sc.nextInt() - 1;
                int stone = sc.nextInt();

                locateStone(map, stone, r, c);
            }

            //calculate result
            int[] result = new int[3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) {
                        continue;
                    }

                    if (map[i][j] == B) {
                        result[B]++;
                    } else {
                        result[W]++;
                    }
                }
            }

            System.out.println("#" + tc + " " + result[B] + " " + result[W]);
        }
    }

    static void locateStone(int[][] map, int stone, int r, int c) {
        for (int i = 0; i < dr.length; i++) {
            int idx = 1;

            while (true) {
                int nr = r + idx * dr[i];
                int nc = c + idx * dc[i];

                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map.length) {
                    break;
                }

                if (map[nr][nc] == 0) {
                    break;
                }

                if (stone == B) {
                    if (map[nr][nc] == W) {
                        idx++;
                    } else {
                        if (idx == 1) {
                            break;
                        }

                        map[r][c] = B;
                        for (int j = 1; j < idx; j++) {
                            map[r + j * dr[i]][c + j * dc[i]] = B;
                        }
                        break;
                    }
                } else {
                    if (map[nr][nc] == B) {
                        idx++;
                    } else {
                        if (idx == 1) {
                            break;
                        }

                        map[r][c] = W;
                        for (int j = 1; j < idx; j++) {
                            map[r + j * dr[i]][c + j * dc[i]] = W;
                        }
                        break;
                    }
                }
            }

//            for (int[] ints : map) {
//                for (int anInt : ints) {
//                    System.out.print(anInt + " ");
//                }
//                System.out.println();
//            }
        }
    }
}
