import java.util.Scanner;

public class SWEA_2817 {
	static int[] nums;
	static int N, K;
	static boolean[] sel;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			cnt = 0;
			N = sc.nextInt();
			K = sc.nextInt();
			nums = new int[N];
			sel = new boolean[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			powerSet(0);
			System.out.println("#" + test_case + " " + cnt);
		}
	}

	static void powerSet(int idx) {

		if (idx >= N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					sum += nums[i];
				}
			}
			if (sum == K)
				cnt++;
			return;
		}

		sel[idx] = true;
		powerSet(idx + 1);
		sel[idx] = false;
		powerSet(idx + 1);
	}
}