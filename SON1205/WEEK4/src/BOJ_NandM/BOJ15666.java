package BOJ_NandM;

import java.util.*;

public class BOJ15666 {
    static int[] output;
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

        output = new int[M];
        set = new LinkedHashSet<>();

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

        for (int i = start; i < input.length; i++) {
            output[cnt] = input[i];
            comb(input, i, cnt + 1);
        }
    }
}
