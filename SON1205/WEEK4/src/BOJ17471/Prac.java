package BOJ17471;

import java.util.*;

public class Prac {
    static int result = Integer.MAX_VALUE;

    static int[] population;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input
        int N = sc.nextInt();
        population = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            population[i] = sc.nextInt();
        }

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++) {
                graph.get(i).add(sc.nextInt());
            }
        }

        //logic
        selected = new boolean[N + 1];

        subset(0);

        //output
        if (result == Integer.MAX_VALUE) {
            result = -1;
        }

        System.out.println(result);
    }

    static boolean[] selected;

    public static void subset(int cnt) {
        if (cnt == population.length) {
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();

            for (int i = 1; i < selected.length; i++) {
                if (selected[i]) {
                    A.add(i);
                } else {
                    B.add(i);
                }
            }

            if (A.size() == 0 || A.size() == selected.length - 1) {
                return;
            }

            if (checkingConnection(A) && checkingConnection(B)) {
                if (calculateDiff() < result) {
                    result = calculateDiff();
                }
            }
            return;
        }

        selected[cnt] = true;
        subset(cnt + 1);
        selected[cnt] = false;
        subset(cnt + 1);
    }

    static List<List<Integer>> graph;
    static boolean[] visited;

    private static boolean checkingConnection(List<Integer> list) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited = new boolean[selected.length];

        queue.offer(list.get(0));
        int count = 0;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            visited[tmp] = true;
            count++;

            for (int i = 0; i < graph.get(tmp).size(); i++) {
                int c = graph.get(tmp).get(i);
                if (list.contains(c) && !visited[c]) {
                    queue.offer(c);
                    visited[c] = true;
                }
            }
        }

        if (count == list.size()) {
            return true;
        }

        return false;
    }


    private static int calculateDiff() {
        int populA = 0;
        int populB = 0;

        for (int i = 1; i < selected.length; i++) {
            if (selected[i]) {
                populA += population[i];
            } else {
                populB += population[i];
            }
        }

        return Math.abs(populA - populB);
    }
}
