import java.util.Scanner;
//주어진 조건 해석 실수 ( 최소 값이 1이다 )
public class BOJ2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        int result = 0;
        int diffMin = M;
        for (int i = 0; i < N - 2; i++) {
            if (cards[i] > M - 2) {
                continue;
            }
            for (int j = i + 1; j < N - 1; j++) {
                if (cards[i] + cards[j] > M - 1) {
                    continue;
                }
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum > M) {
                        continue;
                    }

                    if (diffMin > M - sum) {
                        result = sum;
                        diffMin = M - sum;
                    }

                    if (diffMin == 0) {
                        System.out.println(result);
                        return;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
