package SWEA_4789;

import java.util.Scanner;

public class Solution {
	static int T;
	static int cnt;
	static int[] arr;
	static String s;
	static int result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			s = sc.next();
			arr = new int[s.length()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Character.getNumericValue(s.charAt(i));
			}
			cnt = arr[0];
			result = 0;
			for (int i = 1; i < arr.length; i++) {
				if (cnt > i) {
					cnt += arr[i];
					continue;
				} else {
					int need = i - cnt;
					result += need;
					cnt += need;

					cnt += arr[i];
				}
			}
			System.out.println("#" + test_case + " " + result);

		}
	}
}
