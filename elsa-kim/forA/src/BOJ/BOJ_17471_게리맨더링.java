package BOJ;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17471_게리맨더링 {
	static int size; // 구역 개수
	static int[] people; // 구역별 인구수
	static int[][] line; // 연결 정보
	static boolean[] check;
	static boolean[] half;
	static boolean[] yesCon;
	static int[] res;
	static boolean canDiv;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		people = new int[size];
		line = new int[size][];
		check = new boolean[size];
		min = 1000;
		canDiv = false;
		for (int i = 0; i < size; i++) {
			people[i] = sc.nextInt();
		}
		for (int i = 0; i < size; i++) {
			int n = sc.nextInt();
			line[i] = new int[n];
			for (int j = 0; j < n; j++) {
				line[i][j] = sc.nextInt();
				line[i][j]--;
			}
		}
		for (int i = 1; i <= size / 2; i++) {
			res = new int[i];
			com(0, 0);
		}
		System.out.println(canDiv ? min : -1);
	}

	private static void com(int cnt, int start) {
		if (cnt == res.length) {
			half = new boolean[size];
			for (int i = 0; i < res.length; i++) {
				half[res[i]] = true;
			}

			if (size != 2) {
				List<Integer> resList = new ArrayList<>();
				List<Integer> other = new ArrayList<>();
				for (int i = 0; i < half.length; i++) {
					if (half[i])
						resList.add(i);
					if (!half[i])
						other.add(i);
				}
				if (res.length == 1) {
					if (!checkLine(other))
						return;
				} else {
					if (!checkLine(resList))
						return;
					if (!checkLine(other))
						return;
				}
			}

			canDiv = true;
			int a = 0;
			int b = 0;
			for (int i = 0; i < half.length; i++) {
				if (half[i]) {
					a += people[i];
				} else {
					b += people[i];
				}
			}
			if (Math.abs(a - b) < min) {
				min = Math.abs(a - b);
			}

			return;
		}

		for (int i = start; i < size; i++) {
			if (!check[i]) {
				check[i] = true;
				res[cnt] = i;
				com(cnt + 1, i + 1);
				check[i] = false;
			}
		}

	}

	private static boolean checkLine(List<Integer> list) {
		Queue<Integer> q = new ArrayDeque<>();
		List<Integer> checkList = new ArrayList<>();
		q.add(list.get(0));
		while (!q.isEmpty()) {
			int idx = q.poll();
			checkList.add(idx);
			for (int i = 0; i < line[idx].length; i++) {
				if (!checkList.contains(line[idx][i]) && list.contains(line[idx][i])) {
					q.add(line[idx][i]);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if (!checkList.contains(list.get(i)))
				return false;
		}
		return true;
	}

}
