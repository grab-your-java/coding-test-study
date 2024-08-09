package swea.D4;

import java.util.Scanner;

public class SWEA_1210 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;

		for (int test_case = 1; test_case <= 10; test_case++) {
			T = sc.nextInt();
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int idx = 0;
			for (int i = 0; i < 100; i++) {
				if (arr[99][i] == 2) {
					idx = i;
					break;
				}
			}
			for (int i = 98; i >= 0; i--) {
				if (idx - 1 >= 0 && arr[i][idx - 1] == 1) {
					while (idx - 1 >= 0 && arr[i][idx - 1] == 1) {
						idx--;
					}
				} else if (idx + 1 < 100 && arr[i][idx + 1] == 1) {
					while (idx + 1 < 100 && arr[i][idx + 1] == 1) {
						idx++;
					}
				}
			}
			System.out.println("#" + test_case + " " + idx);
		}

	}
}
