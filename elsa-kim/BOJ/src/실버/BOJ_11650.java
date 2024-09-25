package 실버;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[][] arr = new int[cnt][2];
		for (int i = 0; i < cnt; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		for (int i = 0; i < cnt; i++) {
			System.out.print(arr[i][0] + " " + arr[i][1] + "\n");
		}
	}
}
