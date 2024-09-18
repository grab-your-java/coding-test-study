package SWEA2105;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int result;
    static int[] dr = {-1, 1, 1, -1};//우상, 우하, 좌하, 좌상
    static int[] dc = {1, 1, -1, -1};
    static int[] length = {1, 1};
    static int[][] cycle = {{0, 0}, {1, 0}, {-1, 1}, {1, 1}};
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            result = 0;

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    searching(map, i, j);
                }
            }

            System.out.println("#" + tc + " " + (result == 0 ? -1 : result));
        }
    }

    static void searching(int[][] map, int r, int c) {
        List<Integer> list = new ArrayList<>();


    }
}
