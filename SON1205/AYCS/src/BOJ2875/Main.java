package BOJ2875;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int girl = 0;
        int result = 0;

        while (girl <= K) {
            int tmpGirl = N - girl;
            int tmpBoy = M - (K - girl);

            if (!(tmpGirl > 0 && tmpBoy > 0)) {
                girl++;
                continue;
            }

            result = Math.max(result, Math.min(tmpGirl / 2, tmpBoy));
            
            girl++;
        }

        System.out.println(result);
    }
}
