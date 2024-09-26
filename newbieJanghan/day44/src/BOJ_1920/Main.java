package BOJ_1920;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextLine();
		int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(a);

		sc.nextLine();
		int[] b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		StringBuilder sb = new StringBuilder();
		for (int key : b) {
			if (binarySearch(a, 0, a.length - 1, key)) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static boolean binarySearch(int[] arr, int l, int r, int key) {
		int mid = (l + r) / 2;

		if (arr[mid] == key) {
			return true;
		}

		if (l >= r) {
			return false;
		}

		if (arr[mid] < key) {
			return binarySearch(arr, mid + 1, r, key);
		} else {
			return binarySearch(arr, l, mid, key);
		}
	}
}
