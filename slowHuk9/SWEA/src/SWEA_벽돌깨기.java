import java.util.Scanner;

public class SWEA_벽돌깨기 {
	static int minBricks; // 남아있는 최소 벽돌 수
	static int N, W, H;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); // 테스트 케이스 수

		for (int t = 1; t <= T; t++) {
			N = scanner.nextInt(); // 구슬을 떨어뜨릴 수 있는 횟수
			W = scanner.nextInt(); // 맵의 너비
			H = scanner.nextInt(); // 맵의 높이

			// 맵 입력 받기
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = scanner.nextInt();
				}
			}

			// 최소 벽돌 수 초기화
			minBricks = Integer.MAX_VALUE;

			// 벽돌 깨기 시뮬레이션 실행
			simulation(map, N);

			// 결과 출력
			int result = -1;
			if(minBricks == Integer.MAX_VALUE) result = 0;
			else {
				result = minBricks;
			}
			System.out.println("#" + t + " " + result);
		}

		scanner.close();
	}

	static void simulation(int[][] map, int n) {
		if (n == 0) {
			// 남아있는 벽돌 수를 세어서 최솟값 갱신
			int bricksLeft = countBricks(map);
			minBricks = Math.min(minBricks, bricksLeft);
			return;
		}


		// 각 열에 대해 구슬 떨어뜨리기 시도
		for (int j = 0; j < W; j++) {
			// 맵 복사
			int[][] newMap = copyMap(map);

			// 해당 열에서 가장 위의 벽돌 찾기
			int i = findTopBrick(newMap, j);
			if (i == -1)
				continue; // 해당 열에 벽돌이 없는 경우

			// 벽돌 깨기
			breakBrick(newMap, i, j);

			// 중력 적용
			down(newMap);

			// 남은 벽돌이 없으면 즉시 최소값을 0으로 설정하고 종료
			if (countBricks(newMap) == 0) {
				minBricks = 0;
				return;
			}

			// 다음 단계로 재귀 호출
			simulation(newMap, n - 1);
		}
	}

	static int findTopBrick(int[][] map, int j) {
		for (int i = 0; i < H; i++) {
			if (map[i][j] > 0) {
				return i; // 가장 위에 있는 벽돌의 위치 반환
			}
		}
		return -1; // 벽돌이 없는 경우
	}

	static void down(int[][] map) {
		for (int j = 0; j < W; j++) {
			int emptyRow = H - 1;
			for (int i = H - 1; i >= 0; i--) {
				if (map[i][j] > 0) {
					// 벽돌이 있으면 아래로 내리기
					map[emptyRow][j] = map[i][j];
					if (emptyRow != i) {
						map[i][j] = 0; // 원래 위치를 빈 공간으로
					}
					emptyRow--;
				}
			}
		}
	}

	static int[][] copyMap(int[][] map) {
		int[][] newMap = new int[H][W];
		for (int i = 0; i < H; i++) {
			newMap[i] = map[i].clone();
		}
		return newMap;
	}

	static int countBricks(int[][] map) {
		int count = 0;
		for (int[] row : map) {
			for (int brick : row) {
				if (brick > 0)
					count++;
			}
		}
		return count;
	}

	static void breakBrick(int[][] map, int i, int j) {
		int range = map[i][j] - 1;
		if (map[i][j] <= 0) {
			return;
		}
		map[i][j] = 0;

		for (int k = 1; k <= range; k++) {
			if (i - k >= 0 && map[i - k][j] > 0) {
				breakBrick(map, i - k, j);
			}
			if (i + k < H && map[i + k][j] > 0) {
				breakBrick(map, i + k, j);
			}
			if (j - k >= 0 && map[i][j - k] > 0) {
				breakBrick(map, i, j - k);
			}
			if (j + k < W && map[i][j + k] > 0) {
				breakBrick(map, i, j + k);
			}
		}
	}
}
