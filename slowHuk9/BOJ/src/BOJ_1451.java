import java.util.Scanner;

public class BOJ_1451 {
    static int N, M;
    static int[][] grid;
    static long[][] prefixSum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine(); // 다음 줄로 넘기기

        grid = new int[N + 1][M + 1];
        prefixSum = new long[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String row = scanner.nextLine();
            for (int j = 1; j <= M; j++) {
                grid[i][j] = row.charAt(j - 1) - '0';
                prefixSum[i][j] = grid[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        long result = 0;

        // 세로로 세 부분 나누기
        for (int c1 = 1; c1 < M; c1++) {
            for (int c2 = c1 + 1; c2 < M; c2++) {
                long left = sum(1, 1, N, c1);
                long middle = sum(1, c1 + 1, N, c2);
                long right = sum(1, c2 + 1, N, M);
                result = Math.max(result, left * middle * right);
            }
        }

        // 가로로 세 부분 나누기
        for (int r1 = 1; r1 < N; r1++) {
            for (int r2 = r1 + 1; r2 < N; r2++) {
                long top = sum(1, 1, r1, M);
                long middle = sum(r1 + 1, 1, r2, M);
                long bottom = sum(r2 + 1, 1, N, M);
                result = Math.max(result, top * middle * bottom);
            }
        }

        // 세로 두 부분, 가로로 나누기
        for (int c = 1; c < M; c++) {
            // 위쪽 세로로 나눈 후 가로로 두 부분 나누기
            long left = sum(1, 1, N, c);
            for (int r = 1; r < N; r++) {
                long topRight = sum(1, c + 1, r, M);
                long bottomRight = sum(r + 1, c + 1, N, M);
                result = Math.max(result, left * topRight * bottomRight);
            }

            // 아래쪽 세로로 나눈 후 가로로 두 부분 나누기
            long right = sum(1, c + 1, N, M);
            for (int r = 1; r < N; r++) {
                long topLeft = sum(1, 1, r, c);
                long bottomLeft = sum(r + 1, 1, N, c);
                result = Math.max(result, right * topLeft * bottomLeft);
            }
        }

        System.out.println(result);
        scanner.close();
    }

    static long sum(int r1, int c1, int r2, int c2) {
        return prefixSum[r2][c2] - prefixSum[r1 - 1][c2] - prefixSum[r2][c1 - 1] + prefixSum[r1 - 1][c1 - 1];
    }
}
