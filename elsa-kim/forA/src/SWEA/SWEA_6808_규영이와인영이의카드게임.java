package SWEA;

import java.util.Scanner;

public class SWEA_6808_규영이와인영이의카드게임 {
	static boolean[] check;
	static int[] kyu, in;
	static int win, lose;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			check = new boolean[19];
			kyu = new int[9];
			in = new int[9];
			win = 0;
			lose = 0;
			for (int i = 0; i < 9; i++) {
				kyu[i] = sc.nextInt();
				check[kyu[i]] = true;
			}
			per(0);
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}

	private static void per(int cnt) {
		if (cnt == 9) {
			int kyuSum = 0;
			int inSum = 0;
			for (int i = 0; i < 9; i++) {
				if (kyu[i] > in[i])
					kyuSum += kyu[i] + in[i];
				if (kyu[i] < in[i])
					inSum += kyu[i] + in[i];
			}
			if (kyuSum > inSum)
				win++;
			if (kyuSum < inSum)
				lose++;
			return;
		}
		for (int i = 1; i < 19; i++) {
			if (!check[i]) {
				check[i] = true;
				in[cnt] = i;
				per(cnt + 1);
				check[i] = false;
			}
		}

	}

}
