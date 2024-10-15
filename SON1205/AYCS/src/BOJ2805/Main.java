package BOJ2805;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] tree = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
        }

        int result = highest(tree, M);

        System.out.println(result - 1);
    }

    private static int highest(int[] tree, int M) {
        Arrays.sort(tree);

        int start = 0;
        int end = tree[tree.length - 1];

        while (start < end) {
            int mid = (start + end) / 2;
//            System.out.println("----------");
//            System.out.println("mid = " + mid);
//            System.out.println("cutTree(tree, mid) = " + cutTree(tree, mid));

            if (cutTree(tree, mid) < M) {
                end = mid;
            } else {
                start = mid + 1;
            }

//            System.out.println("start = " + start);
//            System.out.println("end = " + end);
        }

        return end;
    }

    private static long cutTree(int[] tree, int num) {
        long tmp = 0;

        for (int i = 0; i < tree.length; i++) {
            tmp += (tree[i] - num < 0 ? 0 : tree[i] - num);
        }

        return tmp;
    }
}
