package swea_1238;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			int inputCnt = sc.nextInt();
			int start = sc.nextInt();

			int[][] adjArr = new int[102][102];
			boolean[] visited = new boolean[102];
			while (inputCnt > 0) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				inputCnt -= 2;
				adjArr[from][to] = 1;
			}

			Queue<Integer> queue = new LinkedList<>();
			int round = 0;
			int maxNum = 0;

			queue.add(round); // round
			queue.add(start);
			visited[start] = true;

			while (!queue.isEmpty()) {
				int curRound = queue.poll();
				int from = queue.poll();

				if (curRound > round) {
					round = curRound;
					maxNum = from;
				}
				
				if (round == curRound && maxNum < from) {
					maxNum = from;
				}

				for (int i = 0; i < adjArr.length; i++) {
					if (!visited[i] && adjArr[from][i] == 1) {
						queue.add(curRound + 1);
						queue.add(i);
						visited[i] = true;
					}
				}
			}

			sb.append(maxNum).append("\n");

		}
		System.out.println(sb);
	}
}
