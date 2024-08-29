import java.util.Scanner;

public class SWEA_벽돌깨기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int times = sc.nextInt(); // 구슬 시도 횟수
			int width = sc.nextInt(); // 배열의 가로
			int height = sc.nextInt(); // 배열의 세로

			int[][] map = new int[height][width];
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			breakBrick(map, height, width, 2, 2); 

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}

		} // test_case for문
	}

	static void breakBrick(int[][] map, int width, int height, int i, int j) { // 벽돌 부수고 수만큼 spread.

		int spread = map[i][j] - 1; //
		if (spread < 0) { // map[i][j] 가 0 , 1 일때
			return;
		}
		// 깨진 벽돌로 처리해주기
		map[i][j] = 0;

		// map[i][j]가 2 이상일때
		for (int k = 1; k <= spread; k++) {
			if (i - k >= 0 && map[i - k][j] > 0) {
				breakBrick(map, height, width, i - k, j);
			}
			// 하
			if (i + k < height && map[i + k][j] > 0) {
				breakBrick(map, height, width, i + k, j);
			}
			// 좌..
			if (j - k >= 0 && map[i][j - k] > 0) {
				breakBrick(map, height, width, i, j - k);
			}
			// 우
			if (j + k < width && map[i][j + k] > 0) {
				breakBrick(map, height, width, i, j + k);
			}
		}

	}
}
