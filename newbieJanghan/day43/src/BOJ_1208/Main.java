package BOJ_1208;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int N, S;
    static int[] nums;
    static Map<Integer, Long> sumCnt;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        sumCnt = new HashMap<>();
        leftSubset(0, 0);
        rightSubset(N / 2, 0);

        if (S == 0) {
            answer -= 1;
        }
        System.out.println(answer);
    }

    static void leftSubset(int idx, int sum) {
        if (idx == N / 2) {
            sumCnt.put(sum, sumCnt.getOrDefault(sum, 0L) + 1L);
            return;
        }

        leftSubset(idx + 1, sum);
        leftSubset(idx + 1, sum + nums[idx]);
    }

    static void rightSubset(int idx, int sum) {
        if (idx == N) {
            answer += sumCnt.getOrDefault(S - sum, 0L);
            return;
        }

        rightSubset(idx + 1, sum);
        rightSubset(idx + 1, sum + nums[idx]);
    }
}
