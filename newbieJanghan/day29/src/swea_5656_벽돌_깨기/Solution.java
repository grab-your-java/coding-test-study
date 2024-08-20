package swea_5656_벽돌_깨기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int chanceCnt, width, height, maxRemains;
	static ArrayList<Integer>[] map;
	static ArrayList<Integer>[][] snapshots;
	static boolean[] visitedColumn;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		chanceCnt = sc.nextInt(); // N
		width = sc.nextInt();
		height = sc.nextInt();

		map = new ArrayList[width];
		visitedColumn = new boolean[width];

		snapshots = new ArrayList[chanceCnt][width];
		maxRemains = 0;
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				int inputNum = sc.nextInt();
				if (inputNum != 0) {
					map[c].add(0, inputNum);
					maxRemains++;
				}
			}
		}

		dfs(0, maxRemains);
	}

	static void dfs(int change, int remains) {
		if (change == chanceCnt) {
			maxRemains = Math.max(maxRemains, remains);

			return;
		}

		// if possible, choose biggest column
		List<Integer>[] snapshot = map.clone();
		for (int c = 0; c < width; c++) {
			if (!visitedColumn[c]) {
				List<Integer> target = snapshot[c];
				int lastIdx = target.size() - 1;
				int bombArea = target.get(lastIdx);
				target.remove(lastIdx);

			}
		}

	}

	static void bomb(List<Integer>[] snapshot, int column, int lastIdx, int area) {
		List<Integer> bricks = snapshot[column];
		if (bricks.size() <= lastIdx) {
			return;
		}
		
		int bombArea = bricks.get(lastIdx);
		if (bombArea == 0) {
			return;
		}
		
		bricks.remove(lastIdx);

		// left
		for (int i = column; i > (column - area); column--) {

		}
		// right

		// down
	}
}
