import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int times = sc.nextInt();
		for (int i = 0; i < times; i++) {
			int key = sc.nextInt();
			if (binarySearch(arr, key) >= 0)
				System.out.println(1);
			else
				System.out.println(0);
		}

	}

	static int binarySearch(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (key < arr[mid]) {
				hi = mid - 1;
			} else if (key > arr[mid]) {
				lo = mid + 1;
			} else { // key == arr[mid] key를 찾으면
				return mid;
			}
		}
		// 다 돌았는데 못찾으면 -1
		return -1;
	}
}
