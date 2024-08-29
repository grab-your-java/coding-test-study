package SWEA2806;

import java.util.Scanner;

public class Solution {
    static int[] visited;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            result = 0;
            visited = new int[N];
            locateQueen(0);

            System.out.println("#" + tc + " " + result);
        }
    }

    static void locateQueen(int cnt) {
        if (cnt == visited.length) {
            result++;
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            visited[cnt] = i;

            if (available(cnt)) {
                locateQueen(cnt + 1);
            }
        }
    }

    static boolean available(int num) {
        for (int i = 0; i < num; i++) {
            if (visited[num] == visited[i] || Math.abs(num - i) == Math.abs(visited[num] - visited[i])) {
                return false;
            }
        }
        return true;
    }
}
