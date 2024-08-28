import java.util.Arrays;
import java.util.Scanner;

public class SWEA_5215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int limit = sc.nextInt();

			int[] calories = new int[n]; //
			int[] tasteScore = new int[n]; //
			int[] caloriesOutput = new int[n];
			int[] ScoreOutput = new int[n];

			for (int i = 0; i < tasteScore.length; i++) {
				tasteScore[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}

			int maxScore = combination(tasteScore, calories, caloriesOutput, ScoreOutput, 0, 0, limit, 0, 0);
			System.out.println("#" + test_case + " " + maxScore);
		}
	}

	static int combination(int[] tasteScore, int[] calories, int[] caloriesOutput, int[] ScoreOutput, int start,
			int depth, int limit, int currentScore, int maxScore) {

		// 현재까지의 칼로리 합 계산
		int calorieSum = 0;
		for (int i = 0; i < depth; i++) {
			calorieSum += caloriesOutput[i];
		}

		// 칼로리 합이 제한을 넘으면 리턴
		if (calorieSum > limit) {
			return maxScore;
		}

		maxScore = Math.max(maxScore, currentScore);

		for (int i = start; i < calories.length; i++) {
			ScoreOutput[depth] = tasteScore[i];
			caloriesOutput[depth] = calories[i];

			maxScore = combination(tasteScore, calories, caloriesOutput, ScoreOutput, i + 1, depth + 1, limit,
					currentScore + tasteScore[i], maxScore);

		}
		return maxScore;
	}

}
