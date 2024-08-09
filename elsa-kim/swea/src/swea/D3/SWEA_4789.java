package swea.D3;

import java.util.Scanner;

public class SWEA_4789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int[] arr = new int[str.length()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(str.substring(i, i + 1));
			}
			int need = 0;
			int now = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (i <= now) {
					now += arr[i];
				} else {
					need += i - now;
					now = (i + arr[i]);
				}
			}
			System.out.println("#" + tc + " " + need);
		}
	}

}
