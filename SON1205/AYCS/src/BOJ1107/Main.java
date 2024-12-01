package BOJ1107;

import java.util.Scanner;

public class Main {
    static int result;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int num = N;
        int digit = 0;

        if (num == 0) {
            digit = 1;
        } else {
            while (num > 0) {
                num /= 10;
                digit++;
            }
        }

        boolean[] isValid = new boolean[10];

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            isValid[sc.nextInt()] = true;
        }

        result = Math.abs(N - 100);

        //임의의 번호를 누르고 +-로 이동
        //바로 +-로 이동
        makeNum(isValid, digit + 1, 0, 0, 0);
        makeNum(isValid, digit, 0, 0, 0);
        if (digit > 1) {
            makeNum(isValid, digit - 1, 0, 0, 0);
        }

        System.out.println(result);
    }

    private static void makeNum(boolean[] isValid, int digit, int depth, int cnt, int tmp) {
        if (cnt == digit) {
            result = Math.min(result, Math.abs(tmp - N) + digit);
            return;
        }

        for (int i = 0; i < isValid.length; i++) {
            if (!isValid[i]) {
                makeNum(isValid, digit, depth + 1, cnt + 1, tmp + (int) (i * Math.pow(10, digit - cnt - 1)));
            }
        }
    }
}
