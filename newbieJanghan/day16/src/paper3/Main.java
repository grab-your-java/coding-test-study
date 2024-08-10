package paper3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] grid = new int[1001][1001];
		int[] areas = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int W = sc.nextInt();
			int H = sc.nextInt();

			areas[i] = W * H;
			int[] blocked = new int[i];
			for (int x = X; x < X + W; x++) {
				for (int y = Y; y < Y + H; y++) {
					if (grid[x][y] > 0) {
						// 색종이 마다 겹치는 영역 계산
						blocked[grid[x][y]]++;
					}
					// 색종이 각각을 다르게 표시. 뒤이은 색종이가 덮어써서 중복을 방지
					grid[x][y] = i;
				}
			}
			
			// 색종이마다 가려진 넓이 계산
			for (int j = 1; j < blocked.length; j++) {
				areas[j] -= blocked[j];
				if (areas[j] < 0) {
					areas[j] = 0;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(areas[i]);
		}

	}
}
