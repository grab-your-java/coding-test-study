package BOJ_1107;

import java.util.Arrays;
import java.util.Scanner;

public class Fail2 {
    static int target, current;
    static boolean[] broken;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        target = sc.nextInt();
        int m = sc.nextInt();
        broken = new boolean[10];
        while (m-- >0) {
            broken[sc.nextInt()] = true;
        }

        current = 100;
        if (target == current) {
            System.out.println(0);
            return;
        }

        if (String.valueOf(target).length() >= Math.abs(target - current)) {
            System.out.println(Math.abs(target - current));
            return;
        }

        int[] numbers = Arrays.stream(String.valueOf(target).split("")).mapToInt(Integer::parseInt).toArray();
        searchApproximate(numbers, 0);

        int inputCnt = String.valueOf(current).length();
        int moveCnt = Math.abs(target - current);
        System.out.println(Math.min(inputCnt+moveCnt, Math.abs(target - 100)));
    }

    static void searchApproximate(int[] numbers, int idx) {
        System.out.println(Arrays.toString(numbers) + " idx " + idx);
        if (idx == numbers.length) {
            int tmp = 0;
            for (int i=0; i<numbers.length; i++) {
                tmp += numbers[i] * (int) Math.pow(10, numbers.length - 1 - i);
            }

            if (Math.abs(target - current) > Math.abs(target - tmp)) {
                System.out.println("approximate update: " + tmp);
                current = tmp;
            }
            return;
        }

        int targetNum = numbers[idx];
        if (!broken[targetNum]) {
            searchApproximate(numbers, idx + 1);
        } else {
            int lower = targetNum -1, upper = targetNum + 1;
            while (lower >=0 && broken[lower]) {
                lower--;
            }

            while (upper <=9 && broken[upper]) {
                upper++;
            }

            // invalid lower num
            if (lower == -1 && upper <=9) {
                numbers[idx] = upper;
                searchApproximate(numbers, idx + 1);
            }
            // invalid upper num
            else if (lower >=0 && upper > 9) {
                numbers[idx] = lower;
                searchApproximate(numbers, idx + 1);
            }
            // same dist
            else if (targetNum - lower == upper - targetNum) {
                numbers[idx] = lower;
                searchApproximate(numbers, idx + 1);
                numbers[idx] = upper;
                searchApproximate(numbers, idx + 1);
            }
            // upper is closer
            else if (targetNum - lower > upper - targetNum) {
                numbers[idx] = upper;
                searchApproximate(numbers, idx + 1);
            }
            // lower is closer
            else {
                numbers[idx] = lower;
                searchApproximate(numbers, idx + 1);
            }
        }




    }
}
