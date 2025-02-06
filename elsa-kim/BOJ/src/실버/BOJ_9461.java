package 실버;

import java.util.Scanner;

public class BOJ_9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				if (i < 3)
					arr[i] = 1;
				else if (i < 5)
					arr[i] = 2;
				else
					arr[i] = arr[i - 1] + arr[i - 5];
			}
			System.out.println(arr[n-1]);

		}

	}

}
