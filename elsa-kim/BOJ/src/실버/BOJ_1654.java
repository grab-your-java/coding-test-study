package 실버;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1654 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int want = sc.nextInt();
		int[] arr = new int[cnt];
		int ans = 0;
		for (int i = 0; i < cnt; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int made = 0;
		for (int i = 0; i < cnt; i++) {
			made = 0;
			ans = arr[i];
			for (int j = 0; j < cnt; j++) {
				made += arr[j] / ans;
			}
			if (made < want) {
				ans--;
				break;
			}
		}
		while (true) {
			made = 0;
			for (int i = 0; i < cnt; i++) {
				made += arr[i] / ans;
			}
			if (made >= want) {
				System.out.println(ans);
				break;
			} else {
				ans--;
			}
		}
	}
}
