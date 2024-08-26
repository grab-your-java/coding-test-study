package 실버;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {
	static int N, M, V;
	static List<List<Integer>> arr;
	static boolean[] check;
	static Queue<Integer> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 개수
		M = sc.nextInt(); // 간선 개수
		V = sc.nextInt(); // 시작할 정점
		arr = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		for (int i = 0; i < N + 1; i++) {
			List<Integer> newList = arr.remove(i);
			newList.sort(Comparator.naturalOrder());
			arr.add(i, newList);
		}
		check = new boolean[N + 1];
		DFS(V);
		System.out.println();
		check = new boolean[N + 1];
		q = new ArrayDeque<>();
		q.offer(V);
		BFS();
	}

	private static void DFS(int start) {
		System.out.print((start) + " ");
		check[start] = true;

		for (int i = 0; i < arr.get(start).size(); i++) {
			if (!check[arr.get(start).get(i)]) {
				check[arr.get(start).get(i)] = true;
				DFS(arr.get(start).get(i));
			}

		}

	}

	private static void BFS() {
		while (!q.isEmpty()) {
			int n = q.poll();
			System.out.print((n) + " ");
			check[n] = true;
			for (int i = 0; i < arr.get(n).size(); i++) {
				if (!check[arr.get(n).get(i)]) {
					check[arr.get(n).get(i)] = true;
					q.offer(arr.get(n).get(i));
				}

			}
		}

	}

}
