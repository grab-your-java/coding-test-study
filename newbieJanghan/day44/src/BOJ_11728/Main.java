package BOJ_11728;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int stopper = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();

		int[] A = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		sort(A, 0, A.length - 1);

		int[] B = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		sort(B, 0, B.length - 1);

		StringBuilder sb = new StringBuilder();
		int aIdx = 0, bIdx = 0;
		while (aIdx < A.length && bIdx < B.length) {
			if (A[aIdx] < B[bIdx]) {
				sb.append(A[aIdx++]).append(" ");
			} else {
				sb.append(B[bIdx++]).append(" ");
			}
		}

		while (aIdx == A.length && bIdx != B.length) {
            sb.append(B[bIdx++]).append(" ");
        }
        
        while (bIdx == B.length && aIdx != A.length) {
            sb.append(A[aIdx++]).append(" ");
        }

		System.out.println(sb);
	}

	static void sort(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		
		if (left != mid) {
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
		}

		if (arr[left] > arr[right]) {
			int tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
		}
	}
}
