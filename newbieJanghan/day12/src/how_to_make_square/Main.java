package how_to_make_square;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int result = 0;
		for (int i=1; i<=Math.sqrt(N); i++) {
			int divided = N / i;
			for (int j=i; j<=divided; j++) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}