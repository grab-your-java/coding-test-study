import java.util.Scanner;

public class BOJ_1676 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 0;

		while (N >= 5) {
			cnt += N / 5;
			N = N / 5;
		}
		System.out.println(cnt);
	}
}
//		응 아니야 ㅋ 
//		long[] fac = new long[501];
//
//		fac[0] = 1;
//		fac[1] = 1;
//
//		for (int i = 2; i < fac.length; i++) {
//			fac[i] = fac[i - 1] * i;
//		}
//		System.out.println(fac[N]);
//
//		System.out.println(findZero(fac[N]));
//
//	}
//
//	static int findZero(long num) {
//		String numStr = Long.toString(num);
//		int result = 0;
//
//		for (int i = numStr.length()-1; i >=0; i--) {
//			if(numStr.charAt(i) == '0') {
//				result++;
//			}
//			if(result > 0 && numStr.charAt(i) != '0') {
//				return result;
//			}
//		}
//		return result;
//
//	}
