package rc_car;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			int velocity = 0;
			int distance = 0;

			for (int i = 0; i < N; i++) {
				int command = sc.nextInt();
				switch (command) {
					case 1:
						velocity += sc.nextInt();
						break;
	
					case 2:
						velocity -= sc.nextInt();
						if (velocity < 0) {
							velocity = 0;
						}	
						break;
					default:
						break;
				}
				
				distance+=velocity;
			}

			System.out.println("#" + t + " " + distance);
		}
	}
}
