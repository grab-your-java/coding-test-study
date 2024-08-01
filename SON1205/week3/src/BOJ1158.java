import java.util.Scanner;

public class BOJ1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        int cnt = 0;
        int idx = -1;
        System.out.print("<");
        while (cnt < N) {
            int skip = K;

//            while (skip > 0) { 시간 2228ms
//                idx = ++idx % N;
//                if (arr[idx] == 0) {
//                    skip--;
//                }
//            }

            while (skip > 0) {
                if (idx >= N - 1) {
                    idx = ++idx % N;
                } else {
                    idx++;
                }

                if (arr[idx] == 0) {
                    skip--;
                }
            }

            arr[idx]++;
            System.out.print(idx + 1);
            if (cnt != N - 1) {
                System.out.print(", ");
            } else {
                System.out.println(">");
            }
            cnt++;
        }
    }
}
