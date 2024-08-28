package BOJ_NandM;

import java.util.*;

public class BOJ15663 {
    static int[] output;
    static boolean[] visited;
    static Set<String> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        set = new LinkedHashSet<>();
        visited = new boolean[N];
        output = new int[M];

        perm(input, 0);

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void perm(int[] input, int cnt) {
        if (cnt == output.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i]).append(" ");
            }

            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[cnt] = input[i];
                perm(input, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
