import java.util.Scanner;

public class BOJ14696 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int[] scoreA = new int[4];
            for (int j = 0; j < A; j++) {
                scoreA[sc.nextInt() - 1]++;
            }

            int B = sc.nextInt();
            int[] scoreB = new int[4];
            for (int j = 0; j < B; j++) {
                scoreB[sc.nextInt() - 1]++;
            }

            for (int j = 3; j >= 0; j--) {
                if (scoreA[j] == scoreB[j]) {
                    if (j == 0) {
                        System.out.println("D");
                    }
                } else {
                    if (scoreA[j] > scoreB[j]) {
                        System.out.println("A");
                        break;
                    }
                    System.out.println("B");
                    break;
                }
            }
        }
    }
}
