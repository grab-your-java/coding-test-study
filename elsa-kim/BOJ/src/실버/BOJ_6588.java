package 실버;

import java.util.Scanner;

public class BOJ_6588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] list = new boolean[1000001];
		list[0] = true;
		list[1] = true;
		for (int i = 2; i < list.length; i++) {
			if (!list[i]) {
				int j = 2 * i;
				while (j < list.length) {
					list[j] = true;
					j += i;
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		int n = sc.nextInt();
		while (n != 0) {

			sb.append(n);
			sb.append(" = ");
			int a = 0;
			for (int i = 3; i <= n / 2; i++) {
				if (i % 2 == 0 || (n - i) % 2 == 0)
					continue;
				if (!list[i] && !list[n - i]) {
					a = i;
					sb.append(a);
					sb.append(" + ");
					sb.append(n - i);
					break;
				}
			}
			if (a == 0)
				System.out.println("Goldbach's conjecture is wrong.");
			else {
				System.out.println(sb);
			}
			sb.setLength(0);
			n = sc.nextInt();
		}
	}
}
