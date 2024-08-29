package switch_1244;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] switches = new int[N];
		for (int i = 0; i < N; i++) {
			switches[i] = sc.nextInt();
		}

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int student = sc.nextInt();
			int number = sc.nextInt();

			switch (student) {
			// boy
			case 1:
				for (int j = 1; j <= switches.length; j++) {
					if (j % number == 0) {
						toggle(switches, j - 1);
					}
				}
				break;
			// girl
			case 2:
				int space = Math.min(N - number, number - 1);
				int idx = number - 1;
				int l = idx;
				int r = idx;
				while (space > 0 && l >= 0 && r < N) {
					if (switches[l - 1] == switches[r + 1]) {
						l--;
						r++;
						space--;
					} else {
						break;
					}
				}
				for (int j = l; j <= r; j++) {
					toggle(switches, j);
				}
				break;
			}
		}

		// print
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(switches[i]);
			if ((i + 1) % 20 == 0) {
				sb.append("\n");
			} else {
				sb.append(" ");
			}
		}
		System.out.println(sb);
	}

	public static void toggle(int[] switches, int i) {
		switches[i] = switches[i] == 1 ? 0 : 1;
	}

}
