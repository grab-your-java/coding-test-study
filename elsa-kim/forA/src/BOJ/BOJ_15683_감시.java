package BOJ;

import java.util.Scanner;

public class BOJ_15683_감시 {
	static int[][] ori;
	static int H, W, min;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		ori = new int[H][W];
		min = H * W;
		int cnt = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				ori[i][j] = sc.nextInt();
				if (ori[i][j] > 0 && ori[i][j] < 6)
					cnt++;
			}
		}
		arr = new int[cnt];
		per(0);
		System.out.println(min);

	}

	// 0:상 1:하 2:좌 3:우
	private static void per(int cnt) {
		if (cnt == arr.length) {
			int[][] check = new int[H][W];
			for (int i = 0; i < H; i++) {
				check[i] = ori[i].clone();
			}

			int now = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (ori[i][j] > 0 && ori[i][j] < 6) {
						int k = 1;
						if (arr[now] == 0) {
							while (i - k >= 0 && check[i - k][j] != 6) {
								check[i - k][j] = -1;
								k++;
							}
							if (ori[i][j] == 2 || ori[i][j] == 5) {
								k = 1;
								while (i + k < H && check[i + k][j] != 6) {
									check[i + k][j] = -1;
									k++;
								}
							}
							if (ori[i][j] == 3 || ori[i][j] == 4 || ori[i][j] == 5) {
								k = 1;
								while (j + k < W && check[i][j + k] != 6) {
									check[i][j + k] = -1;
									k++;
								}
							}
							if (ori[i][j] == 4 || ori[i][j] == 5) {
								k = 1;
								while (j - k >= 0 && check[i][j - k] != 6) {
									check[i][j - k] = -1;
									k++;
								}
							}

						} else if (arr[now] == 1) {
							while (i + k < H && check[i + k][j] != 6) {
								check[i + k][j] = -1;
								k++;
							}
							if (ori[i][j] == 2 || ori[i][j] == 5) {
								k = 1;
								while (i - k >= 0 && check[i - k][j] != 6) {
									check[i - k][j] = -1;
									k++;
								}
							}
							if (ori[i][j] == 3 || ori[i][j] == 4 || ori[i][j] == 5) {
								k = 1;
								while (j - k >= 0 && check[i][j - k] != 6) {
									check[i][j - k] = -1;
									k++;
								}
							}
							if (ori[i][j] == 4 || ori[i][j] == 5) {
								k = 1;
								while (j + k < W && check[i][j + k] != 6) {
									check[i][j + k] = -1;
									k++;
								}

							}

						} else if (arr[now] == 2) {
							while (j - k >= 0 && check[i][j - k] != 6) {
								check[i][j - k] = -1;
								k++;
							}

							if (ori[i][j] == 2 || ori[i][j] == 5) {
								k = 1;
								while (j + k < W && check[i][j + k] != 6) {
									check[i][j + k] = -1;
									k++;
								}

							}
							if (ori[i][j] == 3 || ori[i][j] == 4 || ori[i][j] == 5) {
								k = 1;
								while (i - k >= 0 && check[i - k][j] != 6) {
									check[i - k][j] = -1;
									k++;
								}
							}
							if (ori[i][j] == 4 || ori[i][j] == 5) {
								k = 1;
								while (i + k < H && check[i + k][j] != 6) {
									check[i + k][j] = -1;
									k++;
								}

							}

						} else if (arr[now] == 3) {
							while (j + k < W && check[i][j + k] != 6) {
								check[i][j + k] = -1;
								k++;
							}

							if (ori[i][j] == 2 || ori[i][j] == 5) {
								k = 1;
								while (j - k >= 0 && check[i][j - k] != 6) {
									check[i][j - k] = -1;
									k++;
								}

							}
							if (ori[i][j] == 3 || ori[i][j] == 4 || ori[i][j] == 5) {
								k = 1;
								while (i + k < H && check[i + k][j] != 6) {
									check[i + k][j] = -1;
									k++;
								}
							}
							if (ori[i][j] == 4 || ori[i][j] == 5) {
								k = 1;
								while (i - k >= 0 && check[i - k][j] != 6) {
									check[i - k][j] = -1;
									k++;
								}
							}
						}
						now++;
					}
				}
			}
			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (check[i][j] == 0)
						count++;
				}

			}
			if (min > count)
				min = count;
			return;
		}
		for (int i = 0; i < 4; i++) {
			arr[cnt] = i;
			per(cnt + 1);
		}

	}
}
