import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// M과 N이 주어질때 그 사이의 소수 구하기
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true); // 전부 소수로 설정 TRUE
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (isPrime[i]) {
				// 만약 소수라면
				// 해당 수를 제외한 배수는 이미 합성수이다
				// 2일 때, 2는 이미 true로 소수이고, 4부터 체크를 풀면 됨
				// 3일 때, 3은 이미 true 소수 / 3*2는 2에서 이미 체크가 풀렸으니 3*3 부터 풀면 됨
				// 4일때, 이미 2에서 체크가 풀려있음
				// 5 일때, 5는 이미 true 소수 / 5*2, 5*3, 5*4 (5*2*2)로 이미 풀려서 5*5부터 풀면 됨
				for (int j = i * i; j < N + 1; j += i) { // i^2 부터 시작해서 N까지 i의 배수들을 체크 풀기
					isPrime[j] = false;
				}
			}
		}
		for (int i = 2; i < isPrime.length; i++) {
			if(M<=i && i<=N && isPrime[i]) {
				System.out.println(i);
			}
		}

	}
}