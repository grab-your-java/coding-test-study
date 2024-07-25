//package paper2;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		// Mapping
//		int N = sc.nextInt();
//		int[][] paperPoints = new int[N][2];
//		
//		int[][] map = new int[101][101];
//		// Mapping
//		for (int i=0; i<N; i++) {
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//			int[] point = { x, y };
//			paperPoints[i] = point;
//			
//			for (int r = y; r <= y + 10; r++) {
//				for (int c = x; c <= x + 10; c++) {
//					map[r][c]++;
//				}
//			}
//		}
//		for (int i = 100; i >= 0; i--) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		
//		// 중복 제거
//		for (int i=0; i<N; i++) {
//			int[] point = paperPoints[i];
//			int x = point[0];
//			int y = point[1];
//			
//			for (int r = y; r <= y + 10; r++) {
//				for (int c = x; c <= x + 10; c++) {
//					if (r == y || r== y+10 || c==x || c ==x+10) {
//						continue;
//					} else {
//						map[r][c] = 0;
//					}
//				}
//			}
//		}
//
//		for (int i = 100; i >= 0; i--) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		// Sum line length
//		int result = 0;
//		for (int r = 0; r < 100; r++) {
//			for (int c = 0; c < 100; c++) {
//				if (map[r][c] > 0) {
//					result++;
//				}
//			}
//		}
//
//		System.out.println(result);
//	}
//}

package paper2;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Mapping
		int N = sc.nextInt();
		int[][] paperPoints = new int[N][2];

		int[][] map = new int[101][101];
		// Mapping
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int[] point = { x, y };
			paperPoints[i] = point;

			for (int r = y; r <= y + 10; r++) {
				for (int c = x; c <= x + 10; c++) {
					map[r][c]++;
				}
			}
		}
		for (int i = 100; i >= 0; i--) {
			System.out.println(Arrays.toString(map[i]));
		}

		// 중복 제거
		for (int i = 0; i < N; i++) {
			int[] point = paperPoints[i];
			int x = point[0];
			int y = point[1];

			for (int r = y; r <= y + 10; r++) {
				for (int c = x; c <= x + 10; c++) {
					if (r == y || r == y + 10 || c == x || c == x + 10) {
						continue;
					} else {
						map[r][c] = 0;
					}
				}
			}
		}

		for (int i = 100; i >= 0; i--) {
			System.out.println(Arrays.toString(map[i]));
		}

		// Sum line length
		int result = 0;
		// 가로 길이 계산
		for (int r = 0; r <= 100; r++) {
			boolean inLine = false;
			int temp = 0;
			for (int c = 0; c <= 100; c++) {
				int dot = map[r][c];
				if (!inLine) {
					if (dot == 0) {
						continue;
					} else {
						inLine = true;
						temp++;
					}
				} else {
					if (dot == 0) {
						inLine = false;
						result += temp - 1;
					} else {
						temp++;
						continue;
					}
				}
			}
			System.out.println("at row: " + r + " temp: " + temp);
		}
		// 세로 길이 계산
		for (int c = 0; c <= 100; c++) {
			boolean inLine = false;
			int temp = 0;
			for (int r = 0; r <= 100; r++) {
				int dot = map[r][c];
				if (!inLine) {
					if (dot == 0) {
						continue;
					} else {
						inLine = true;
						temp++;
					}
				} else {
					if (dot == 0) {
						inLine = false;
						result += temp - 1;
					} else {
						temp++;
						continue;
					}
				}
			}
			System.out.println("at col: " + c + " temp: " + temp);
		}

		System.out.println(result);
	}
}
