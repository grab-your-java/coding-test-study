package SWEA6808;

import java.util.Scanner;

public class Solution {
    static boolean[] visited;
    static int[] output;
    static int win;
    static int lose;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int[] num1 = new int[9];

            visited = new boolean[18];

            for (int i = 0; i < num1.length; i++) {
                num1[i] = sc.nextInt();
                visited[num1[i] - 1] = true;
            }

            win = 0;
            lose = 0;
            output = new int[9];

            winOrLose(num1, 0);

            System.out.println("#" + tc + " " + win + " " + lose);
        }
    }

    static void winOrLose(int[] num1, int cnt) {
        if (cnt == 9) {
            int A = 0;
            int B = 0;

            for (int i = 0; i < 9; i++) {
                int tmp = num1[i] + output[i];
                if (num1[i] > output[i]) {
                    A += tmp;
                } else {
                    B += tmp;
                }
            }

            if (A > B) {
                win++;
            } else if (B > A) {
                lose++;
            }

            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[cnt] = i + 1;
                winOrLose(num1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
