import java.util.Scanner;

public class BOJ2567 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] row = new int[N];
        int[] col = new int[N];

        for (int i = 0; i < N; i++) {
            col[i] = sc.nextInt();
            row[i] = sc.nextInt(); 
        }

        int[][] arr = new int[101][101];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

            }
        }

        int rowMin = row[0];
        int rowMax = 0;
        int colMin = col[0];
        int colMax = 0;
        for (int i = 0; i < N; i++) {
            if (rowMin > row[i]) {
                rowMin = row[i];
            }
            if (rowMax < row[i]) {
                rowMax = row[i];
            }
            if (colMin > col[i]) {
                colMin = col[i];
            }
            if (colMax < col[i]) {
                colMax = col[i];
            }
        }

        rowMax += 10;
        colMax += 10;

        int sum = 0;

        sum += 2 * ((rowMax - rowMin) + (colMax - colMin));

        System.out.println(sum);
    }
}
