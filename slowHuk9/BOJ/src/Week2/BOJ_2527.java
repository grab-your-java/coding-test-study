package Week2;

import java.util.Scanner;

public class BOJ_2527 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();

			// 접점 X
			if (x1 > p2 || y1 > q2 || x2 > p1 || y2 > q1) {
				System.out.println("d");
			}
			// 점에서 만난다.
			else if ((x2 == p1 && y2 == q1) || (x2 == p1 && y1 == q2) || (q1 == y2 && x1 == p2)
					|| (x1 == p2 && y1 == q2)) {
				System.out.println("c");
			}
			// 선분으로 만난다.
			else if (x2 == p1 || x1 == p2 || y1 == q2 || q1 == y2) {
				System.out.println("b");
			} else {
				System.out.println("a");
			}
		}
	}
}
