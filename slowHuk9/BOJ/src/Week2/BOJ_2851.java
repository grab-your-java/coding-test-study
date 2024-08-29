package Week2;

import java.util.Scanner;

public class BOJ_2851 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];

		int sum = 0;
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum >= 100) {
				int smallSum = 0;
				smallSum = sum - arr[i];
				if (sum - 100 > 100 - smallSum) {
					result = smallSum;
				} else {
					result = sum;
				}
				break;
			} else {
				result = sum;
			}
		}
		System.out.println(result);

	}

}
