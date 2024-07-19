import java.util.Scanner;

public class JUNGOL1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] parity = new int[2][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                parity[0][j] += arr[j][i]; //행
                parity[1][j] += arr[i][j]; //열
            }
        }

        boolean isParity = true;
        int notEven = 0;
        int r = -1;
        int c = -1;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                if (parity[i][j] % 2 != 0) {
                    if (i == 0) {
                        r = j;
                    } else {
                        c = j;
                    }
                    notEven++;
                    isParity = false;
                }
            }
        }

        if (isParity) {
            System.out.println("OK");
            return;
        } else if (notEven != 2 || r == -1 || c == -1) {
            System.out.println("Corrupt");
        } else {
            System.out.println("Change bit (" + (r + 1) + "," + (c + 1) + ")");
        }
    }
}
