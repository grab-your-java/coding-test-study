import java.util.Scanner;

public class BOJ2810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] seats = sc.next().split("");

        int ch = 1;
        int cntL = 0;

        for (int i = 0; i < N; i++) {
            if (seats[i].equals("S")) {
                ch++;
                continue;
            }

            cntL++;

            if (cntL % 2 == 0) {
                ch++;
            }
        }

        int result = N;

        if (ch < N) {
            result = ch;
        }

        System.out.println(result);

    }
}