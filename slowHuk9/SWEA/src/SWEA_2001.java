import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int i = 1; i <= testCase; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] map = new int[N][N];
			// 파리 채우기
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map.length; k++) {
					map[j][k] = sc.nextInt();
				}
			}
			int[] result = new int[(N - M + 1) * (N - M + 1)];
			int index = 0;
			for (int k = 0; k < N - M + 1; k++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0;
					for (int l = 0; l < M; l++) {
						for (int r = 0; r < M; r++) {
							sum += map[j + l][k + r];

						}
					}
					result[index++] = sum;
				}
			}
			Arrays.sort(result);
			System.out.println("#" + i + " " + result[result.length - 1]);
		}
	}

}
