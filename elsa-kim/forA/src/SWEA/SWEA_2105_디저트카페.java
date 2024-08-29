package SWEA;

import java.util.Scanner;

public class SWEA_2105_디저트카페 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int size = sc.nextInt();
			int arr[][] = new int[size][size];
			int cnt = -1;
			boolean[] check = new boolean[101];

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < size - 2; i++) { // 사각형모양 되기 위해 밑 두칸 양옆 한칸 필요
				for (int j = 1; j < size - 1; j++) {
					if (arr[i][j] == arr[i + 1][j + 1] || arr[i][j] == arr[i + 1][j - 1]) // 좌우 대각선 밑(사각형 시작) 디저트 같으면
																							// 넘어감
						continue;
					for (int k = 1; k <= size - 1 - i; k++) { // k : 사각형 한 변 최대 사이즈

						if (j - k >= 0) {
							lRec: for (int m = 1; m <= k; m++) {
								if (i + k + m >= size || j + m >= size)
									break;
								int sum = 0;
								check = new boolean[101];

								for (int l = 1; l <= k; l++) {
									if (check[arr[i + l][j - l]])
										break lRec;
									sum++;
									check[arr[i + l][j - l]] = true;
								}
								for (int l = 1; l <= m; l++) {
									if (check[arr[i + k + l][j - k + l]])
										break lRec;
									sum++;
									check[arr[i + k + l][j - k + l]] = true;
								}
								for (int l = 1; l <= k; l++) {
									if (check[arr[i + k + m - l][j - k + m + l]])
										continue lRec;
									sum++;
									check[arr[i + k + m - l][j - k + m + l]] = true;
								}
								for (int l = 1; l <= m; l++) {
									if (check[arr[i + m - l][j + m - l]])
										break lRec;
									sum++;
									check[arr[i + m - l][j + m - l]] = true;
								}
								if (sum > cnt)
									cnt = sum;
							}

						}
						if (j + k < size) {
							rRec: for (int m = 1; m <= k; m++) {
								if (i + k + m >= size || j - m < 0)
									break;
								int sum = 0;
								check = new boolean[101];
								for (int l = 1; l <= k; l++) {
									if (check[arr[i + l][j + l]])
										break rRec;
									sum++;
									check[arr[i + l][j + l]] = true;
								}
								for (int l = 1; l <= m; l++) {
									if (check[arr[i + k + l][j + k - l]])
										break rRec;
									sum++;
									check[arr[i + k + l][j + k - l]] = true;
								}
								for (int l = 1; l <= k; l++) {
									if (check[arr[i + k + m - l][j + k - m - l]])
										continue rRec;
									sum++;
									check[arr[i + k + m - l][j + k - m - l]] = true;
								}
								for (int l = 1; l <= m; l++) {
									if (check[arr[i + m - l][j - m + l]])
										break rRec;
									sum++;
									check[arr[i + m - l][j - m + l]] = true;
								}
								if (sum > cnt)
									cnt = sum;
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);

		}
	}

}
