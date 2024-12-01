import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		boolean[] isPrime = new boolean[1001];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i <= Math.sqrt(1001); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= 1000; j += i) {
					isPrime[j] = false;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(isPrime[num]) {
				result++;
			}
		}
		System.out.println(result);
	
		
	}
}
