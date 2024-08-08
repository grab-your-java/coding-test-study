import java.util.Scanner;

public class BOJ10163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] coordinates = new int[1001][1001];
        int[] cnts = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int deltaX = sc.nextInt();
            int deltaY = sc.nextInt();

            for (int j = startY; j < startY + deltaY; j++) {
                for (int k = startX; k < startX + deltaX; k++) {
                    if (coordinates[j][k] != 0) {
                        cnts[coordinates[j][k]]--;
                    }

                    coordinates[j][k] = i;
                    cnts[coordinates[j][k]]++;
                }
            }
        }
        for (int j = 1; j < N + 1; j++) {
            System.out.println(cnts[j]);
        }
    }
}
