package boj_17471_게리맨더링;

import java.util.*;

/**
 * TODO. A {1, 3, 4} & B { 2, 5, 6 } duplicated A { 2, 5, 6 } * B{ 1, 3, 4}
 */
public class Main {
    static int DISTRICT_COUNT;
    static int[] DISTRICT_POPULATIONS;
    static int[][] DISTRICT_EDGES;

    static int TOTAL_POP = 0;
    static int MIN_POP_DIFF = 0;

    static boolean[] collected;
    static List<Integer> partA;
    static List<Integer> partB;

    static boolean canDivide = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DISTRICT_COUNT = sc.nextInt();

        DISTRICT_POPULATIONS = new int[DISTRICT_COUNT + 1];
        for (int i = 1; i <= DISTRICT_COUNT; i++) {
            int population = sc.nextInt();
            DISTRICT_POPULATIONS[i] = population;
            TOTAL_POP += population;
        }
        MIN_POP_DIFF = TOTAL_POP;

        DISTRICT_EDGES = new int[DISTRICT_COUNT + 1][];
        for (int i = 1; i <= DISTRICT_COUNT; i++) {
            int M = sc.nextInt();
            int[] edges = new int[M];
            for (int j = 0; j < M; j++) {
                edges[j] = sc.nextInt();
            }
            DISTRICT_EDGES[i] = edges;
        }

        collected = new boolean[DISTRICT_COUNT + 1];
        divide(0);

        if (!canDivide) {
            System.out.println(-1);
        } else {
            System.out.println(MIN_POP_DIFF);
        }
    }

    private static void divide(int start) {
        if (0 < start && validate()) {
            canDivide = true;

            int sumA = partA.stream().reduce(
                    0, (acc, cur) -> acc + DISTRICT_POPULATIONS[cur]
            );

            int sumB = TOTAL_POP - sumA;
            MIN_POP_DIFF = Math.min(MIN_POP_DIFF, Math.abs(sumA - sumB));
        }

        for (int i = start + 1; i <= DISTRICT_COUNT; i++) {
            collected[i] = true;
            divide(i);
            collected[i] = false;
        }
    }

    private static boolean validate() {
        partA = new ArrayList<>();
        partB = new ArrayList<>();
        for (int i = 1; i <= DISTRICT_COUNT; i++) {
            if (collected[i]) {
                partA.add(i);
            } else {
                partB.add(i);
            }
        }

        // validate collected linkages
        return bfs(partA) && bfs(partB);
    }

    private static boolean bfs(List<Integer> collection) {
        if (partA.isEmpty() || partB.isEmpty()) {
            return false;
        }
        ArrayList<Integer> target = new ArrayList<>(List.copyOf(collection));
        boolean[] visited = new boolean[DISTRICT_COUNT + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(collection.getFirst());

        while (!q.isEmpty() && !target.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            target.removeIf((a) -> a == cur);
            for (int edge : DISTRICT_EDGES[cur]) {
                if (collection.contains(edge) && !visited[edge]) {
                    q.add(edge);
                }
            }
        }

        return target.isEmpty();
    }


}
