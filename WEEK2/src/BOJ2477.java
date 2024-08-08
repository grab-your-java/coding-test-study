import java.util.Scanner;

public class BOJ2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int result = 1;

        int[] directions = new int[6];
        int[] meters = new int[6];

        for (int i = 0; i < 6; i++) {
            directions[i] = sc.nextInt();
            meters[i] = sc.nextInt();
        }

        int idx = 0;
        int[] longMeter = new int[2];

        for (int i = 0; i < 6; i++) {
            boolean flag = true;
            for (int j = 0; j < 6; j++) {
                if (directions[i] == directions[j] && i != j) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result *= meters[i];
                longMeter[idx++] = i;
            }
        }

        int minus = 1;

        if (longMeter[0] == 0 && longMeter[1] == 5) {
            longMeter[1] = 0;
        }

        if (longMeter[1] + 2 > 5) {
            minus *= meters[longMeter[1] - 4];
        } else {
            minus *= meters[longMeter[1] + 2];
        }

        if (longMeter[1] + 3 > 5) {
            minus *= meters[longMeter[1] - 3];
        } else {
            minus *= meters[longMeter[1] + 3];
        }

        result -= minus;

        System.out.println(result * K);
    }
}
