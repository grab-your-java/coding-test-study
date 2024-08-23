package SWEA_1860;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int i = 1; i <= testCase; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();

			int[] eta = new int[N];

			for (int j = 0; j < N; j++) {
				eta[j] = sc.nextInt();
			}

			Arrays.sort(eta);
			
			String answer = "Possible";
			for (int j = 0; j < N; j++) {
				int time = eta[j];
				//(time/M)*K  : 지금까지 만들어진 붕어빵의 개수
				if((time/M)*K < j+1) {
					answer = "Impossible";
				}
			}
            System.out.println("#" + i + " " + answer);
		}
	}
}