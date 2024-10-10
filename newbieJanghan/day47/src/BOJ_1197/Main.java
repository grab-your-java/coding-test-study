package BOJ_1197;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Edge {
        int a, b, weight;

        public Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();
        List<Edge>[] adjList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), weight = sc.nextInt();

            adjList[a].add(new Edge(a, b, weight));
            adjList[b].add(new Edge(b, a, weight));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] visited = new boolean[V + 1];
        visited[1] = true;
        pq.addAll(adjList[1]);

        int answer = 0;
        int pick = 1;
        while (pick != V) {
            Edge edge = pq.poll();
            if (visited[edge.b]) {
                continue;
            }

            visited[edge.b] = true;
            answer += edge.weight;
            pq.addAll(adjList[edge.b]);
            pick++;
        }
        System.out.println(answer);
    }
}
