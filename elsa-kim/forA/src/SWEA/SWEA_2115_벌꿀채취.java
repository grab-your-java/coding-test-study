package SWEA;

import java.util.Scanner;

public class SWEA_2115_벌꿀채취 {
	static int arrSize, honeySize, maxCan, maxMoney, totalMoney, start;
	static int[][] ori;
	static int[] arr;
	static boolean[] check, check2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			arrSize = sc.nextInt();
			honeySize = sc.nextInt();
			maxCan = sc.nextInt();
			ori = new int[arrSize][arrSize];
			for (int i = 0; i < arrSize; i++) {
				for (int j = 0; j < arrSize; j++) {
					ori[i][j] = sc.nextInt();
				}

			}
			arr = new int[2];
			maxMoney = 0;
			check = new boolean[arrSize * arrSize];
			com(0, 0);
			System.out.println("#" + tc + " " + maxMoney);
		}
	}

	private static void com(int cnt, int num) {
		if (cnt == 2) {

			int checkMoney = 0;
			int checkSum = 0;
			start = arr[0];
			totalMoney = 0;
			for (int i = 0; i < honeySize; i++) {
				checkSum += ori[start / arrSize][(start % arrSize) + i];
			}
			if (checkSum > maxCan) {
				check2 = new boolean[honeySize];
				choose(0, 0, 0);
			} else {
				for (int i = 0; i < honeySize; i++) {
					totalMoney += Math.pow(ori[(start) / arrSize][(start) % arrSize + i], 2);

				}

			}
			checkMoney += totalMoney;

			checkSum = 0;
			start = arr[1];
			totalMoney = 0;
			for (int i = 0; i < honeySize; i++) {
				checkSum += ori[start / arrSize][(start % arrSize) + i];
			}
			if (checkSum > maxCan) {
				check2 = new boolean[honeySize];
				choose(0, 0, 0);
			} else {
				for (int i = 0; i < honeySize; i++) {
					totalMoney += Math.pow(ori[(start) / arrSize][(start) % arrSize + i], 2);

				}

			}
			checkMoney += totalMoney;
			if (checkMoney > maxMoney)
				maxMoney = checkMoney;
			return;
		}

		for (int i = num; i < arrSize * arrSize; i++) {
			if (!check[i] && (i % arrSize) + honeySize <= arrSize) {
				check[i] = true;
				arr[cnt] = i;
				com(cnt + 1, i + honeySize);
				check[i] = false;
			}
		}

	}

	private static void choose(int cnt, int sum, int moneySum) {
		if (sum > maxCan)
			return;
		if (cnt == honeySize) {
			if (moneySum > totalMoney) {
				totalMoney = moneySum;
			}
			return;
		}
		check2[cnt] = true;
		choose(cnt + 1, sum + ori[(start) / arrSize][(start + cnt) % arrSize],
				(int) (moneySum + Math.pow(ori[(start) / arrSize][(start + cnt) % arrSize], 2)));
		check2[cnt] = false;
		choose(cnt + 1, sum, moneySum);
	}

}
