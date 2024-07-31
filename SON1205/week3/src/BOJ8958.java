import java.util.Scanner;

public class BOJ8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String[] input = sc.next().split("");

            int sum = 0;
            int cnt = 0;

            for (String string : input) {
                if (string.equals("O")) {
                    sum += ++cnt;
                } else {
                    cnt = 0;
                }
            }

            System.out.println(sum);
        }
    }
}
