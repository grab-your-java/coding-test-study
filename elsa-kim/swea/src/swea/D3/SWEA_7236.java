package swea.D3;

import java.util.Scanner;

public class SWEA_7236 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int max = 0;
			int size = sc.nextInt();
			String[][] arr = new String[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					arr[i][j] = sc.next();
				}
			}
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (arr[i][j].equals("W")) {
						int sum = 0;
						if (i - 1 >= 0 && arr[i - 1][j].equals("W"))
							sum++;
						if (j - 1 >= 0 && arr[i][j - 1].equals("W"))
							sum++;
						if (i - 1 >= 0 && j - 1 >= 0 && arr[i - 1][j - 1].equals("W"))
							sum++;
						if (i + 1 < size && arr[i + 1][j].equals("W"))
							sum++;
						if (j + 1 < size && arr[i][j + 1].equals("W"))
							sum++;
						if (i + 1 < size && j + 1 < size && arr[i + 1][j + 1].equals("W"))
							sum++;
						if (i - 1 >= 0 && j + 1 < size && arr[i - 1][j + 1].equals("W"))
							sum++;
						if (j - 1 >= 0 && i + 1 < size && arr[i + 1][j - 1].equals("W"))
							sum++;
						if (sum == 0)
							sum = 1;
						if (sum > max)
							max = sum;
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}

}
