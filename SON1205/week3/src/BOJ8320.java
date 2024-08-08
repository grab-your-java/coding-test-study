import java.util.Scanner;

public class BOJ8320 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(makeSquare(N));
    }

    static int makeSquare(int n) {
        if (n == 1) {
            return 1;
        }
        int result = 0;

        for (int i = 1; i <= n / 2; i++) {
            if (i * (n / i) == n && i <= n / i) {
                result++;
            }
        }

        return makeSquare(n - 1) + result;
    }
}
