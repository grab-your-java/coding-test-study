package BOJ10610;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();

        int sum = 0;
        boolean findZero = false;

        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            if (input[i] == '0') findZero = true;
        }

        if (findZero && sum % 3 == 0) {
            Arrays.sort(input);

            StringBuilder sb = new StringBuilder();
            for (int i = input.length - 1; i >= 0; i--) {
                sb.append(input[i]);
            }
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }
    }
}
