import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4013_2 {
	static int[][] magnetic = new int[5][8];
	static int[] arrow = new int[5]; // {0 , 0, 0 , 0, 0}
	static int N = magnetic[1].length;
	static boolean[] visited;
	static int score, K;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			K = sc.nextInt(); // 회전횟수
			for (int i = 1; i < 5; i++) {
				for (int j = 0; j < 8; j++) {
					magnetic[i][j] = sc.nextInt();
				}
			}
			score = 0;
			visited = new boolean[5];

			for (int i = 0; i < K; i++) {
				int selectMagnet = sc.nextInt(); // 회전시킬 자석 번호
				int direction = sc.nextInt(); // 회전 방향 / 1 시계 -1 반시계
				spin(selectMagnet, direction);
			}
			System.out.println("#" + tc + " " + calculate());
		}
	}

	static void spin(int i, int direction) {
		if (i < 1 || i > 4 || visited[i]) {
			return;
		}
		visited[i] = true;

		if (i > 1 && magnetic[i][6] != magnetic[i - 1][2] && !visited[i - 1]) {
			spin(i - 1, -direction);
		}

		if (i < 4 && magnetic[i][2] != magnetic[i + 1][6] && !visited[i + 1]) {
			spin(i + 1, -direction);
		}
		rotate(i, direction);
		visited[i] = false;
	}

	static void rotate(int i, int direction) {
		int[] tmp = new int[8];
		System.arraycopy(magnetic[i], 0, tmp, 0, magnetic[i].length);

		if (direction == 1) {
			magnetic[i][0] = tmp[7];
			System.arraycopy(tmp, 0, magnetic[i], 1, 7);
		} else if (direction == -1) {
			magnetic[i][7] = tmp[0];
			System.arraycopy(tmp, 1, magnetic[i], 0, 7);
		}
	}

	static int calculate() {
		score = 0;
		for (int i = 1; i < magnetic.length; i++) {
			if (i == 1 && magnetic[i][0] == 1) {
				score += magnetic[i][0] * 1;
			}
			if (i == 2 && magnetic[i][0] == 1) {
				score += magnetic[i][0] * 2;
			}
			if (i == 3 && magnetic[i][0] == 1) {
				score += magnetic[i][0] * 4;
			}
			if (i == 4 && magnetic[i][0] == 1) {
				score += magnetic[i][0] * 8;
			}
		}
		return score;
	}
}
