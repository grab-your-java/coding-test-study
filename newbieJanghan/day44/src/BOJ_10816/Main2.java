package BOJ_10816;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.nextLine());
		arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);

		int M = Integer.parseInt(sc.nextLine());
		int[] keys = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		StringBuilder sb = new StringBuilder();
		for (int key : keys) {
			int result = binarySearch(0, N - 1, key);

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

	static int binarySearch(int l, int r, int key) {
		int mid = (l + r) / 2;

		if (arr[mid] == key) {
			return mid;
		}

		if (l == mid) {
			return -1;
		}

		if (arr[mid] > key) {
			return binarySearch(l, mid, key);
		} else {
			return binarySearch(mid + 1, r, key);
		}
	}
}
