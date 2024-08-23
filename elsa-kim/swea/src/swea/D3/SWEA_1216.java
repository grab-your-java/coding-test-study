package swea.D3;

import java.util.Scanner;

public class SWEA_1216 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			char[][] arr = new char[100][];
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.next().toCharArray();

			}

			int max = 0;

			next: for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (100 - j <= max)
						continue next;
					minus: for (int k = 99; k > j; k--) {
						if (arr[i][j] == arr[i][k]) {
							int leng = k - j + 1;
							int size = leng / 2;
							while (size > 0) {
								if (arr[i][j + size] != (arr[i][k - size]))
									continue minus;
								size--;
							}
							if (leng > max)
								max = leng;
						}
					}
					minus: for (int k = 99; k > j; k--) {
						if (arr[j][i] == arr[k][i]) {
							int leng = k - j + 1;
							int size = leng / 2;
							while (size > 0) {
								if (arr[j + size][i] != (arr[k - size][i]))
									continue minus;
								size--;
							}
							if (leng > max)
								max = leng;
						}
					}

				}

			}
			System.out.println("#" + t + " " + max);
		}
	}

}
