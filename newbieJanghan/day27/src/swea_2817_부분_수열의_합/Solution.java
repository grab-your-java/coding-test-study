package swea_2817_부분_수열의_합;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + t + " ");
            int[] constraints = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sumGoal = constraints[1];
            int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            sb.append(PartialSum.getGoalCount(numbers, sumGoal));
            System.out.println(sb);
        }
    }

    static class PartialSum {
        static int[] NUMBERS;
        static int GOAL;
        static int GOAL_COUNT;

        static int getGoalCount(int[] numbers, int goal) {
            NUMBERS = numbers;
            GOAL = goal;
            GOAL_COUNT = 0;

            dfs(0, 0);
            return GOAL_COUNT;
        }

        static void dfs(int start, int acc) {
            if (acc == GOAL) {
                GOAL_COUNT++;

                return;
            }

            for (int i = start; i < NUMBERS.length; i++) {
                if (acc + NUMBERS[i] <= GOAL) {
                    dfs(i + 1, acc + NUMBERS[i]);
                }
            }
        }
    }
}
