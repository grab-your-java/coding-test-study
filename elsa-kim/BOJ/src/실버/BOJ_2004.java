package 실버;

import java.util.Scanner;

public class BOJ_2004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 메모리 초과 코드
//		int[][] list = new int[n + 1][2];
//		int k, cnt = 0;
//
//		for (int i = 1; i < list.length; i++) {
//			list[i] = list[i - 1].clone();
//			if (i % 2 == 0) {
//				k = i;
//				while (k % 2 == 0) {
//					cnt++;
//					k /= 2;
//				}
//				list[i][0] += cnt;
//				cnt = 0;
//			}
//			if (i % 5 == 0) {
//				k = i;
//				while (k % 5 == 0) {
//					cnt++;
//					k /= 5;
//				}
//				list[i][1] += cnt;
//				cnt = 0;
//			}
//
//		}

		// 수정코드
		System.out.println(Math.min(getAns(n, 2) - getAns(m, 2) - getAns(n - m, 2),
				getAns(n, 5) - getAns(m, 5) - getAns(n - m, 5)));
	}

	private static int getAns(int n, int num) {
		int cnt = 0;
		while (n >= num) {
			cnt += n / num;
			n /= num;
		}

		return cnt;

	}

}
