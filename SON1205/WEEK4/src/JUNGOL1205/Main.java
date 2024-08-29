package JUNGOL1205;

import java.util.Scanner;

//규칙 파악 잘하자
// 똑같은 숫자가 나와도 상관 없었음
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] arr = new int[1000001];

        for (int i = 0; i < N; i++) {
            arr[scanner.nextInt()]++;
        }

        int max = 1;

        for (int i = 1; i < arr.length; i++) {
            int zero = arr[0];

            if (zero == N || zero == N -1) {
                max = N;
            }

            if (arr[i] == 0) {
                continue;
            }

            int length = 1;

            if (i == arr.length -1 && arr[arr.length - 1] != 0) {
                length += zero;
            }


            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == 0) {
                    if (zero != 0) {
                        zero--;
                        length++;
                        continue;
                    } else {
                        break;
                    }
                } else {
                    length++;
                    if (j == arr.length - 1) {
                        length += zero;
                    }
                    continue;
                }
            }


            if (max < length) {
                max = length;
            }
        }

        System.out.println(max);

    }
}