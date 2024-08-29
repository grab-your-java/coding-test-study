package swea_5656_벽돌_깨기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
	static int attackCnt, width, height, total, minRemains;
	static List<Integer>[] map;
	static List<Integer>[][] snapshots;

	static int[] attackTargets;
	static int removedCnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			attackCnt = sc.nextInt(); // N
			width = sc.nextInt(); // W
			height = sc.nextInt(); // H

			map = new ArrayList[width];
			for (int c = 0; c < width; c++) {
				map[c] = new ArrayList<>();
			}

			total = 0;
			for (int r = 0; r < height; r++) {
				for (int c = 0; c < width; c++) {
					int inputNum = sc.nextInt();
					if (inputNum != 0) {
						map[c].add(0, inputNum);
						total++;
					}
				}
			}
			minRemains = total;

			attackTargets = new int[width];
			for (int i = 0; i < width; i++) {
				attackTargets[i] = i;
			}

			snapshots = new ArrayList[attackCnt + 1][];
			snapshots[0] = map;
			attack(1);

			System.out.println("#" + t + " " + total);
		}
	}

	static void attack(int depth) {
		if (depth == attackCnt + 1) {
			minRemains = Math.min(minRemains, total - removedCnt);
			removedCnt = 0;
			return;
		}

		for (int columnIdx = 0; columnIdx < attackTargets.length; columnIdx++) {
			List<Integer>[] snapshot = deepCopy(snapshots[depth - 1]);
			
			int lastRowIdx = snapshot[columnIdx].size() - 1;
			System.out.println("****** depth " + depth + "****** ");
			visit(snapshot, new boolean[height][width], columnIdx, lastRowIdx);
			boom(snapshot);

			for (List<Integer> column: snapshot) {
				System.out.println(column);
			}
			if (depth != attackCnt) {
				snapshots[depth] = snapshot;
			}

			attack(depth + 1);
		}
	}

	static List<Integer>[] deepCopy(List<Integer>[] map) {
		List<Integer>[] newMap = new ArrayList[map.length];
		for (int i = 0; i < map.length; i++) {
			newMap[i] = new ArrayList<>(map[i]);
		}

		return newMap;
	}

	static void visit(List<Integer>[] snapshot, boolean[][] visited, int column, int row) {
		System.out.println("column " + column + " row " + row);
		List<Integer> bricks = snapshot[column];
		if (bricks.size() <= row || bricks.size() == 0) {
			return;
		}

		if (visited[row][column]) {
			return;
		}

		visited[row][column] = true;
		removedCnt++;
		int bombArea = bricks.get(row);
		bricks.set(row, 0);

		// right
		for (int nc = column + 1; nc < width && nc < (column + bombArea); nc++) {
			visit(snapshot, visited, nc, row);
		}

		// left
		for (int nc = column - 1; nc >= 0 && nc > (column - bombArea); nc--) {
			visit(snapshot, visited, nc, row);
		}

		// up
		for (int nr = row + 1; nr < height && nr < (row + bombArea); nr++) {
			visit(snapshot, visited, column, nr);
		}

		// down
		for (int nr = row - 1; nr >= 0 && nr > (row - bombArea); nr--) {
			visit(snapshot, visited, column, nr);
		}
	}

	static void boom(List<Integer>[] map) {
		for (int i = 0; i < map.length; i++) {
			map[i].removeIf((area) -> area == 0);
		}
	}
}
