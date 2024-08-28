package SWEA_5356;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int test_case = sc.nextInt();

		for (int i = 1; i <= test_case; i++) {

			String[] words = new String[5];
			for (int j = 0; j < 5; j++) {
				words[j] = sc.next();
			}

			char[][] map = new char[5][15];

			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 15; k++) {
					map[j][k] = '\0';
				}
			}

			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < words[j].length(); k++) {
					map[j][k] = words[j].charAt(k);
				}
			}

			System.out.print("#" + i + " ");
			for (int k = 0; k < 15; k++) {
				for (int j = 0; j < 5; j++) {
					if (map[j][k] != '\0') {
						System.out.print(map[j][k]);
					}
				}
			}
			System.out.println();
		}

	}

}