package 실버;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int want = sc.nextInt();
		int[] list = new int[cnt];
		long total = 0;
		for (int i = 0; i < cnt; i++) {
			list[i] = sc.nextInt();
			total += list[i];
		}
		Arrays.sort(list);
		int ansMin = list[cnt - 1] - want > 0 ? list[cnt - 1] - want : 0;
		int ansMax = list[cnt - 1] - 1;
		int ans = (ansMax + ansMin) / 2;
		while (ansMin < ansMax) {
			long sum = 0;
			for (int j = cnt - 1; j >= 0; j--) {
				if (list[j] - ans > 0) {
					sum += (list[j] - ans);
				} else {
					break;
				}
			}
			if (sum == want) {
				break;
			} else if (sum > want) {
				ansMin = ans;
				if ((ansMax + ansMin) / 2 == ans) {
					if (ansMin + 1 == ansMax)
						break;
					ans = (ansMax + ansMin) / 2 + 1;
				} else
					ans = (ansMax + ansMin) / 2;
			} else {
				ansMax = ans;
				ans = (ansMax + ansMin) / 2;
			}

		}
		System.out.println(ans);
	}

}
