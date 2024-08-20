import java.util.Scanner;

public class BOJ3985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int people = sc.nextInt();
        int[] rollCake = new int[L];

        int[] expectedPieces = new int[people];
        int[] givenPieces = new int[people];

        int diffMaxIdx = 0;
        int cntMaxIdx = 0;

        for (int i = 0; i < people; i++) {
            int startIdx = sc.nextInt() - 1;
            int endIdx = sc.nextInt() - 1;

            expectedPieces[i] = endIdx - startIdx;

            if (expectedPieces[i] > expectedPieces[diffMaxIdx]) {
                diffMaxIdx = i;
            }

            for (int j = startIdx; j <= endIdx; j++) {
                if (rollCake[j] == 0) {
                    rollCake[j] = i + 1;
                    givenPieces[i]++;
                }
            }

            if (givenPieces[i] > givenPieces[cntMaxIdx]) {
                cntMaxIdx = i;
            }
        }

        System.out.println(diffMaxIdx + 1);
        System.out.println(cntMaxIdx + 1);
    }
}
