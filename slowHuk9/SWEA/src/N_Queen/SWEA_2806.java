package N_Queen;
import java.util.Scanner;

public class SWEA_2806 {
	static int N;
	static boolean[][] visited;
	static int cnt;
	static int[] dr = { 0, -1, 1, 1, -1 };
	static int[] dc = { 0, 1, 1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			cnt = 0;
			visited = new boolean[N][N];
			queen(0, 0);
			System.out.println("#"+ tc + " " + cnt);

		}
	}

	static void queen(int depth, int r) {
		if (depth == N) {
			cnt++; 
			return;
		}
		for (int col = 0; col < N; col++) {
			if (isSafe(r, col)) {
				placeQueen(r, col);
				queen(depth + 1, r + 1);
				placeQueenReverse(r, col);
			}
		}

	}

	static boolean isSafe(int r, int c) {
		for (int i = 0; i < N; i++) {
			if (visited[i][c])
				return false;
		}
		for (int i = 1; i < 5; i++) {
			int nr = r;
			int nc = c;
			while (true) {
				nr += dr[i];
				nc += dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (visited[nr][nc]) {
						return false;
					}
				} else
					break;

			}

		}
		return true;
	}

	static void placeQueen(int r, int c) {
		visited[r][c] = true;
	}

	static void placeQueenReverse(int r, int c) {
		visited[r][c] = false;
	}

}
