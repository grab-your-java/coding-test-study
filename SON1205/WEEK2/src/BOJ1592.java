import java.util.Scanner;

public class BOJ1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int[] people = new int[N];
        int cnt = 0;
        int idx = 0;

        while (true) {
            people[idx]++;

            if (people[idx] == M) {
                break;
            }

            if (people[idx] % 2 == 0) {
                if (idx - L < 0) {
                    idx += N - L;
                } else {
                    idx -= L;
                }
            } else {
                if (idx + L > N - 1) {
                    idx += L - N;
                } else {
                    idx += L;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
