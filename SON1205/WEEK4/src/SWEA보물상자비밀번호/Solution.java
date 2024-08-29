package SWEA보물상자비밀번호;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            Deque<Character> queue = new ArrayDeque<>();
            List<Long> result = new ArrayList<>();

            String input = sc.next();

            for (int i = 0; i < N; i++) {
                queue.offer(input.charAt(i));
            }

            for (int i = 0; i < N / 4; i++) {
                for (int p = 0; p < 4; p++) {
                    long tmp = 0;

                    for (int j = 0; j < N / 4; j++) {
                        char x = queue.poll();
                        if (x >= 'A') {
                            tmp += (x - 'A' + 10) * Math.pow(16, N / 4 - 1 - j);
                        } else {
                            tmp += (x - '0') * Math.pow(16, N / 4 - 1 - j);
                        }

                        queue.offer(x);
                    }

                    boolean isValid = true;

                    for (int j = 0; j < result.size(); j++) {
                        if (result.get(j) == tmp) {
                            isValid = false;
                        }
                    }

                    if (isValid) {
                        result.add(tmp);
                    }
                }
                queue.offer(queue.poll());
            }

            Collections.sort(result);

            System.out.println("#" + tc + " " + result.get(result.size() - K));
        }
    }
}