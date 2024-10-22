import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SWEA_6808 {
	static List<Integer> kyu = new ArrayList<>();
	static List<Integer> inyung = new ArrayList<>();
	static int winCount;
	static int loseCount;
	static boolean[] visited = new boolean[9];
	static int[] output = new int[9];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			kyu.clear();
			inyung.clear();

			for (int i = 0; i < 9; i++) {
				int cardNum = sc.nextInt();
				kyu.add(cardNum);
			}

			winCount = 0;
			loseCount = 0;
			for (int i = 1; i < 19; i++) {
				if (!kyu.contains(i)) {
					inyung.add(i);
				}
			}
			play(0);
			System.out.println("#" + tc + " " + winCount + " " + loseCount);
		}
	}

	static void play(int depth) {
		if (depth == 9) {
			int kyuScore = 0;
			int inyungScore = 0;
			for (int i = 0; i < 9; i++) {
				if (kyu.get(i) > output[i]) {
					kyuScore += kyu.get(i) + output[i];
				} else {
					inyungScore += kyu.get(i) + output[i];
				}
			}
			if (kyuScore > inyungScore)
				winCount++;
			if (kyuScore < inyungScore)
				loseCount++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				output[depth] = inyung.get(i);
				visited[i] = true;
				play(depth + 1);
				visited[i] = false;
			}
		}
	}
}