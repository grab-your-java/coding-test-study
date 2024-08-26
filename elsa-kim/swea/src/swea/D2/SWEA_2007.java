package swea.D2;

import java.util.Scanner;

// 패턴 마디의 길이
public class SWEA_2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		repeat: for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int cnt = 1;
			while (cnt <= 10) {
				boolean isRight = true;
				String[] arr = str.split(str.substring(0, cnt));
				out: for (int i = 0; i < arr.length - 1; i++) {
					for (int j = i + 1; j < arr.length - 1; j++) {
						if (!arr[i].equals(arr[j])) {
							isRight = false;
							cnt++;
							break out;
						}
					}
				}
				if (isRight) {
					System.out.println("#" + tc + " " + cnt);
					continue repeat;
				}
			}
		}
	}

}
