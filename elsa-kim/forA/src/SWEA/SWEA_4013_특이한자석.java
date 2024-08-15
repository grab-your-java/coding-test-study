package SWEA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_4013_특이한자석 {
	static List<List<Integer>> arr;
	static int wayOrder;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int order = sc.nextInt();
			arr = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				List<Integer> list = new ArrayList<>();
				for (int j = 0; j < 8; j++) {
					list.add(sc.nextInt());
				}
				arr.add(list);
			}

			for (int i = 0; i < order; i++) {
				int num = sc.nextInt();
				wayOrder = sc.nextInt();
				change(num);
			}
			System.out.println("#" + tc + " "
					+ (arr.get(0).get(0) * 1 + arr.get(1).get(0) * 2 + arr.get(2).get(0) * 4 + arr.get(3).get(0) * 8));
		}
	}

	private static void change(int num) {
		int changeWayR;
		int changeWayL;
		Integer ar = arr.get(0).get(2);
		Integer al = arr.get(0).get(6);
		Integer br = arr.get(1).get(2);
		Integer bl = arr.get(1).get(6);
		Integer cr = arr.get(2).get(2);
		Integer cl = arr.get(2).get(6);
		Integer dr = arr.get(3).get(2);
		Integer dl = arr.get(3).get(6);
		if (wayOrder == 1) {
			changeWayR = -1;
			changeWayL = -1;
		} else {
			changeWayR = 1;
			changeWayL = 1;
		}

		if (wayOrder == 1) {
			arr.get(num - 1).add(0, arr.get(num - 1).remove(7));
		} else {
			arr.get(num - 1).add(arr.get(num - 1).remove(0));
		}

		switch (num) {
		case 1:
			if (chainR(ar, 1, changeWayR)) {
				if (changeWayR == 1) {
					changeWayR = -1;
				} else {
					changeWayR = 1;
				}
				if (chainR(br, 2, changeWayR)) {
					if (changeWayR == 1) {
						changeWayR = -1;
					} else {
						changeWayR = 1;
					}
					chainR(cr, 3, changeWayR);
				}
			}
			break;
		case 2:
			chainL(bl, 0, changeWayL);
			if (chainR(br, 2, changeWayR)) {
				if (changeWayR == 1) {
					changeWayR = -1;
				} else {
					changeWayR = 1;
				}
				chainR(cr, 3, changeWayR);
			}
			break;
		case 3:
			chainR(cr, 3, changeWayR);
			if (chainL(cl, 1, changeWayL)) {
				if (changeWayL == 1) {
					changeWayL = -1;
				} else {
					changeWayL = 1;
				}
				chainL(bl, 0, changeWayL);
			}
			break;
		case 4:
			if (chainL(dl, 2, changeWayL)) {
				if (changeWayL == 1) {
					changeWayL = -1;
				} else {
					changeWayL = 1;
				}
				if (chainL(cl, 1, changeWayL)) {
					if (changeWayL == 1) {
						changeWayL = -1;
					} else {
						changeWayL = 1;
					}
					chainL(bl, 0, changeWayL);
				}
			}
			break;

		}

	}

	private static boolean chainL(Integer originInfo, int willNum, int way) {
		if (arr.get(willNum).get(2) == originInfo)
			return false;
		if (way == 1) {
			arr.get(willNum).add(0, arr.get(willNum).remove(7));
			return true;
		} else {
			arr.get(willNum).add(arr.get(willNum).remove(0));
			return true;
		}

	}

	private static boolean chainR(Integer originInfo, int willNum, int way) {
		if (arr.get(willNum).get(6) == originInfo)
			return false;
		if (way == 1) {
			arr.get(willNum).add(0, arr.get(willNum).remove(7));
			return true;
		} else {
			arr.get(willNum).add(arr.get(willNum).remove(0));
			return true;
		}

	}

}
