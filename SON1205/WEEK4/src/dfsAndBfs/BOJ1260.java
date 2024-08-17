package dfsAndBfs;

import java.util.*;

public class BOJ1260 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int M = sc.nextInt();

        int V = sc.nextInt();

        adjList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList.get(i));
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
        System.out.println();
    }

    static int N;
    static List<List<Integer>> adjList;
    static boolean[] visited;

    static void dfs(int V) {
        visited[V] = true;
        System.out.print(V + " ");

        for (int i = 0; i < adjList.get(V).size(); i++) {
            int tmp = adjList.get(V).get(i);
            if (visited[tmp]) {
                continue;
            }

            dfs(tmp);
        }
    }

    static void bfs(int V) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(V);

        while (!q.isEmpty()) {
            int tmp = q.poll();
            visited[tmp] = true;
            System.out.print(tmp + " ");

            for (int i = 0; i < adjList.get(tmp).size(); i++) {
                if (!visited[adjList.get(tmp).get(i)]) {
                    visited[adjList.get(tmp).get(i)] = true;
                    q.offer(adjList.get(tmp).get(i));
                }
            }
        }
    }
}
