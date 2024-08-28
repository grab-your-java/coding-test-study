package SWEA_4047;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		tc: for (int test_case = 1; test_case <= T; test_case++) {
			int[] S = new int[14];
			int[] D = new int[14];
			int[] H = new int[14];
			int[] C = new int[14];
			S[0] = 1;
			D[0] = 1;
			H[0] = 1;
			C[0] = 1;
			String s = sc.next();
			for (int i = 0; i < s.length(); i += 3) {
				String card = s.substring(i, i + 3);
				if (card.charAt(0) == 'S') {
					int num = Integer.parseInt(card.substring(1));
					S[num]++;
				}
				if (card.charAt(0) == 'D') {
					int num = Integer.parseInt(card.substring(1));
					D[num]++;
				}
				if (card.charAt(0) == 'H') {
					int num = Integer.parseInt(card.substring(1));
					H[num]++;
				}
				if (card.charAt(0) == 'C') {
					int num = Integer.parseInt(card.substring(1));
					C[num]++;
				}
			}
			for (int i = 0; i < S.length; i++) {
				if (S[i] >= 2 || D[i] >= 2 || H[i] >= 2 || C[i] >= 2) {
					System.out.println("#" + test_case + " ERROR");
					continue tc;
				}
			}

			int[] result = new int[4]; // S D H C의 부족한 카드 갯수
			for (int i = 0; i < S.length; i++) {
				if (S[i] == 0)
					result[0]++;
				if (D[i] == 0)
					result[1]++;
				if (H[i] == 0)
					result[2]++;
				if (C[i] == 0)
					result[3]++;
			}
			System.out.println("#" + test_case + " " + result[0] + " " + result[1] + " " + result[2] + " " + result[3]);

		}
	}

}
