import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2115 {
	static int N;
	static int M;
	static int C;
	static int[][] map;
	static boolean[][] visited;
	static int[] honeyFirst;
	static int[] honeySecond;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 벌통의 크기
			M = sc.nextInt(); // 한명의 일꾼이 선택하는 벌집의 수
			C = sc.nextInt(); // 벌꿀통에 담을 수 있는 꿀의 양
			honeyFirst = new int[M]; // 첫번째 일꾼이 고른 벌통
			honeySecond = new int[M];
			visited = new boolean[N][N];
			map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			select(0, 0);
		}
	}

	// 완전탐색 하면서 M의 갯수를 충족하도록 벌집 선택. 선택된 벌집들은 visited true.
	//
	static void select(int depth, int start) {
		if (depth == M) {
			System.out.println(Arrays.toString(honeyFirst));
			return;
		}
		for (int i = start; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (!visited[i][j]) {
					for (int k = 0; k < M; k++) {
						honeyFirst[depth + k] = map[i][j + k];
						visited[i][j + k] = true;
					}
					for (int k = 0; k < M; k++) {
						visited[i][j + k] = false;
					}
					if (N - M < M) {
						select(depth + M, i + 1);
					} else {
						select(depth + M, i);
					}
				}
			}
		}

	}

}
