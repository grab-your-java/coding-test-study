package swea.D3;

import java.util.Scanner;

public class SWEA_7087 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int cnt = sc.nextInt();
			boolean[] arr = new boolean[26];
			for (int i = 0; i < cnt; i++) {
				String line = sc.next();
				arr[line.charAt(0) - 'A'] = true;
			}
			int idx = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i]) {
					idx = i + 1;
				} else {
					break;
				}
			}
			System.out.println("#" + tc + " " + idx);
		}
	}

}
