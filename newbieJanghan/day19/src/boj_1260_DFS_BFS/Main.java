package boj_1260_DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] adjlist;
	static boolean[] visited;
	static ArrayList<Integer> answer;
	static int nodeCnt, edgeCnt, start;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nodeCnt = sc.nextInt();
		edgeCnt = sc.nextInt();
		start = sc.nextInt();

		// initialize adjacent list with priority
		adjlist = new ArrayList[nodeCnt + 1];
		for (int i = 1; i <= nodeCnt; i++) {
			adjlist[i] = new ArrayList<>();
		}

		while (edgeCnt-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjlist[a].add(b);
			adjlist[b].add(a);
		}

		for (int i = 1; i <= nodeCnt; i++) {
			Collections.sort(adjlist[i]);
		}

		// DFS
		visited = new boolean[nodeCnt + 1];
		answer = new ArrayList<>();
		dfs(start);
		for (int v : answer) {
			System.out.print(v + " ");
		}
		System.out.println();

		// BFS
		visited = new boolean[nodeCnt + 1];
		answer = new ArrayList<>();
		bfs(start);
		for (int v : answer) {
			System.out.print(v + " ");
		}
	}

	static void dfs(int now) {
		visited[now] = true;
		answer.add(now);

		// visit adjacent nodes if they are not visited yet
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

			// queuing adjacent nodes if they are not visited yet
			for (int next : adjlist[now]) {
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}
	}
}
