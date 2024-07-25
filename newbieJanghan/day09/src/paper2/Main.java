package paper2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] papers = new int[N][2];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int[] paper = { x, y };
			papers[i] = paper;
		}

		int result = 40 * N;

		System.out.println("before calculating, result: " + result);
		for (int i = 0; i < N - 1; i++) {
			int[] paper = papers[i];
			int ax1 = paper[0];
			int ax2 = ax1 + 10;
			int ay1 = paper[1];
			int ay2 = ay1 + 10;
			System.out.println();
			System.out.println("Paper A: [ [ " + ax1 + ", " + ay1 + " ], [ " + ax2 + ", " + ay2 + " ] ]");

			for (int j = i + 1; j < N; j++) {
				int[] b = papers[j];
				int bx1 = b[0];
				int bx2 = bx1 + 10;
				int by1 = b[1];
				int by2 = by1 + 10;
				System.out.println("Paper B: [ [ " + bx1 + ", " + by1 + " ], [ " + bx2 + ", " + by2 + " ] ]");

				// overlapped
				if (ax1 < bx1 && bx1 < ax2 && ay1 < by2 && by2 < ay2) {
					System.out.println("case 1: " + ((ax2 - bx1) + (by2 - ay1)) * 2);
					result -= ((ax2 - bx1) + (by2 - ay1)) * 2;
				} else if (ax1 < bx1 && bx1 < ax2 && ay1 < by1 && by1 < ay2) {
					System.out.println("case 2");
					result -= ((ax2 - bx1) + (ay2 - by1)) * 2;
				} else if (ax1 < bx2 && bx2 < ax2 && ay1 < by1 && by1 < ay2) {
					System.out.println("case 3: " + ((bx2 - ax1) + (ay2 - by1)) * 2);
					result -= ((bx2 - ax1) + (ay2 - by1)) * 2;
				} else if (ax1 < bx2 && bx2 < ax2 && ay1 < by2 && by2 < ay2) {
					System.out.println("case 4");
					result -= ((ax2 - bx1) + (ay2 - by2)) * 2;
				}

				// line same
				else if (ax2 == bx1) {
					if (by1 < ay2 && ay2 < by2) {
						System.out.println("case 5: " + (ay2 - by1));
						result -= (ay2 - by1);
					} else if (by1 < ay1 && ay1 < by2) {
						System.out.println("case 6");
						result -= (by2 - ay1);
					}
				} else if (ay1 == by2) {
					if (ax2 < bx2 && by1 < ax2) {
						System.out.println("case 7");
						result -= (ax2 - bx1);
					} else if (bx1 < ax1 && ax1 < bx2) {
						System.out.println("case 8");
						result -= (bx2 - ax1);
					}
				} else if (ax1 == bx2) {
					if (by1 < ay2 && ay2 < by2) {
						System.out.println("case 9");
						result -= (ay2 - by1);
					} else if (by1 < ay1 && ay1 < by2) {
						System.out.println("case 10");
						result -= (by2 - ay1);
					}
				} else if (ay2 == by1) {
					if (bx1 < ax1 && ax1 < bx2) {
						System.out.println("case 11");
						result -= (bx2 - ax1);
					} else if (bx1 < ax2 && ax2 < bx2) {
						System.out.println("case 12");
						result -= (ax2 - bx1);
					}
				}
			}
		}
		System.out.println(result);
	}
}
