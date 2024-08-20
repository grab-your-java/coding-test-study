package SWEA_7272;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		test: for (int test_case = 1; test_case <= T; test_case++) {
			char[] arr1 = sc.next().toCharArray();
			char[] arr2 = sc.next().toCharArray();

			if (arr1.length != arr2.length) {
				System.out.println("#" + test_case + " DIFF");
				continue;
			} else {
				for (int i = 0; i < arr1.length; i++) {
					// arr1 arr2
					switch (arr1[i]) {
					case 'A':
					case 'D':
					case 'O':
					case 'P':
					case 'Q':
					case 'R':
						arr1[i] = '1';
						break;
					case 'B':
						arr1[i] = '2';
						break;
					default:
						arr1[i] = '0';
					}

					switch (arr2[i]) {
					case 'A':
					case 'D':
					case 'O':
					case 'P':
					case 'Q':
					case 'R':
						arr2[i] = '1';
						break;
					case 'B':
						arr2[i] = '2';
						break;
					default:
						arr2[i] = '0';
					}

				}
				int cnt = 0;
				for (int i = 0; i < arr2.length; i++) {
					if (arr1[i] != arr2[i]) {
						System.out.println("#" + test_case + " DIFF");
						continue test;
					} else {
						cnt++;
					}
				}
				if (cnt == arr2.length) {
					System.out.println("#" + test_case + " SAME");
				}

			}
		}
	}

}
