package croatian_alphabet;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] cArr = sc.next().toCharArray();

		int result = 0;
		int i = 0;
		while (i < cArr.length) {
			if (i == cArr.length - 1) {
				result++;
				break;
			}
			char c = cArr[i];
			char next = cArr[i + 1];

			switch (c) {
			case 'c':
				if (next == '=' || next == '-') {
					i += 2;
				} else {
					i++;
				}
				break;
			case 'd':
				if (next == 'z' && i + 2 < cArr.length && cArr[i + 2] == '=') {
					i += 3;
				} else if (next == '-') {
					i += 2;
				} else {
					i++;
				}
				break;
			case 'l':
			case 'n':
				if (next == 'j') {
					i += 2;
				} else {
					i++;
				}
				break;
			case 's':
			case 'z':
				if (next == '=') {
					i += 2;
				} else {
					i++;
				}
				break;
			default:
				i++;
			}
			result++;
		}
		System.out.println(result);
	}
}
