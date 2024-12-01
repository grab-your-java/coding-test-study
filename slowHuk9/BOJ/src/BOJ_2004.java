import java.util.Scanner;

public class BOJ_2004 {

	static int[] factorial = { 1, 1, 2, 6, 24, 120, 720 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
//		int[] fac = new int[];
//		System.out.println(combCnt(N, M));
		int combCnt = combCnt(N, M);
		int result = cntZero(combCnt);
		System.out.println(result);

	}

	 static int combCnt(int N, int M) {
	        int[][] C = new int[N + 1][M + 1];
	        for (int i = 0; i <= N; i++) {
	            for (int j = 0; j <= Math.min(i, M); j++) {
	                if (j == 0 || j == i) {
	                    C[i][j] = 1;
	                } else {
	                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
	                }
	            }
	        }
	        return C[N][M];
	    }

	static int cntZero(int combCnt) {
		String number = Integer.toString(combCnt);
		int result = 0;
		if (number.charAt(number.length() - 1) == '0') {
			result++;
			int index = number.length() - 1;
			while (index >= 0) {
				index--;
				if (number.charAt(index) == '0') {
					result++;
				} else {
					return result;
				}

			}
		}
		return result;

	}

}
