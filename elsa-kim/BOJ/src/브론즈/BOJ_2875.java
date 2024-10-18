package 브론즈;

import java.util.Scanner;

public class BOJ_2875 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int minus = sc.nextInt();
		int team = Math.min(x / 2, y);
		while (team > 0) {
			if (x - 2 * team >= 0 && y - team >= 0 && x + y - 3 * team >= minus) {
				break;
			}
			team--;
		}
		System.out.println(team);
	}

}
