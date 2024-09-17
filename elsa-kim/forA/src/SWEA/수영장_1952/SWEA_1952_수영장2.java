package SWEA.수영장_1952;

import java.util.Arrays;
import java.util.Scanner;

// 부분집합 
public class SWEA_1952_수영장2 {
	static boolean[] check;
	static int min;
	static int[] plan;
	static int mD, dP, mP, m3P;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			dP = sc.nextInt();
			mP = sc.nextInt();
			m3P = sc.nextInt();
			int yP = sc.nextInt();
			min = yP;
			check = new boolean[12];
			plan = new int[12];
			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}
			mD = mP / dP; // 한달권 구매할 최소일수
			if (mP % dP != 0)
				mD++;

			com(0);

			System.out.println("#" + tc + " " + min);
		}
	}

	private static void com(int cnt) {
		if (cnt >= 10) {
			int[] checkPlan = Arrays.copyOf(plan, 12);
			int price = 0;
			for (int i = 0; i < 10; i++) {
				if (check[i]) {
					price+=m3P;
					checkPlan[i] = 0;
					checkPlan[i + 1] = 0;
					checkPlan[i + 2] = 0;
				}
				
			}
			for (int i = 0; i < 12; i++) {
				if (checkPlan[i] >= mD) {
					price += mP;
				} else {
					price += checkPlan[i] * dP;
				}
			}
			if (price < min)
				min = price;
			return;
		}
		
		check[cnt] = true;
		com(cnt + 3);
		
		check[cnt] = false;
		com(cnt + 1);

	}

}
