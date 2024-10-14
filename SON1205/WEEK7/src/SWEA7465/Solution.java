package SWEA7465;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static int[] root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            root = new int[N + 1];

            for (int i = 1; i < root.length; i++) {
                root[i] = i;
            }

            for (int i = 0; i < M; i++) {
                union(sc.nextInt(), sc.nextInt());
            }

            Set<Integer> set = new HashSet<>();

            for (int i = 1; i < root.length; i++) {
                set.add(findSet(i));
            }

            System.out.println("#" + tc + " " + set.size());
        }
    }

    static int findSet(int x) {
        if (root[x] == x) {
            return x;
        } else {
            return root[x] = findSet(root[x]);
        }
    }

    static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        if (x != y) {
            if (x <= y) {
                root[y] = x;
            } else {
                root[x] = y;
            }


        }
    }
}