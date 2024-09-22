package SWEA_1952_수영장;
import java.util.Scanner;

public class SWEA_1952 {
	static int[] price;
	static int[] useCnt;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			price = new int[4]; // 0 : 일일권 1 : 한달권 2: 세달 3: 일년
			useCnt = new int[13];
			for (int i = 0; i < price.length; i++) {
				price[i] = sc.nextInt();
			}
			int daySum = 0;
			for (int i = 1; i < useCnt.length; i++) {
				useCnt[i] = sc.nextInt();
				daySum += useCnt[i];
			}
			min = Math.min(price[3], daySum * price[0]);
			calculation(1, 0);
			System.out.println("#" + tc + " " + min);
		}
	}

	static void calculation(int month, int totalPrice) {
		if (totalPrice > min) {
			return;
		}

		if (month > 12) {
			min = Math.min(totalPrice, min);
			return;
		}

		if (useCnt[month] == 0) {
			calculation(month + 1, totalPrice);
		} else {
			// 일일권 사용할 때
			calculation(month + 1, totalPrice + price[0] * useCnt[month]);
			// 한달권
			calculation(month + 1, totalPrice + price[1]);
			// 세달
			calculation(month + 3, totalPrice + price[2]);
		}
	}
}
