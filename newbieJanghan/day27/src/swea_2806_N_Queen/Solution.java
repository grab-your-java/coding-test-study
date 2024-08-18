package swea_2806_N_Queen;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
    static int N, count;
    static Deque<Integer>[][] board;
    static int[] dr = {-1, -1, 1, 1};
    static int[] dc = {-1, 1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            board = new ArrayDeque[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    board[r][c] = new ArrayDeque<>();
                    board[r][c].push(0);
                }
            }
            count = 0;

            check(1, 0);
            System.out.println("#" + t + " " + count);
        }
    }

    static void check(int round, int r) {
        if (round > N) {
            count++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (!available(r, c)) {
                continue;
            }
            set(r, c, round);
            check(round + 1, r + 1);
            unset(r, c, round);
        }
    }

    static boolean available(int r, int c) {
        return board[r][c].peek() == 0;
    }

    static void set(int r, int c, int round) {
        for (int tr = 0; tr < N; tr++) {
            for (int tc = 0; tc < N; tc++) {
                if (tr == r || tc == c) {
                    board[tr][tc].push(round);
                }
            }
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                board[nr][nc].push(round);
                nr += dr[d];
                nc += dc[d];
            }
        }
    }

    static void unset(int r, int c, int round) {
        for (int tr = 0; tr < N; tr++) {
            for (int tc = 0; tc < N; tc++) {
                if (tr == r || tc == c) {
                    if (board[tr][tc].peek() == round) {
                        board[tr][tc].pop();
                    }
                }
            }
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (board[nr][nc].peek() == round) {
                    board[nr][nc].pop();
                }
                nr += dr[d];
                nc += dc[d];
            }
        }
    }


}
