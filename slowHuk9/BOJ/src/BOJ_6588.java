import java.util.Arrays;
import java.util.Scanner;

public class BOJ_6588 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean[] isPrime = new boolean[1000001];

		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i <= Math.sqrt(1000000); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= 1000000; j += i) {
					isPrime[j] = false;
				}
			}
		}

		while (true) {
			int n = sc.nextInt();
			if(n==0) {
				return;
			}
			int max = 0;
			for (int i = 3; i < isPrime.length; i++) {
				if (isPrime[i] && isPrime[n - i]) {
					System.out.println(n + " = " + i + " + " + (n-i));
					break;
				}
				if(i == n-3) {
					System.out.println("Goldbach's conjecture is wrong.");
					break;
				}
			}
		}
	}
}
