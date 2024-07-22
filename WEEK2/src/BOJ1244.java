package baekjoon;

import java.util.Scanner;

public class BOJ1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] switches = new int[N];

        for (int i = 0; i < N; i++) {
            switches[i] = sc.nextInt();
        }

        int people = sc.nextInt();

        for (int i = 0; i < people; i++) {
            int sex = sc.nextInt();
            int num = sc.nextInt();

            if (sex == 1) {
                for (int j = 0; j < N; j++) {
                    if ((j + 1) % num == 0) {
                        switches[j] = switches[j] == 1 ? 0 : 1;
                    }
                }
            } else {
                int idx = 1;
                num -= 1;
                while (0 <= num - idx && num + idx < N) {
                    if (switches[num - idx] != switches[num + idx]) {
                        break;
                    }
                    idx++;
                }
                idx--;

                for (int j = num - idx; j <= num + idx; j++) {
                    switches[j] = switches[j] == 1 ? 0 : 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(switches[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}
