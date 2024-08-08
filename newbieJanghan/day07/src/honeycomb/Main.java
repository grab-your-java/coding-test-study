package honeycomb;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        int count = 1;
        int multiplier = 0;
        int start = 1;
        int end = 1;

        while (true) {
            if (start <= N && N <= end) {
                break;
            }

            multiplier += count;
            start = end + 1;
            end = 6 * multiplier + 1;

            count++;
        }

        System.out.println(count);
    }
}
