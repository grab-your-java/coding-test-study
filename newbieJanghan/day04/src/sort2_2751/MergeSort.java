package sort2_2751;

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
		list = mergeSort(list, 0, list.length - 1);

		// print
		for (int i = 0; i < N; i++) {
			System.out.println(list[i]);
		}
	}

	public static int[] mergeSort(int[] list, int l, int r) {
		if (l >= r) {
			int[] unitList = { list[l] };
			return unitList;
		}

		int mid = (l + r) / 2;
		int[] left = mergeSort(list, l, mid);
		int[] right = mergeSort(list, mid + 1, r);
		return merge(left, right);
	}

	public static int[] merge(int[] left, int[] right) {
		int[] temp = new int[left.length + right.length];
		
		int i = 0;
		int j = 0;
		for (int k=0; k<temp.length; k++) {
			if (i>=left.length) {
				temp[k] = right[j++];
				continue;
			}
			
			if (j>=right.length) {
				temp[k] = left[i++];
				continue;
			}
			
			if (left[i] <= right[j]) {
				temp[k] = left[i++];
			} else {
				temp[k] = right[j++];
			}
		}
		
		return temp;
	}
}
