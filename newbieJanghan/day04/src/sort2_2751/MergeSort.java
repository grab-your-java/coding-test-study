package sort2_2751;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] list = new int[N];

		// insert
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		// sort
		mergeSort(list, 0, list.length - 1);

		// print
		for (int i = 0; i < N; i++) {
			System.out.println(list[i]);
		}
	}

	public static void mergeSort(int[] list, int l, int r) {
		if (l >= r) {
			return;
		}

		int mid = (l + r) / 2;
		// System.out.println("left: " + l + " right: " + r + " mid: " + mid);
		mergeSort(list, l, mid);
		mergeSort(list, mid + 1, r);
		// System.out.println();
		// System.out.println("****merge called****");
		merge(list, l, r, mid);
	}

	public static void merge(int[] list, int l, int r, int mid) {
		int[] temp = new int[list.length];
		
		int i = l;
		int j = mid + 1;
		int k = l;
		// System.out.println("left: " + l + " right: " + r + " mid: " + mid);
		// System.out.println("i: " + i + " j: " + j + " target: " + k);
		// System.out.println();

		while (i <= mid && list[i] <= list[j]) {
			// System.out.println("temp[" + k + "] = " + list[i] + "( i = " + i + " )");
			temp[k++] = list[i++];
		}

		while (j <= r && list[j] <= list[i]) {
			// System.out.println("temp[" + k + "] = " + list[j] + "( j = " + j + " )");
			temp[k++] = list[j++];
		}

		while (i <= mid) {
			// System.out.println("temp[" + k + "] = " + list[i] + "( i = " + i + " )");
			temp[k++] = list[i++];
		}
		
		while (j <= r) {
			// System.out.println("temp[" + k + "] = " + list[j] + "( j = " + j + " )");
			temp[k++] = list[j++];
		}

		// System.out.println("Result: " + Arrays.toString(temp));
		for (int h=l; h<=r; h++) {
			list[h] = temp[h];
		}
	}
}
