import java.util.Scanner;

public class BOJ2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];
        int total = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        int num1 = -1;
        int num2 = -1;

        for (int i = 0; i < 8; i++) {
            if (total - arr[i] <= 100) {
                continue;
            }
            for (int j = i + 1; j < 9; j++) {
                if (total - arr[i] - arr[j] == 100) {
                    num1 = arr[i];
                    num2 = arr[j];
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i] == num1 || arr[i] == num2) {
                continue;
            }
            System.out.println(arr[i]);
        }

    }
}
