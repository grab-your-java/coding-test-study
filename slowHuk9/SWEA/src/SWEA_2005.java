import java.util.Scanner;

public class SWEA_2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] pascal = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if (i == j) {
						pascal[i][j] = 1;
					} else if (j == 0) {
						pascal[i][j] = 1;
					} else {
						pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
					}
				}
			}

			System.out.println("#" + test_case);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(pascal[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}