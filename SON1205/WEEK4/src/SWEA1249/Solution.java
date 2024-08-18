package SWEA1249;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] line = sc.next().split("");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            
        }
    }

}
