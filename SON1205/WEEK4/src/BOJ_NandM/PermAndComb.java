package BOJ_NandM;

import java.util.ArrayList;
import java.util.List;

public class PermAndComb {
    public static void main(String[] args) {
        //초기 값 설정
        int N = 100;
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = i + 1;
        }
        int r = 4;

        //순열, 중복 X, 결과값을 배열 또는 리스트로 뽑아 비교하기
        long start1 = System.nanoTime();
        System.out.println("permutationByArr");
        permutationByArr(input, new int[r], new boolean[input.length], 0, r);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        System.out.println("permutationByList");
        permutationByList(input, new ArrayList<>(), new boolean[input.length], 0, r);
        long end2 = System.nanoTime();

        System.out.println("time1 = " + (end1 - start1));
        System.out.println("time2 = " + (end2 - start2));

        //순열, 중복 O, 결과값을 배열로
//        permutationPi(input, new int[r], 0, r);

        //조합, 중복 X, 결과값을 배열로
//        combination(input, new boolean[input.length], 0, 0, r);

//        combinationH(input, new int[r], 0, 0, r);
    }

    static void permutationByArr(int[] input, int[] output, boolean[] visited, int depth, int r) {
        if (depth == r) {
            //logic
//            for (int num : output) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = input[i];
                permutationByArr(input, output, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    static void permutationPi(int[] input, int[] output, int depth, int r) {
        if (depth == r) {
//            for (int num : output) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
            return;
        }

        for (int i = 0; i < input.length; i++) {
            output[depth] = input[i];
            permutationPi(input, output, depth + 1, r);
        }
    }

    static void combination(int[] input, boolean[] visited, int start, int depth, int r) {
        if (depth == r) {
//            for (int i = 0; i < input.length; i++) {
//                if (visited[i]) {
//                    System.out.print(input[i] + " ");
//                }
//            }
//            System.out.println();
            return;
        }

        for (int i = start; i < input.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(input, visited, i + 1, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    static void combinationH(int[] input, int[] output, int start, int depth, int r) {
        if (depth == r) {
            for (int num : output) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < input.length; i++) {
            output[depth] = input[i];
            combinationH(input, output, i, depth + 1, r);
        }
    }

    static void permutationByList(int[] input, List<Integer> output, boolean[] visited, int depth, int r) {
        if (depth == r) {
            //logic
//            for (int num : output) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output.add(input[i]);
                permutationByList(input, output, visited, depth + 1, r);
                output.remove(depth);
                visited[i] = false;
            }
        }
    }
}
