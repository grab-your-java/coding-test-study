import java.util.Scanner;

public class BOJ2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int p = N / 5;
        int q = N % 5;

        while (p >= 0) {
            if (q % 3 != 0) {
                p -= 1;
                q += 5;
            } else {
                q /= 3;
                System.out.println(p + q);
                return;
            }
        }

        System.out.println(-1);

    }
}
