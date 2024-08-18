package SWEA_7087;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] Alphabet = new int[26];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				if (65 <= (int) s.charAt(0) && (int) s.charAt(0) <= 90) {
					Alphabet[(int) s.charAt(0) - 65]++;
				}
			}
			int cnt = 0;
			for (int i = 0; i < Alphabet.length; i++) {
				if(Alphabet[i] != 0) {
					cnt++;
				}
				else {
					break;
				}
			}
			System.out.println("#"+ test_case + " " + cnt);
		}
	}
}
