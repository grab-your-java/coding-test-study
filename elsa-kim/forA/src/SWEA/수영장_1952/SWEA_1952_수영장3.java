package SWEA.수영장_1952;

import java.util.Scanner;

// DP
public class SWEA_1952_수영장3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[] cost = new int[4];
			for (int i = 0; i < 4; i++) {
				cost[i] = sc.nextInt();
			}
			int[] monthCost = new int[13];
			for (int i = 1; i < 13; i++) {
				monthCost[i] = sc.nextInt();
				monthCost[i] = Math.min(cost[0] * monthCost[i], cost[1]);
				monthCost[i] += monthCost[i - 1];
				if (i >= 3) {
					monthCost[i] = Math.min(monthCost[i - 3] + cost[2], monthCost[i]);
				}
			}

			System.out.println("#" + tc + " " + Math.min(monthCost[12], cost[3]));
		}
	}

}
