package SWEA;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_7733_치즈도둑 {
	static int[][] ori;
	static boolean[][] check;
	static int size, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			size = sc.nextInt();
			ori = new int[size][size];
			check = new boolean[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					ori[i][j] = sc.nextInt();
				}
			}
			cnt = 1;
			for (int k = 1; k <= 100; k++) {
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (ori[i][j] == k) {
							check[i][j] = true;
						}
					}
				}
				count();
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

	private static void count() {
		int sum = 0;
		Queue<Integer> q = new ArrayDeque<>();
		boolean[][] get = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			get[i] = check[i].clone();
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!get[i][j]) {
					sum++;
					get[i][j] = true;
					q.add(i);
					q.add(j);
					while (!q.isEmpty()) {
						int a = q.poll();
						int b = q.poll();
						if (a - 1 >= 0 && !get[a - 1][b]) {
							get[a - 1][b] = true;
							q.add(a - 1);
							q.add(b);
						}
						if (b - 1 >= 0 && !get[a][b - 1]) {
							get[a][b - 1] = true;
							q.add(a);
							q.add(b - 1);
						}
						if (a + 1 < size && !get[a + 1][b]) {
							get[a + 1][b] = true;
							q.add(a + 1);
							q.add(b);
						}
						if (b + 1 < size && !get[a][b + 1]) {
							get[a][b + 1] = true;
							q.add(a);
							q.add(b + 1);
						}
					}
				}
			}
		}
		if (sum > cnt)
			cnt = sum;

	}

}
