package BOJ2578;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] input = makeBoard(sc);

        int[][] call = makeBoard(sc);

        boolean[] bingo = new boolean[12];

        int result = isBingo(input, call, bingo);

        System.out.println(result);
    }

    private static int isBingo(int[][] input, int[][] call, boolean[] bingo) {
        int tmp = 0;

        for (int i = 0; i < call.length; i++) {
            for (int j = 0; j < call[0].length; j++) {
                markingZero(input, call[i][j]);

                tmp += checkingBingo(input, bingo);

                if (tmp >= 3) {
                    return 5 * i + j + 1;
                }
            }
        }

        return 25;
    }

    private static int checkingBingo(int[][] input, boolean[] bingo) {
        int tmp = 0;

        for (int i = 0; i < bingo.length; i++) {
            if (!bingo[i]) {
                boolean isBingo = true;

                if (i < 5) {
                    for (int j = 0; j < input[0].length; j++) {
                        if (input[i][j] != 0) {
                            isBingo = false;
                            break;
                        }
                    }
                } else if (i < 10) {
                    for (int j = 0; j < input[0].length; j++) {
                        if (input[j][i - 5] != 0) {
                            isBingo = false;
                            break;
                        }
                    }
                } else if (i == 10) {
                    for (int j = 0; j < input.length; j++) {
                        if (input[4 - j][j] != 0) {
                            isBingo = false;
                            break;
                        }
                    }
                } else {
                    for (int j = 0; j < input.length; j++) {
                        if (input[j][j] != 0) {
                            isBingo = false;
                            break;
                        }
                    }
                }

                if (isBingo) {
                    bingo[i] = true;
                    tmp++;
                }
            }
        }

        return tmp;
    }

    private static void markingZero(int[][] input, int i) {
        for (int j = 0; j < input.length; j++) {
            for (int k = 0; k < input[0].length; k++) {
                if (input[j][k] == i) {
                    input[j][k] = 0;
                }
            }
        }
    }

    private static int[][] makeBoard(Scanner sc) {
        int[][] tmp = new int[5][5];

        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                tmp[i][j] = sc.nextInt();
            }
        }

        return tmp;
    }
}
