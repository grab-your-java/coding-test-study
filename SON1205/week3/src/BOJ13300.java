import java.util.Scanner;

public class BOJ13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] women = new int[7];
        int[] men = new int[7];

        for (int i = 0; i < N; i++) {
            int sex = sc.nextInt();
            int grade = sc.nextInt();

            if (sex == 1) {
                women[grade]++;
            } else {
                men[grade]++;
            }
        }

        int result = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                if (i == 0) {
                    if (women[j] % K != 0) {
                        result += women[j] / K + 1;
                    } else {
                        result += women[j] / K;
                    }
                } else {
                    if (men[j] % K != 0) {
                        result += men[j] / K + 1;
                    } else {
                        result += men[j] / K;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
