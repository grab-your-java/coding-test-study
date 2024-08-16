package N과M;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		int num = 1;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = num++;
		}
		int[] output = new int[M];
		combination(arr, output, 0, 0, M);
	}

	static void combination(int[] arr, int[] output, int start, int depth, int M) {

		if(depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(output[i] + " ");
			}System.out.println();
			return;
			
		}
		
		for (int i = start; i < arr.length; i++) {
			output[depth] = arr[i];
			combination(arr, output, i + 1, depth + 1, M);
		}
	}

}
