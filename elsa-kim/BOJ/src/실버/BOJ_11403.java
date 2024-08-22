package 실버;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11403 {
	static int[][] arr;
	static int[][] resArr;
	static boolean[] check;

	public static void dfs(int i, int j) {
		resArr[i][j] = 1;
		check[j] = true;
		for (int k = 0; k < check.length; k++) {
			if (arr[j][k] == 1 && !check[k]) {
				dfs(i, k);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		arr = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		resArr = Arrays.copyOf(arr, size);
		for (int i = 0; i < size; i++) {
			check = new boolean[size];
			for (int j = 0; j < size; j++) {
				if (arr[i][j] == 1) {
					dfs(i, j);
				}
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(resArr[i][j]);
				if (j != size - 1) {
					System.out.print(" ");
				}

			}
			System.out.println();
		}

	}

}
