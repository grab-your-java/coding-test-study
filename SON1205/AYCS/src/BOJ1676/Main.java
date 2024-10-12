package BOJ1676;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int cnt = 0;

        for (int i = 0; i <= N; i++) {
            int tmp = 0;
            int num = i;

            while (num > 0 && num % 5 == 0) {
                tmp++;
                num /= 5;
            }

            cnt += tmp;
        }

        System.out.println(cnt);
    }
}
