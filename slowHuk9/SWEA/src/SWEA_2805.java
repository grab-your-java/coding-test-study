import java.util.Scanner;

public class SWEA_2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int i = 1; i <= testCase; i++) {
			int n = sc.nextInt();

			int[][] map = new int[n][n];

			for (int j = 0; j < map.length; j++) {
				String s = sc.next();
				for (int k = 0; k < map.length; k++) {
					map[j][k] = s.charAt(k) - '0'; // 아스키코드를 활용하여 char를 정수로 변환
				}
			}

			int sum = 0;
			for (int j = 0; j < n / 2; j++) {
				for (int k = n / 2 - j; k <= n / 2 + j; k++) {
					sum += map[j][k];
				}
			}

			for (int j = n / 2; j < n / 2 + 1; j++) {
				for (int k = 0; k < map.length; k++) {
					sum += map[j][k];
				}
			}

			for (int j = n / 2 + 1; j < map.length; j++) {
				for (int k = n / 2 - (n - 1 - j); k <= n / 2 + (n - 1 - j); k++) {
					sum += map[j][k];
				}
			}

			System.out.println("#" + i + " " + sum);
		}

	}
}