package ddakjji;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        for (int r = 0; r < R; r++) {
            int aCount = sc.nextInt();
            int[] A = new int[4];
            while (aCount-- > 0) {
                int num = sc.nextInt();
                A[num - 1]++;
            }

            int bCount = sc.nextInt();
            int[] B = new int[4];
            while (bCount-- > 0) {
                int num = sc.nextInt();
                B[num - 1]++;
            }

            for (int i = 3; i >= 0; i--) {
                // star
                if (A[i] > B[i]) {
                    System.out.println("A");
                    break;
                } else if (B[i] > A[i]) {
                    System.out.println("B");
                    break;
                }
                if (i == 0) {
                    System.out.println("D");
                }
            }

        }
    }
}
