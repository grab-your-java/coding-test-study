import java.util.Scanner;

public class BOJ_11047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] coins = new int[N];
		int money = sc.nextInt();
		for (int i = 0; i < coins.length; i++) {
			coins[i] = sc.nextInt();
		}
		// 배수 관계라서 그리디
		int result = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (money >= coins[i]) {
				int cnt = money / coins[i];
				result += cnt;
				money %= coins[i];
			}
		}
		System.out.println(result);

	}

}
