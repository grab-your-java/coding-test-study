import java.util.Scanner;

public class BOJ2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[101][101];

        for (int i = 0; i < N; i++) {
            int c = sc.nextInt();
            int r = sc.nextInt();

            for (int j = r; j < r + 10; j++) {
                for (int k = c; k < c + 10; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (arr[i][j] == 1) {
                    sum += 1;
                }
            }
        }

        System.out.println(sum);
    }
}
