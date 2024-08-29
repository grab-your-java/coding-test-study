package swea_5656_벽돌_깨기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int attackCnt, width, height, minRemains;
	static List<Integer>[] map;
	static int[] attackTargets;
	static List<int[]> attackSequences;

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

			minRemains = 0;
			for (int r = 0; r < height; r++) {
				for (int c = 0; c < width; c++) {
					int inputNum = sc.nextInt();
					if (inputNum != 0) {
						map[c].add(0, inputNum);
						minRemains++;
					}
				}
			}

			attackTargets = new int[width];
			for (int i = 0; i < width; i++) {
				attackTargets[i] = i;
			}

			attack(new int[attackCnt], 0);
			System.out.println("#" + t + " " + minRemains);
		}
	}

	static void attack(int[] sequence, int depth) {
		if (depth == attackCnt) {
			List<Integer>[] newMap = deepCopy(map);
			for (int i = 0; i < sequence.length; i++) {
				int columnIdx = sequence[i];
				if (newMap[columnIdx].size() == 0) {
					break;
				}

				mark(newMap, columnIdx, newMap[columnIdx].size() - 1);
				boom(newMap);
			}

			int remains = 0;
			for (List<Integer> col : newMap) {
				remains += col.size();
			}

			minRemains = Math.min(minRemains, remains);
			return;
		}

		for (int i = 0; i < attackTargets.length; i++) {
			sequence[depth] = i;
			attack(sequence, depth + 1);
		}
	}

	static List<Integer>[] deepCopy(List<Integer>[] map) {
		List<Integer>[] newMap = new ArrayList[map.length];
		for (int i = 0; i < map.length; i++) {
			newMap[i] = new ArrayList<>(map[i]);
		}

		return newMap;
	}

	static void mark(List<Integer>[] map, int column, int lastIdx) {
		List<Integer> bricks = map[column];
		if (bricks.size() <= lastIdx) {
			return;
		}

		int bombArea = bricks.get(lastIdx);
		bricks.set(lastIdx, 0);

		// right
		for (int nc = column + 1; nc < width && nc < (column + bombArea); nc++) {
			mark(map, nc, lastIdx);
		}

		// left
		for (int nc = column - 1; nc >= 0 && nc > (column - bombArea); nc--) {
			mark(map, nc, lastIdx);
		}

		// up
		for (int nr = lastIdx + 1; nr < height && nr < (lastIdx + bombArea); nr++) {
			mark(map, column, nr);
		}

		// down
		for (int nr = lastIdx - 1; nr >= 0 && nr > (lastIdx - bombArea); nr--) {
			mark(map, column, nr);
		}
	}
	
	static void boom(List<Integer>[] map) {
		for (int i=0; i<map.length; i++) {
			map[i].removeIf((area) -> area == 0);
		}
 	}
}
