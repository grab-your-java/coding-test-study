package SWEA;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1249_보급로 {
	static char[][] arr;
	static int[][] check;
	static int size;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			size = sc.nextInt();
			arr = new char[size][size];
			check = new int[size][size];
			visited = new boolean[size][size];

			for (int i = 0; i < size; i++) {
				arr[i] = sc.next().toCharArray();
			}
			bfs();
			System.out.println("#" + tc + " " + check[size - 1][size - 1]);
		}
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		q.add(0);

		while (!q.isEmpty()) {
			int a = q.poll();
			int b = q.poll();
			if (a + 1 < size) {
				if (visited[a + 1][b]) {
					if (check[a][b] + (arr[a + 1][b] - '0') < check[a + 1][b]) {
						check[a + 1][b] = check[a][b] + (arr[a + 1][b] - '0');
						q.add(a + 1);
						q.add(b);
					}

				} else {
					q.add(a + 1);
					q.add(b);
					check[a + 1][b] = check[a][b] + (arr[a + 1][b] - '0');
					visited[a + 1][b] = true;
				}
			}
			if (b + 1 < size) {
				if (visited[a][b + 1]) {
					if (check[a][b] + (arr[a][b + 1] - '0') < check[a][b + 1]) {
						check[a][b + 1] = check[a][b] + (arr[a][b + 1] - '0');
						q.add(a);
						q.add(b + 1);
					}
				} else {
					check[a][b + 1] = check[a][b] + (arr[a][b + 1] - '0');
					visited[a][b + 1] = true;
					q.add(a);
					q.add(b + 1);
				}

			}
			if (a - 1 >= 0) {
				if (visited[a - 1][b]) {
					if (check[a][b] + (arr[a - 1][b] - '0') < check[a - 1][b]) {
						check[a - 1][b] = check[a][b] + (arr[a - 1][b] - '0');
						q.add(a - 1);
						q.add(b);
					}
				} else {
					check[a - 1][b] = check[a][b] + (arr[a - 1][b] - '0');
					visited[a - 1][b] = true;
					q.add(a - 1);
					q.add(b);
				}

			}
			if (b - 1 >= 0) {
				if (visited[a][b - 1]) {
					if (check[a][b] + (arr[a][b - 1] - '0') < check[a][b - 1]) {
						check[a][b - 1] = check[a][b] + (arr[a][b - 1] - '0');
						q.add(a);
						q.add(b - 1);
					}
				} else {
					check[a][b - 1] = check[a][b] + (arr[a][b - 1] - '0');
					visited[a][b - 1] = true;
					q.add(a);
					q.add(b - 1);
				}

			}
		}
	}

}
