import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2805 {
	static int[] trees;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		trees = new int[N];
		int min = 0;
		int max = 0;
		for (int i = 0; i < trees.length; i++) {
			trees[i] = sc.nextInt();
		}
		Arrays.sort(trees);
		max = trees[trees.length - 1];

		while (min < max) {
			int mid = (min + max) / 2;
			long sum = 0;

			for (int i = 0; i < trees.length; i++) {
				if (trees[i] - mid > 0)
					sum += (trees[i] - mid);
			}
			
			if(sum < M) {
				max = mid;
			}
			else { // sum >= M
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}

//	static int binarySearch(int key, int low, int high) {
//		int mid;
//
//		while (low <= high) {
//			mid = (low + high) / 2;
//			if (key == trees[mid]) {
//				return mid;
//			} else if (key < trees[mid]) {
//				high = mid - 1;
//			} else {
//				low = mid + 1;
//			}
//		}
//		return -1; // 탐색 실패
//	}

}
