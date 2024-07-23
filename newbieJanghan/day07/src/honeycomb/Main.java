package honeycomb;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		
		int count = 1;
		int multiplier = 0;
		int start = 1;
		int end = 1;
		
		while (true) {
//			System.out.println();
//			System.out.println("count: " + count);
//			System.out.println("multiplier: " + multiplier);
//			System.out.println("start: " + start);
//			System.out.println("end: " + end);
			if (start <=N && N <= end) {
				break;
			}
			multiplier+=count;
			start = end;
			end = 6 * multiplier;
			
			count++;
		}
		
		System.out.println(count);
	}
}
