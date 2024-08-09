package swea.D2;

import java.util.Scanner;

// 어디에 단어가 들어갈 수 있을까
public class SWEA_1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1) {
						int sum = 0;
						while (j < n && arr[i][j] == 1) {
							sum++;
							j++;
						}
						if (sum == k)
							cnt++;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[j][i] == 1) {
						int sum = 0;
						while (j < n && arr[j][i] == 1) {
							sum++;
							j++;
						}
						if (sum == k)
							cnt++;
					}

				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

}
