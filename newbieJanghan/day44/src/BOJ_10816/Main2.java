package BOJ_10816;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int M = sc.nextInt();
		int[] keys = new int[M];
		for (int i = 0; i < M; i++) {
			keys[i] = sc.nextInt();
		}

		StringBuilder sb = new StringBuilder();
		for (int key : keys) {
			int result = binarySearch(arr, 0, arr.length - 1, key);
			int cnt = 0;
			for (int i = result; i >= 0 && i < N; i++) {
				if (arr[i] != key) {
					break;
				}
				cnt++;
			}

			for (int i = result - 1; i >= 0; i--) {
				if (arr[i] != key) {
					break;
				}
				cnt++;
			}
			
			sb.append(cnt).append(" ");
		}

		System.out.println(sb);
	}

	static int binarySearch(int[] arr, int l, int r, int key) {
		int mid = (l + r) / 2;

		if (arr[mid] == key) {
			return mid;
		}

		if (l == mid) {
			return -1;
		}

		if (arr[mid] > key) {
			return binarySearch(arr, l, mid, key);
		} else {
			return binarySearch(arr, mid + 1, r, key);
		}
	}
}
