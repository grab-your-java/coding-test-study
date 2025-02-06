package 브론즈;

import java.util.Scanner;

public class BOJ_10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(getAns(N));
	}

	private static int getAns(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		return n * getAns(n - 1);
	}

}
