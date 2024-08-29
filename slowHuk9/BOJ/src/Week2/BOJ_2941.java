package Week2;

import java.util.Scanner;

public class BOJ_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int cnt = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'c') {
				if (i < s.length() - 1 && s.charAt(i + 1) == '=') {
					cnt++;
					i++;
				} else if (i < s.length() - 1 && s.charAt(i + 1) == '-') {
					cnt++;
					i++;
				} else
					cnt++;
			} else if (s.charAt(i) == 'd') {
				if (i < s.length() - 2 && s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=') {
					cnt++;
					i += 2;
				} else if (i < s.length() - 1 && s.charAt(i + 1) == '-') {
					cnt++;
					i++;
				} else
					cnt++;
			} else if (s.charAt(i) == 'l' || s.charAt(i) == 'n') {
				if (i < s.length() - 1 && s.charAt(i + 1) == 'j') {
					cnt++;
					i++;
				} else {
					cnt++;
				}
			} else if (s.charAt(i) == 's' || s.charAt(i) == 'z') {
				if (i < s.length() - 1 && s.charAt(i + 1) == '=') {
					cnt++;
					i++;
				} else {
					cnt++;
				}
			} else
				cnt++;
		}
		System.out.println(cnt);
	}
}
