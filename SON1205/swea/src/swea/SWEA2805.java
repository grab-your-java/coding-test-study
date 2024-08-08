package swea;

import java.util.Scanner;

public class SWEA2805 {//입력을 int로 받아서 나눗셈, 나머지 연산을 사용하려 했음...
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			
			int[][] arr = new int[N][];
			
			for (int j = 0; j < N; j++) {
				arr[j] = new int[N];
				
				String[] x = sc.next().split("");
				
				for (int k = 0; k < N; k++) {
					arr[j][k] = Integer.parseInt(x[k]);
				}
			}
			
			int sum = 0;
			
			for (int p = 0; p < N; p++) {
				for (int q = 0; q < N; q++) {
					if (p < (N + 1)/ 2) {
						if (N / 2 - p <= q && q <= N / 2 + p) {
							sum += arr[p][q];
						}
					} else {
						if (N / 2 - (N - 1 - p) <= q && q <= N / 2 + (N - 1 - p)) {
							sum += arr[p][q];
						}
					}
				}
			}
			
			System.out.println("#" + i + " " + sum);
		}
	}
}
