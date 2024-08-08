package boj_1260_DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<Integer>[] adjlist;
	private static boolean[] visited;
	private static ArrayList<Integer> answer; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // vertex count
		int M = sc.nextInt(); // edge count
		int V = sc.nextInt(); // start vertex no

		adjlist = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adjlist[i] = new ArrayList<>();
		}
		visited = new boolean[N + 1];
		answer = new ArrayList<>();

		while (N-- > 0) {
			adjlist[sc.nextInt()].add(sc.nextInt());
		}
		
		dfs(V);
		
	}
	
	public static void dfs(int now) {
		visited[now] = true;
		answer.add(now);
		
		for (int next: adjlist[now]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}
