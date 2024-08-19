package swea_6808_규영이와_인영이의_카드게임;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static boolean[] picked;
	static Queue<Integer> queue;
	static int winCaseCnt = 0;
	static int loseCaseCnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			picked = new boolean[19]; // false indices are the other side numbers
			queue = new LinkedList<Integer>();

			int count = 9;
			while (count-- > 0) {
				int num = sc.nextInt();
				queue.add(num);
				picked[num] = true;
			}
			
			dfs(0, 0);
		}
	}

	static void dfs(int scoreA, int scoreB) {
		if (queue.isEmpty()) {
			if (scoreA < scoreB) {
				winCaseCnt++;
			} else if (scoreA > scoreB) {
				loseCaseCnt++;
			}
			return;
		}

		int aNumber = queue.poll();
		for (int bNumber = 1; bNumber <= 18; bNumber++) {
			if (picked[bNumber]) {
				continue;
			}
			
			System.out.println(aNumber + " vs " + bNumber);

			picked[bNumber] = true;
			if (aNumber > bNumber) {
				dfs(scoreA + aNumber + bNumber, scoreB);
			} else {
				dfs(scoreA, scoreB + aNumber + bNumber);
			}

			picked[bNumber] = false;
		}
	}
}
