import java.util.Scanner;

public class BOJ_1929 {
	public static void main(String[] args) {
		// M과 N이 주어질때 그 사이의 소수 구하기
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		for (int i = M; i <= N; i++) {
			boolean sosu = true;
			if(i == 1) {
				continue;
			}
			out: for (int j = 2; j <= (int) Math.sqrt(i); j++) {
				if (j == 1 || j == i)
					continue; // 1, j로는 당연히 나눠짐
				if (i % j == 0) { // 1 , j 를 제외한 수로 나눠지면 소수가 아니다.
					sosu = false;
				}
				if (!sosu) {
					break out;
				}
			}
			if (sosu) {
				System.out.println(i);
				continue;
			}
		}
	}
}
