package BOJ10451;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();

            List<List<Integer>> adjList = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 1; i <= N; i++) {
                List<Integer> tmp = adjList.get(i);

                tmp.add(sc.nextInt());
            }

            int result = 0;

            for (int i = 1; i <= N; i++) {
                List<Integer> tmp = adjList.get(i);

                if (!tmp.isEmpty()) {
                    result++;
                }

                while (!tmp.isEmpty()) {
                    int vertex = tmp.get(0);

                    tmp.remove(0);

                    tmp = adjList.get(vertex);
                }
            }

            System.out.println(result);
        }
    }

}
