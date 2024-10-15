package BOJ_2578;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rows = new int[5], cols = new int[5], diagonals = new int[2];
        int[][] indices = new int[26][2];

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                int number = sc.nextInt();
                indices[number] = new int[]{r, c};
            }
        }

        int count = 0;
        int round = 0;
        while (round++ < 25) {
            int[] index = indices[sc.nextInt()];
            int r = index[0], c = index[1];

            if (++rows[r] == 5) {
                count++;
            }

            if (++cols[c] == 5) {
                count++;
            }

            if (r == c && ++diagonals[0] == 5) {
                count++;
            }

            if (r + c == 4 && ++diagonals[1] == 5) {
                count++;
            }

            if (count >= 3) {
                break;
            }
        }

        System.out.println(round);
    }
}
