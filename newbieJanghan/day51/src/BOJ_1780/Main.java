package BOJ_1780;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int[] cnt; // [ -1, 0, 1 ]

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		cnt = new int[3];

		search(0, 0, 1);

		for (int answer : cnt) {
			System.out.println(answer);
		}
	}

	static void search(int r, int c, int cut) {
		int size = N / (int) Math.pow(3, cut - 1), target = map[r][c];

		System.out.println("size " + size + " start r " + r + " c " + c + " value "  + target);

		boolean valid = true;
		for (int nr = r; nr < r + size; nr++) {
			for (int nc = c; nc < c + size; nc++) {
				if (map[nr][nc] != target) {
					valid = false;
					break;
				}
			}
		}

		System.out.println("valid " + valid);

		if (!valid) {
			for (int nr = r; nr < r + size; nr += size / 3) {
				for (int nc = c; nc < c + size; nc += size / 3) {
					search(nr, nc, cut + 1);
				}
			}
		} else {
			cnt[target + 1]++;
		}
	}

}
