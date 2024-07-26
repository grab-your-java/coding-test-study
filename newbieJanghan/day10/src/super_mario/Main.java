package super_mario;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;

		int counter = 10;
		while (counter-- > 0) {
			int temp = sum + sc.nextInt();
			if (temp <= 100) {
				if ((100 - sum) > (100 - temp)) {
					sum = temp;
				}
			} else {
				if (Math.abs(100 - sum) >= Math.abs(100 - temp)) {
					sum = temp;
				}
				break;
			}

		}

		System.out.println(sum);
	}
}
