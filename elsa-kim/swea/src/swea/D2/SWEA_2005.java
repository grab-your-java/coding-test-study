package swea.D2;

import java.util.Scanner;

//파스칼의 삼각형
public class SWEA_2005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int size = sc.nextInt();
			int[][] arr = new int[size][];
			for (int i = 0; i < size; i++) {
				arr[i] = new int[i + 1];
				arr[i][0] = 1;
				if (i - 1 >= 0) {
					for (int j = 1; j <= i / 2; j++) {
						if (j - 1 >= 0) {
							arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
						}
					}
				}
				for (int j = 0; j <= i / 2; j++) {
					arr[i][arr[i].length - 1 - j] = arr[i][j];
				}
			}
			System.out.println("#" + tc);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j]);
					if (j != arr[i].length - 1) {
						System.out.print(" ");
					}
				}
				System.out.println();

			}
		}
	}

}
