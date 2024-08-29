import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2999 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int N = s.length();

		int R = 0;
		int C = 0;
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				int r = i;
				int c = N / i;
				if (r <= c) {
					C = c;
					R = r;
				}
			}
		}
		char[][] secret = new char[R][C];
		char[] original = new char[s.length()];
		int index = 0;
		// 1. 받은 메세지를 열 고정, 행 순회 순서로 해독
		for (int c = 0; c < secret[0].length; c++) {
			for (int r = 0; r < secret.length; r++) {
				secret[r][c] = s.charAt(index);
				index++;
			}
		}
	//	System.out.println(Arrays.deepToString(secret));
		// 2. 행 고정, 열 순회 순서로 읽는다.
		index = 0;
		for (int r = 0; r < secret.length; r++) {
			for (int c = 0; c < secret[0].length; c++) {
				original[index] = secret[r][c];
				index++;
			}
		}
	//	System.out.println(Arrays.toString(original));
		
		String result = new String(original);
		System.out.println(result);
	}
}