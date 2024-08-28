package swea.D3;

import java.util.Scanner;

public class SWEA_11315 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		next: for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] arr = new char[N][N];
			for (int i = 0; i < N; i++) {
				String line = sc.next();
				arr[i] = line.toCharArray();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 'o') {
						int k = 1;
						while (j + k < N && arr[i][j + k] == 'o') {
							k++;
							if (k >= 5) {
								System.out.println("#" + tc + " YES");
								continue next;
							}
						}
						k = 1;
						while (i + k < N && arr[i + k][j] == 'o') {
							k++;
							if (k >= 5) {
								System.out.println("#" + tc + " YES");
								continue next;
							}
						}
						k = 1;
						while (i + k < N && j + k < N && arr[i + k][j + k] == 'o') {
							k++;
							if (k >= 5) {
								System.out.println("#" + tc + " YES");
								continue next;
							}
						}
						k = 1;
						while (j - k >= 0 && i + k < N && arr[i + k][j - k] == 'o') {
							k++;
							if (k >= 5) {
								System.out.println("#" + tc + " YES");
								continue next;
							}
						}
					}
				}

			}
			System.out.println("#" + tc + " NO");
		}
	}
}
