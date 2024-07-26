package paper2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;

		int[] x1List = new int[N];
		int[] x2List = new int[N];
		int[] y1List = new int[N];
		int[] y2List = new int[N];

		int minx1 = 101;
		int maxx2 = 0;
		int miny1 = 101;
		int maxy2 = 0;

		for (int i = 0; i < N; i++) {
			int ax1 = sc.nextInt();
			int ax2 = ax1 + 10;
			int ay1 = sc.nextInt();
			int ay2 = ay1 + 10;
			// 색종이 좌표 기억
			x1List[i] = ax1;
//			minx1 = Math.min(minx1, ax1);
			x2List[i] = ax2;
//			maxx2 = Math.max(maxx2, ax2);
			y1List[i] = ay1;
//			miny1 = Math.min(miny1, ay1);
			y2List[i] = ay2;
//			maxy2 = Math.max(maxy2, ay2);

			// 그리기
			// ax1, ay1 -> ax1, ay2
			
		}

		System.out.println(result);
	}
}
