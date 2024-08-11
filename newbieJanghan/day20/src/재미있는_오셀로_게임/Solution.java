package 재미있는_오셀로_게임;

import java.util.Scanner;

public class Solution {
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            board = new int[N + 2][N + 2];
            board[N / 2][N / 2] = 2; // White
            board[N / 2][N / 2 + 1] = 1; // Black
            board[N / 2 + 1][N / 2] = 1;
            board[N / 2 + 1][N / 2 + 1] = 2;

            int M = sc.nextInt();
            while (M-- > 0) {
                int x = sc.nextInt(), y = sc.nextInt(), color = sc.nextInt();
                board[y][x] = color;
                change(x, y, color);
            }

            int black = 0, white = 0;
            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    if (board[y][x] == 1) black++;
                    else if (board[y][x] == 2) white++;
                }
            }

            System.out.println("#" + i + " " + black + " " + white);
        }
    }

    public static void change(int x, int y, int color) {
        int targetColor = 3 - color;
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            while (board[ny][nx] == targetColor) {
                ny += dy[i];
                nx += dx[i];
                if (board[ny][nx] == color) {
                    while (ny != y || nx != x) {
                        ny -= dy[i];
                        nx -= dx[i];
                        if (board[ny][nx] == targetColor) {
                            board[ny][nx] = color;
                        }
                    }
                    break;
                }
            }

        }
    }
}
