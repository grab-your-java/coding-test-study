package dfsAndBfs;

import java.util.*;

public class BOJ1260 {
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    static void dfs(int i) {
        visited[i] = true;
        System.out.print(i + " ");

        for (int j = 0; j < graph.get(i).size(); j++) {
            if (!visited[graph.get(i).get(j)]) {
                visited[graph.get(i).get(j)] = true;
                dfs(graph.get(i).get(j));
            }
        }
    }

    static void bfs(int i) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int j = 0; j < graph.get(x).size(); j++) {
                int next = graph.get(x).get(j);
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }

        System.out.println(graph);

        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }
}
