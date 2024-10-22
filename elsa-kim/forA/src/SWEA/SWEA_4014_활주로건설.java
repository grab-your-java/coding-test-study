package SWEA;

import java.util.Scanner;

public class SWEA_4014_활주로건설 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int size = sc.nextInt();
			int X = sc.nextInt();
			int[][] arr = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int ans = 0;
			next: for (int i = 0; i < size; i++) {
				int now = arr[i][0];
				int cnt = 1;
				for (int j = 1; j < size; j++) {
					if (arr[i][j] == now)
						cnt++;
					else if (Math.abs(arr[i][j] - now) >= 2)
						continue next;
					else if (arr[i][j] - now == 1) {
						if (cnt < X)
							continue next;
						cnt = 1;
						now = arr[i][j];
					} else {
						if (cnt < 0)
							continue next;
						now = arr[i][j];
						cnt = -X + 1;
					}
				}
				if (cnt >= 0) {
					ans++;
				}
			}
			next: for (int i = 0; i < size; i++) {
				int now = arr[0][i];
				int cnt = 1;
				for (int j = 1; j < size; j++) {
					if (arr[j][i] == now)
						cnt++;
					else if (Math.abs(arr[j][i] - now) >= 2)
						continue next;
					else if (arr[j][i] - now == 1) {
						if (cnt < X)
							continue next;
						cnt = 1;
						now = arr[j][i];
					} else {
						if (cnt < 0)
							continue next;
						now = arr[j][i];
						cnt = -X + 1;
					}
				}
				if (cnt >= 0) {
					ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}
