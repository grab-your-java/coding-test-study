import java.util.Scanner;

public class BOJ3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = new int[10];

        for (int i = 0; i < 10; i++) {
            input[i] = sc.nextInt() % 42;
        }

        int cnt = 10;
        int compIdx = 0;

        while (compIdx < 10) {
            for (int i = compIdx + 1; i < 10; i++) {
                if (input[compIdx] == input[i]) {
                    cnt--;
                    break;
                }
            }
            compIdx++;
        }

        System.out.println(cnt);

    }
}
