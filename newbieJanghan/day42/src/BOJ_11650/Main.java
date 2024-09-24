package BOJ_11650;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class Index {
		int x, y;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Index[] indices = new Index[N];
		for (int i = 0; i < N; i++) {
			Index idx = new Index();
			idx.x = sc.nextInt();
			idx.y = sc.nextInt();
			indices[i] = idx;
		}

		Arrays.sort(indices, (a, b) -> {
			if (a.x == b.x) {
				return a.y - b.y;
			}
			return a.x - b.x;
		});

		for (int i = 0; i < N; i++) {
			System.out.println(indices[i].x + " " + indices[i].y);
		}
	}
}
