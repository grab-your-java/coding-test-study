package BOJ11724;

import java.util.*;

public class Main {
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		List<List<Integer>> adjList = new ArrayList<>();
		
		for (int i = 0; i <= V; i++) {
			adjList.add(new ArrayList<>());
		}
		
		boolean[] visited = new boolean[V + 1];
		
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		
		for (int i = 1; i <= V; i++) {
			if (!visited[i]) {
				result++;
				dfs(adjList, visited, i);
			}
		}
		
		System.out.println(result);
	}
	
	static void dfs(List<List<Integer>> adjList, boolean[] visited, int index) {
		visited[index] = true;
		
		List<Integer> list = adjList.get(index);
		
		for (int i = 0; i < list.size(); i++) {
			if (!visited[list.get(i)]) {
				dfs(adjList, visited, list.get(i));
			}
		}
	}
}
