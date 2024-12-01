import java.util.Scanner;

public class BOJ_9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();

			long[] dp = new long[101];
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			dp[5] = 2;
			dp[6] = 3;
			dp[7] = 4;
			dp[8] = 5;
			dp[9] = 7;
			dp[10] = 9;
			for (int i = 6; i < 101; i++) {
				// dp[6] = dp[1] + dp[5];1
				
				// 3 = 1 + 2
				dp[i] = dp[i - 5] + dp[i - 1];
			}
				System.out.println(dp[N]);
		}
	}

}