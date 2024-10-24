package BOJ_2583;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt(), C = sc.nextInt(), K = sc.nextInt();
		boolean[][] map = new boolean[R][C];
		while (K-- > 0) {
			int c1 = sc.nextInt(), r1 = sc.nextInt(), c2 = sc.nextInt(), r2 = sc.nextInt();
			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {
					map[r][c] = true;
				}
			}
		}

		List<Integer> areas = new ArrayList<>();
		int index = -1;

		Queue<Integer> q = new LinkedList<Integer>();
		int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c]) {
					continue;
				}
				
				map[r][c] = true;
				q.add(r);
				q.add(c);
				areas.add(0);
				index++;

				while (!q.isEmpty()) {
					int nr = q.poll(), nc = q.poll();
					areas.set(index, areas.get(index) + 1);

					for (int i = 0; i < 4; i++) {
						int tr = nr + dr[i], tc = nc + dc[i];
						if (0 <= tr && tr < R && 0 <= tc && tc < C && !map[tr][tc]) {
							map[tr][tc] = true;
							q.add(tr);
							q.add(tc);
						}
					}
				}
			}
		}
		
		Collections.sort(areas);
		StringBuilder sb = new StringBuilder();
		sb.append(areas.size()).append("\n");
		for (int area: areas) {
			sb.append(area).append(" ");
		}
		
		System.out.println(sb);
	}
}
