package swea_2115_벌꿀채취;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] honeys = new int[N][N];
			int M = sc.nextInt();
			int C = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					honeys[i][j] = sc.nextInt();
				}
			}

			HoneyHarvest harvest = new HoneyHarvest(honeys, M, C);
			System.out.println("#" + t + " " + harvest.exec());
		}
	}

	static class ProfitCalculator {
		int[] profits;
		int profitLimit;
		int maxProfit = 0;

		ProfitCalculator(int profitLimit) {
			this.profitLimit = profitLimit;
		}

		int exec(int[] profits) {
			this.profits = profits;

			dfs(0, 0, 0);
			return maxProfit;
		}

		private void dfs(int start, int acc, int result) {
			if (start == profits.length) {
				return;
			}

			for (int i = start; i < profits.length; i++) {
				int cur = profits[i];
				if (acc + cur <= profitLimit) {
					maxProfit = Math.max(maxProfit, result + cur * cur);
					dfs(i + 1, acc + cur, result + cur * cur);
				}
			}
		}
	}

	static class HoneyHarvest {
		int N;
		int[][] honeys;
		int harvestSize;
		int profitLimit;
		int totalProfit = 0;

		HoneyHarvest(int[][] honeys, int M, int C) {
			this.N = honeys.length;
			this.honeys = honeys;
			this.harvestSize = M;
			this.profitLimit = C;
		}

		int exec() {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c + harvestSize <= N; c++) {
					ProfitCalculator calculator = new ProfitCalculator(profitLimit);

					// 1. pick A
					int[] partA = new int[harvestSize];
					for (int i = 0; i < harvestSize; i++) {
						partA[i] = honeys[r][c + i];
					}

					int aProfit = calculator.exec(partA);

					// 2. picking B
					int nr = r;
					int nc = c + harvestSize;
					if (nc + harvestSize > N) {
						nr++;
						nc = 0;
					}

					while (nr < N && nc < N) {
						int[] partB = new int[harvestSize];
						for (int i = 0; i < harvestSize; i++) {
							partB[i] = honeys[nr][nc + i];
						}

						int bProfit = calculator.exec(partB);
						totalProfit = Math.max(totalProfit, aProfit + bProfit);

						nc++;
						if (nc + harvestSize > N) {
							nr++;
							nc = 0;
						}
					}

				}
			}

			return totalProfit;
		}

	}
}
