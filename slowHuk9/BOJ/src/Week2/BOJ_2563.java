package Week2;

import java.util.Scanner;

public class BOJ_2563 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int paper = sc.nextInt();
		int area = 0;
		boolean[][] map = new boolean[100][100];
		//초기값은 false
		
		for (int i = 1; i <= paper; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					if (map[j][k] == false) { // false 이면
						map[j][k] = true; // true 로 만들고
						area++;
					}

				}
			}
		}
		System.out.println(area);
	}

}
