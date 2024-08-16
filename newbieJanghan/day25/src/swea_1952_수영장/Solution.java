package swea_1952_수영장;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= T; t++) {
			int[] pricesByPlan = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] visitDaysByMonth = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			System.out.println("#" + t + " " + new Calculator(pricesByPlan, visitDaysByMonth).exec());
		}
	}

	private static class Calculator {
		private int[] pricesByPlan;
		private int[] visitDaysByMonth;
		private int minPrice = Integer.MAX_VALUE;

		Calculator(int[] pricesByPlan, int[] visitDaysByMonth) {
			this.pricesByPlan = pricesByPlan;
			this.visitDaysByMonth = visitDaysByMonth;
		}

		int exec() {
			dfs(new int[12], 0, 0);
			return minPrice;
		}

		void dfs(int[] plansByMonth, int monthDepth, int planIterator) {
			// calculate
			if (monthDepth == plansByMonth.length) {
				int totalPrice = 0;
//				System.out.println(Arrays.toString(plansByMonth));

				for (int month = 0; month < plansByMonth.length; month++) {
					int days = visitDaysByMonth[month];
					if (days == 0) {
						continue;
					}
					int plan = plansByMonth[month];
					int price = pricesByPlan[plan];

					switch (plan) {
					case 0: // day by day
						totalPrice += price * days;
						break;
					case 1: // for a month
						totalPrice += price;
						break;
					case 2: // for three months
						totalPrice += price;
						month += 2;
						break;
					default: // case 3. for a year
						totalPrice = price;
						break;

					}
				}
//				System.out.println("total: " + totalPrice);
				minPrice = Math.min(minPrice, totalPrice);

				return;
			}

			if (visitDaysByMonth[monthDepth] == 0) {
				dfs(plansByMonth, monthDepth + 1, planIterator);
			} else {
				for (int plan = planIterator; plan < pricesByPlan.length; plan++) {
//					System.out.println("----------");
//					System.out.println("*** depth: " + monthDepth);
//					System.out.println("*** plan iterating from: " + planIterator + " to: " + plan);
					plansByMonth[monthDepth] = plan;
					dfs(plansByMonth, monthDepth + 1, planIterator);
				}
			}

		}
	}
}
