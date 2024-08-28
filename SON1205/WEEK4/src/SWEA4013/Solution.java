package SWEA4013;

import java.util.Scanner;

public class Solution {
    static int[] magIdx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int K = sc.nextInt();

            int[][] magnet = new int[4][8];
            for (int i = 0; i < magnet.length; i++) {
                for (int j = 0; j < magnet[0].length; j++) {
                    magnet[i][j] = sc.nextInt();
                }
            }

            magIdx = new int[4];
            for (int i = 0; i < K; i++) {
                int magIdx = sc.nextInt();
                int rotate = sc.nextInt();

                rotateMagnet(magnet, magIdx, rotate);
            }

            int result = 0;
            for (int i = 0; i < 4; i++) {
                result += magnet[i][magIdx[i]] * Math.pow(2, i);
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    static void rotateMagnet(int[][] magnet, int idx, int rotate) {
        //rotate direction -> group (1, 3), group (2, 4)
        //checking available rotation
        boolean[] available = new boolean[3];

        for (int i = 0; i < 3; i++) {
            if (magnet[i][(magIdx[i] + 2) % 8] != magnet[i + 1][(magIdx[i + 1] + 6) % 8]) {
                available[i] = true;
            }
        }

        //move startIdx(magIdx)
        int maxIdx = idx - 1;
        int minIdx = idx - 1;

        while (true) {
            if (!(maxIdx + 1 < magnet.length && available[maxIdx])) {
                break;
            }
            maxIdx++;
        }

        while (true) {
            if (!(minIdx - 1 >= 0 && available[minIdx - 1])) {
                break;
            }
            minIdx--;
        }

        for (int i = minIdx; i <= maxIdx; i++) {
            if (i % 2 == (idx - 1) % 2) {
                magIdx[i] -= rotate;
            } else {
                magIdx[i] += rotate;
            }
        }

        for (int i = 0; i < magIdx.length; i++) {
            magIdx[i] = (magIdx[i] + 8) % 8;
        }
    }
}
