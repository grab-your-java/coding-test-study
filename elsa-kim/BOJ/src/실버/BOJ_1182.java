package 실버;

import java.util.Scanner;

public class BOJ_1182 {
	static int N, want, ans;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		want = sc.nextInt();
		arr = new int[N];
		ans = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		getAns(0, 0, 0);
		System.out.println(ans);
	}

	private static void getAns(int idx, int cnt, int sum) {
		if (idx == N) {
			if (cnt != 0 && sum == want) {
				ans++;
			}
			return;
		}
		getAns(idx + 1, cnt + 1, sum + arr[idx]);
		getAns(idx + 1, cnt, sum);

	}

}
