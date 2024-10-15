package SWEA1226;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int result;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            sc.nextInt();

            result = 0;

            String[][] input = new String[16][];

            for (int i = 0; i < input.length; i++) {
                input[i] = sc.next().split("");
            }

            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    if (input[i][j].equals("2")) {
                        dfs(input, i, j);
                    }
                }
            }

            for (String[] strings : input) {
                System.out.println(Arrays.toString(strings));
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ").append(result);
            System.out.println(sb);
        }
    }

    static void dfs(String[][] input, int i, int j) {
        for (int k = 0; k < dr.length; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (nr < 0 || nc < 0 || nr >= input.length || nc >= input[0].length) {
                continue;
            }

            if (input[nr][nc].equals("1") || input[nr][nc].equals("2") || input[nr][nc].equals("4")) {
                continue;
            }

            if (input[nr][nc].equals("3")) {
                result = 1;
                return;
            }

            input[nr][nc] = "4";
            dfs(input, nr, nc);
        }
    }
}
