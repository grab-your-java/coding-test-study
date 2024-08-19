import java.util.Scanner;

public class SWEA_1979 {
	static int[][] map;
	static int n;
	static int k;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			k = sc.nextInt();
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int row = rowCheck();
			int col = colCheck();
			int result = row + col;
			System.out.println("#" + test_case + " " + result);
		}
	}

	// 011...10 갯수 세기
	static int rowCheck() {
		int result = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 1) {
					int sum = 0;
					while (j < map.length && map[i][j] == 1) {
						sum++;
						j++;
					}
					if (sum == k) {
						result++;
					}
				}
			}
		}
		return result;
	}

	static int colCheck() {
		int result = 0;
		for (int j = 0; j < map.length; j++) {
			for (int i = 0; i < map.length; i++) {
				if (map[i][j] == 1) {
					int sum = 0;
					while (i < map.length && map[i][j] == 1) {
						sum++;
						i++;
					}
					if (sum == k) {
						result++;
					}
				}
			}
		}
		return result;
	}
}
