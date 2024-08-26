package swea.D3;

import java.util.Scanner;

public class SWEA_4047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		next: for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int s = str.split("S").length - 1;
			int d = str.split("D").length - 1;
			int h = str.split("H").length - 1;
			int c = str.split("C").length - 1;

			int[][] arr = new int[4][13]; // {{s인 애들}, {d인 애들}, {h인 애들}, {c인 애들}}
			for (int i = 0; i < str.length() / 3; i++) {
				if (str.substring(i * 3, i * 3 + 1).equals("S")) {
					arr[0][Integer.parseInt(str.substring(i * 3 + 1, i * 3 + 3)) - 1]++;
				} else if (str.substring(i * 3, i * 3 + 1).equals("D")) {
					arr[1][Integer.parseInt(str.substring(i * 3 + 1, i * 3 + 3)) - 1]++;
				} else if (str.substring(i * 3, i * 3 + 1).equals("H")) {
					arr[2][Integer.parseInt(str.substring(i * 3 + 1, i * 3 + 3)) - 1]++;
				} else if (str.substring(i * 3, i * 3 + 1).equals("C")) {
					arr[3][Integer.parseInt(str.substring(i * 3 + 1, i * 3 + 3)) - 1]++;
				}
			}
			System.out.print("#" + tc);
			int sCnt = 0;
			int dCnt = 0;
			int hCnt = 0;
			int cCnt = 0;
			for (int i = 0; i < 13; i++) {
				if (arr[0][i] > 1 || arr[1][i] > 1 || arr[2][i] > 1 || arr[3][i] > 1) {
					System.out.print(" ERROR");
					System.out.println();
					continue next;
				}
				if (arr[0][i] == 0)
					sCnt++;
				if (arr[1][i] == 0)
					dCnt++;
				if (arr[2][i] == 0)
					hCnt++;
				if (arr[3][i] == 0)
					cCnt++;
			}
			System.out.printf(" %d %d %d %d", sCnt, dCnt, hCnt, cCnt);
			System.out.println();
		}
	}

}
