package 골드;

import java.util.Scanner;

public class BOJ_1107 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String want = sc.next();
		int cnt = sc.nextInt();
		String[] list = new String[cnt];
		for (int i = 0; i < cnt; i++) {
			list[i] = sc.next();
		}
		int ans = Math.abs(Integer.parseInt(want) - 100);
		String up = want;
		boolean check = false;
		int nowCnt = 0;
		while (!check && nowCnt < ans) {
			check = true;
			for (int i = 0; i < list.length; i++) {
				if (up.contains(list[i])) {
					check = false;
					break;
				}
			}
			if (check) {
				int pushCnt = up.length();
				pushCnt += nowCnt;
				ans = Math.min(ans, pushCnt);
			} else {
				up = String.valueOf(Integer.parseInt(up) + 1);
				nowCnt++;
			}

		}
		String down = want;
		check = false;
		nowCnt = 0;
		while (!check && nowCnt < ans) {
			check = true;
			for (int i = 0; i < list.length; i++) {
				if (down.contains(list[i])) {
					check = false;
					break;
				}
			}
			if (check) {
				int pushCnt = down.length();
				pushCnt += nowCnt;
				ans = Math.min(ans, pushCnt);
			} else {
				down = String.valueOf(Integer.parseInt(down) - 1);
				nowCnt++;
			}

		}

		System.out.println(ans);
	}

}
