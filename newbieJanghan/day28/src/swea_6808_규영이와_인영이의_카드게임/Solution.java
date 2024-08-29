package swea_6808_규영이와_인영이의_카드게임;

import java.util.Scanner;

public class Solution {
	static int[] myCards;
	static int[] opCards;
	static boolean[] opThrowed;

	static int winCaseCnt;
	static int loseCaseCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			boolean[] picked = new boolean[19];
			myCards = new int[9];
			opCards = new int[9];

			for (int i = 0; i < myCards.length; i++) {
				int number = sc.nextInt();
				myCards[i] = number;
				picked[number] = true;
			}
			for (int number = 1, i = 0; number <= 19 && i < opCards.length; number++) {
				if (!picked[number]) {
					opCards[i++] = number;
				}
			}

			opThrowed = new boolean[19];
			winCaseCnt = 0;
			loseCaseCnt = 0;
			dfs(0, 0, 0);
			System.out.println("#" + t + " " + winCaseCnt + " " + loseCaseCnt);
		}
	}

	static void dfs(int round, int scoreA, int scoreB) {
		if (round == 9) {
			if (scoreA > scoreB) {
				winCaseCnt++;
			} else if (scoreA < scoreB) {
				loseCaseCnt++;
			}
			return;
		}

		for (int i = 0; i < opCards.length; i++) {
			int opNum = opCards[i];
			if (opThrowed[opNum]) {
				continue;
			}
			int myNum = myCards[round];

			opThrowed[opNum] = true;
			if (myNum > opNum) {
				dfs(round + 1, scoreA + myNum + opNum, scoreB);
			} else {
				dfs(round + 1, scoreA, scoreB + myNum + opNum);
			}
			opThrowed[opNum] = false;
		}
	}
}
