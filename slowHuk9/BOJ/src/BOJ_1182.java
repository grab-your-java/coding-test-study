import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1182 {
	static int N, target;
	static int[] nums;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		target = sc.nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		Subsequence(0, 0);

		if (target == 0) {
			System.out.println(cnt - 1);
		} else {
			System.out.println(cnt);
		}
	}

	static void Subsequence(int depth, int sum) {
		if (depth == N) {
			if (sum == target) {
				cnt++;
			}
			return;
		}

		Subsequence(depth + 1, sum + nums[depth]);
		Subsequence(depth + 1, sum);
	}

}
