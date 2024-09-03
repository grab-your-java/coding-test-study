package SWEA2383;

import java.util.*;

public class Solution {
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        //두 계단 입구로부터의 거리를 구하고
        //부분집합을 구한 뒤
        //소요시간을 구하고
        //최종값이 작은 것을 고르면 완료
        for (int tc = 1; tc <= T; tc++) {
            result = Integer.MAX_VALUE;

            int N = sc.nextInt();

            int[][] stairs = new int[2][3];

            List<int[]> people = new ArrayList<>();

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int tmp = sc.nextInt();

                    if (tmp == 1) {
                        people.add(new int[]{i, j});
                    } else if (tmp >= 2) {
                        stairs[cnt][0] = i;
                        stairs[cnt][1] = j;
                        stairs[cnt][2] = tmp;
                        cnt++;
                    }
                }
            }

            boolean[] visited = new boolean[people.size()];
            subset(stairs, people, visited, 0);

            System.out.println("#" + tc + " " + result);
        }
    }

    static void subset(int[][] stairs, List<int[]> people, boolean[] visited, int cnt) {
        if (cnt == people.size()) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            for (int i = 0; i < visited.length; i++) {
                int[] tmp = people.get(i);

                if (visited[i]) {
                    int time = Math.abs(tmp[0] - stairs[0][0]) + Math.abs(tmp[1] - stairs[0][1]);
                    list1.add(time);
                } else {
                    int time = Math.abs(tmp[0] - stairs[1][0]) + Math.abs(tmp[1] - stairs[1][1]);
                    list2.add(time);
                }
            }

            Collections.sort(list1);
            Collections.sort(list2);

            int tmpResult = Math.max(calculateTime(list1, stairs[0][2]), calculateTime(list2, stairs[1][2]));

            if (result > tmpResult) {
                result = tmpResult;
            }

            return;
        }

        visited[cnt] = true;
        subset(stairs, people, visited, cnt + 1);
        visited[cnt] = false;
        subset(stairs, people, visited, cnt + 1);
    }

    private static int calculateTime(List<Integer> list, int K) {
        if (list.size() == 0) {
            return 0;
        }

        int[] times = new int[list.size()];

        for (int i = 0; i < times.length; i++) {
            if (i - 3 < 0) {
                times[i] = list.get(i) + K;
                continue;
            }

            if (list.get(i) < times[i - 3]) {
                times[i] = times[i - 3] + K;
            } else {
                times[i] = list.get(i) + K;
            }
        }

        return times[list.size() - 1] + 1;
    }
}
