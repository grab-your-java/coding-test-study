package 실버;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1920 {
	static int arrSize;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arrSize = sc.nextInt();
		arr = new int[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = sc.nextInt();
		}
		int findSize = sc.nextInt();
		int[] findList = new int[findSize];
		for (int i = 0; i < findSize; i++) {
			findList[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < findSize; i++) {
			System.out.println((findNum(findList[i]) ? 1 : 0));
		}
	}

	private static boolean findNum(int num) {
		int startIdx = 0;
		int lastIdx = arrSize;
		int middleIdx;
		while (startIdx < lastIdx) {
			middleIdx = (startIdx + lastIdx) / 2;
			if (arr[middleIdx] < num) {
				startIdx = middleIdx + 1;
			} else if (arr[middleIdx] > num) {
				lastIdx = middleIdx;
			} else {
				return true;
			}
		}
		return false;
	}

}
