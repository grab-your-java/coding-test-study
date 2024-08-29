package BOJ_NandM;

import java.util.*;

public class BOJ15664 {
    static int[] output;
    static Set<String> set;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        visited = new boolean[N];
        set = new LinkedHashSet<>();
        output = new int[M];

        comb(input, 0, 0);

        List<String> list = new ArrayList<>(set);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void comb(int[] input, int start, int cnt) {
        if (cnt == output.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i]).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[cnt] = input[i];
                comb(input, i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
