package 실버;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10819 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[] arr = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int max = 0;
		int idx = cnt / 2;

		if (cnt % 2 == 1) {
			int sum = 0;
			for (int i = 0; i < idx; i++) {
				sum += Math.abs(arr[idx + i] - arr[i]);
				sum += Math.abs(arr[idx + 1 + i] - arr[i]);
			}
			max = Math.max(max, sum);
			sum = 0;
			for (int i = 0; i < idx; i++) {
				sum += Math.abs(arr[cnt - i - 1] - arr[idx - 1 - i]);
				if (idx - 2 - i >= 0) {
					sum += Math.abs(arr[cnt - i - 1] - arr[idx - 2 - i]);
				}
			}
			sum += (arr[idx + 1] - arr[idx]);
			max = Math.max(max, sum);
			sum = 0;
			for (int i = 0; i < idx; i++) {
				sum += Math.abs(arr[idx + i + 1] - arr[i]);
				sum += Math.abs(arr[idx + 1 + i] - arr[i + 1]);
			}
			max = Math.max(max, sum);
			sum = 0;
			for (int i = 0; i < idx; i++) {
				sum += Math.abs(arr[idx + i + 1] - arr[i]);
				if (idx + i + 2 < cnt) {
					sum += Math.abs(arr[idx + i + 2] - arr[i]);
				}
			}
			sum += (arr[idx] - arr[idx - 1]);
			max = Math.max(max, sum);
		} else {
			int sum = 0;
			for (int i = 0; i < idx; i++) {
				sum += Math.abs(arr[idx + i] - arr[i]);
				if (idx + 1 + i < arr.length) {
					sum += Math.abs(arr[idx + 1 + i] - arr[i]);
				}
			}
			max = Math.max(max, sum);
			sum = 0;
			for (int i = 0; i < idx; i++) {
				sum += Math.abs(arr[idx + i] - arr[i]);
				if (1 + i < idx) {
					sum += Math.abs(arr[idx + i] - arr[i + 1]);
				}
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);

	}
}
