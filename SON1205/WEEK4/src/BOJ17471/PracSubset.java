package BOJ17471;

import java.util.ArrayList;
import java.util.List;

public class PracSubset {
    public static void main(String[] args) {
        int N = 3;

        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = i + 1;
        }

        output = new ArrayList<>();
        visited = new boolean[N];

        dfs(0);

        for (List<Integer> list : output) {
            System.out.println(list);
        }
    }


    static int[] input;
    static List<List<Integer>> output;
    static boolean[] visited;

    static void dfs(int cnt) {
        if (cnt == input.length) {
            output.add(new ArrayList<>());
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    output.getLast().add(input[i]);
                }
            }
            return;
        }

        visited[cnt] = true;
        dfs(cnt + 1);
        visited[cnt] = false;
        dfs(cnt + 1);
    }
}
