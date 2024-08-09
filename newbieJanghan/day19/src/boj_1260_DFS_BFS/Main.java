package boj_1260_DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static PriorityQueue<Integer>[] adjlist;
	static boolean[] visited;
	static ArrayList<Integer> answer;
	static int vertexCount, edgeCount, start;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vertexCount = sc.nextInt();
		edgeCount = sc.nextInt();
		start = sc.nextInt();

		adjlist = new PriorityQueue[vertexCount + 1];
		for (int i = 1; i <= vertexCount; i++) {
			adjlist[i] = new PriorityQueue<>((a, b) -> a - b);
		}

		int count = 0;
		while (count++ < edgeCount) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjlist[a].add(b);
			adjlist[b].add(a);
		}

		visited = new boolean[vertexCount + 1];
		answer = new ArrayList<>();

		// DFS
		dfs(start);
		for (int v : answer) {
			System.out.print(v + " ");
		}
		System.out.println();

		// BFS
		visited = new boolean[vertexCount + 1];
		answer = new ArrayList<>();
		bfs(start);
		for (int v : answer) {
			System.out.print(v + " ");
		}
	}

	static void dfs(int now) {
		visited[now] = true;
		answer.add(now);

		for (int next : adjlist[now]) {
			if (!visited[next]) {
				dfs(next);
			}
		}

	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			answer.add(now);
			for (int next : adjlist[now]) {
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}
	}
}
