package sort;

import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] list = new int[N];

		// insert
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}

		// sort
		sort(list, 0, N - 1);

		// print
		for (int i = 0; i < N; i++) {
			System.out.println(list[i]);
		}

	}

	public static void sort(int[] list, int l, int r) {
		if (l >= r)
			return;

		int pivot = list[l];
		int low = l + 1;
		int high = r;

		while (low <= high) {
			while (low <= r && list[low] < pivot) {
				low++;
			}

			while (high >= l && list[high] > pivot) {
				high--;
			}

			if (low <= high) {
				int temp = list[low];
				list[low] = list[high];
				list[high] = temp;
			}
		}

		list[l] = list[high];
		list[high] = pivot;

		sort(list, l, high - 1);
		sort(list, high + 1, r);
	}
}
