package swea.D3;

import java.util.Scanner;

public class SWEA_5356 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[][] arr = new char[5][];
			int maxleng = 0;
			for (int i = 0; i < 5; i++) {
				String line = sc.next();
				arr[i] = line.toCharArray();
				if (line.length() > maxleng)
					maxleng = line.length();
			}
			String str = "";
			for (int i = 0; i < maxleng; i++) {
				for (int j = 0; j < 5; j++) {
					if (i < arr[j].length) {
						str += arr[j][i];
					}
				}
			}
			System.out.println("#" + tc + " " + str);
		}
	}

}
