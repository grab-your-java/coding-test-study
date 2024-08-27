import java.util.Scanner;

public class SWEA_4012 {
	static int T; // 테스트케이스
	static int N; // 식재료의 수
	static int K; // 뽑을 식재료의 수
	static int[][] sinergy;
	static boolean[] isSelected;
	static int minDiff;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = N / 2;
			isSelected = new boolean[N];
			sinergy = new int[N][N];
			minDiff = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sinergy[i][j] = sc.nextInt();
				}
			}
			combination(0, 0);
			System.out.println("#" + test_case + " " + minDiff);
		}
	}

	static void combination(int start, int depth) {
		if (depth == K) {
			calculate();
			return;
		}

		if (start == N)
			return;

		isSelected[start] = true;
		combination(start + 1, depth + 1);

		isSelected[start] = false;
		combination(start + 1, depth);

	}

	static void calculate() {
		int food1 = 0, food2 = 0;

		for (int i = 0; i < isSelected.length - 1; i++) {
			for (int j = i + 1; j < isSelected.length; j++) {

				if (isSelected[i] && isSelected[j]) {
					food1 += sinergy[i][j] + sinergy[j][i];

				} else if (!isSelected[i] && !isSelected[j]) {
					food2 += sinergy[i][j] + sinergy[j][i];
				}
			}
		}
		int diff = Math.abs(food1 - food2);
		if (diff < minDiff) {
			minDiff = diff;
		}
	}

}