package square;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 4;
		while (T-- > 0) {
			int ax1 = sc.nextInt();
			int ay1 = sc.nextInt();
			int ax2 = sc.nextInt();
			int ay2 = sc.nextInt();
			int bx1 = sc.nextInt();
			int by1 = sc.nextInt();
			int bx2 = sc.nextInt();
			int by2 = sc.nextInt();
			
			// case none
			if (ax2 < bx1 || bx2 < ax1 || ay2 < by1 || by2 < ay1) {
				System.out.println("d");
			} 
			
			// case dot 
			else if ((ax2 == bx1 && ay2 == by1) || (ax2 == bx1 && ay1 == by2) || 
					(bx2 == ax1 && by2 == ay1) || (bx2 == ax1 && by1 == ay2)  ) {
				System.out.println("c");
			}
			
			// case line
			else if (ax2 == bx1 || ay2 == by1 || ax1 == bx2 || ay1 == by2) {
				System.out.println("b");
			}
			
			// case none
			else {
				System.out.println("a");
			}
			
		}

	}
}
