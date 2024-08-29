package SWEA1486;

import java.util.*;

public class Solution {
    static boolean[] visited;
    static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int B = sc.nextInt();

            int[] input = new int[N];
            for (int i = 0; i < N; i++) {
                input[i] = sc.nextInt();
            }

            visited = new boolean[N];
            list = new ArrayList<>();

            subset(input, B, 0);

            Collections.sort(list);

            System.out.println("#" + tc + " " + list.get(0));
        }
    }

    static void subset(int[] input, int b, int cnt) {
        if (cnt == input.length) {
            int result = 0;

            for (int i = 0; i < input.length; i++) {
                if (visited[i]) {
                    result += input[i];
                }
            }

            if (result >= b) {
                list.add(result - b);
            }

            return;
        }

        visited[cnt] = true;
        subset(input, b, cnt + 1);
        visited[cnt] = false;
        subset(input, b, cnt + 1);
    }
}
