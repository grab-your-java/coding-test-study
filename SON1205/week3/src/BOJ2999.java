import java.util.Scanner;

public class BOJ2999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.next().split("");

        int R = 0;
        for (int i = 1; i <= input.length / 2; i++) {
            int C = input.length / i;
            if (input.length % i == 0 && i <= C) {
                R = i;
            }
        }

        String[][] format = new String[R][input.length / R];

        int idx = 0;
        for (int i = 0; i < input.length / R; i++) {
            for (int j = 0; j < R; j++) {
                format[j][i] = input[idx++];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < input.length / R; j++) {
                System.out.print(format[i][j]);
            }
        }
    }
}
