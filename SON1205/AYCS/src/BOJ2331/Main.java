package BOJ2331;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int P = sc.nextInt();

        int result = findLoop(A, P);

        System.out.println(result);
    }

    private static int findLoop(int a, int p) {
        List<Integer> list = new ArrayList<>();

        list.add(a);

        while (true) {
            int next = 0;

            int tmp = list.getLast();

            while (tmp > 0) {
                next += (int) Math.pow(tmp % 10, p);
                tmp /= 10;
            }

            if (list.contains(next)) {
                return list.indexOf(next);
            }

            list.add(next);
        }
    }
}
