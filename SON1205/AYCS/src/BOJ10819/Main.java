package BOJ10819;

import java.util.Scanner;

public class Main {
    static int result;
    static int[] output;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] input = new int[N];
        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }

        visited = new boolean[N];
        output = new int[N];
        perm(input, 0);

        System.out.println(result);
    }

    static void perm(int[] input, int cnt) {
        if (cnt == output.length) {
            calculate(output);
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[cnt] = input[i];
                perm(input, cnt + 1);
                visited[i] = false;
            }
        }
    }


    static void calculate(int[] input) {
        int tmp = 0;

        for (int i = 0; i < input.length - 1; i++) {
            tmp += Math.abs(input[i] - input[i + 1]);
        }

        result = Math.max(result, tmp);
    }

    //nextPermutation 을 사용하면 어떨까?
}
