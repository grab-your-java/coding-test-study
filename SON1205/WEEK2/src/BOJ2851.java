import java.util.Scanner;

public class BOJ2851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] items = new int[10];

        for (int i = 0; i < 10; i++) {
            items[i] = sc.nextInt();
        }

        int sum = 0;
        int result = 0;
        int idx = 0;

        while (sum < 100) {
            sum += items[idx++];
            if (idx == 10 && sum <= 100) {
                System.out.println(sum);
                return;
            }
        }

        int beforeSum = sum - items[idx - 1];

        if (sum - 100 <= 100 - beforeSum) {
            result = sum;
        } else {
            result = beforeSum;
        }

        System.out.println(result);
    }
}
