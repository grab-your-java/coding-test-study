package BOJ11729;

import java.util.Scanner;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        moveTower(N, 1, 2, 3);

        System.out.println((int) Math.pow(2, N) - 1);
        System.out.println(sb);
    }

    private static void moveTower(int N, int start, int mid, int end) {
        if (N == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        moveTower(N - 1, start, end, mid);

        sb.append(start).append(" ").append(end).append("\n");

        moveTower(N - 1, mid, start, end);
    }
}
