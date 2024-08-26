import java.util.Scanner;

public class SWEA_4698 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		// 에라토스테네스의 체를 이용한 소수 찾기
		int[] arr = new int[1000001];
		for (int i = 2; i < arr.length; i++) {
			int j = 2;
			while (true) {
				if (i * j > 1000000)
					break;
				arr[i * j] = 1;
				j++;
			}
		}

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int d = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			int cnt = 0;

			// 1은 소수가 아니므로 제외
			if (a == 1)
				a = 2;

			for (int i = a; i <= b; i++) {
				if (arr[i] == 0) {
					String s = String.valueOf(i);
					if (s.contains(String.valueOf(d)))
						cnt++;
				}
			}

			System.out.println("#" + test_case + " " + cnt);
		}
	}
}