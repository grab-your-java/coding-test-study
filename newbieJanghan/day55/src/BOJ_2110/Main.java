package BOJ_2110;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), C = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int l = arr[0], r = arr[N - 1];
		while (l <= r) {
			int mid = (l + r) / 2;

			int prev = arr[0], cnt = 1;
			for (int i = 1; i < N; i++) {
				if (arr[i] - prev >= mid) {
					cnt++;
					prev = arr[i];
				}
			}
			
			System.out.println(l + " - " + r +", cnt: "  + cnt);
			
			if (cnt >= C) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		
		System.out.println(r);
	}
}
