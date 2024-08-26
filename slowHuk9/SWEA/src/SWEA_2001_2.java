import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class SWEA_2001_2 {

	public static void fillMap(int[][] map, Scanner sc) {
		for (int j = 0; j < map.length; j++) {
			for (int k = 0; k < map.length; k++) {
				map[j][k] = sc.nextInt();
			}
		}
	}

	public static void killFly(int[][] map, int N, int M, int[] count) {
		int index = 0;
		for (int k = 0; k < N - M + 1; k++) {
			for (int j = 0; j < N - M + 1; j++) {
				int sum = 0;
				for (int r = 0; r < M; r++) {
					for (int l = 0; l < M; l++) {
						sum += map[j + r][k + l];
					}
				}
				count[index++] = sum;
			}
		}
	}

	public static int maxFly(int[] count) {
		Arrays.sort(count);
		return count[count.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int i = 1; i <= testCase; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] map = new int[N][N];

			fillMap(map, sc); // 파리 채우기

			int[] count = new int[(N - M + 1) * (N - M + 1)];
			killFly(map, N, M, count); // 죽인 파리 마릿수 구하기

			int result = maxFly(count);
			
			System.out.println("#" + i + " " + result);
		}

	}
}
