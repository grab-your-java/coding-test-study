package swea;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SWEA4698 {
	static Set<Integer> tenes = new HashSet<>();
	
	static {
		tenes.add(2);
		tenes.add(3);
		tenes.add(5);
		tenes.add(7);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int T = 1; T <= TC; T++) {
			int D = sc.nextInt();
			
			int start = sc.nextInt();
			
			int end = sc.nextInt();
			
			int cnt = 0;
			
			for (int i = start; i <= end; i++) {
				if (i == 1 || i == 2) {
					continue;
				}
				
				Iterator<Integer> iter = tenes.iterator();
				
				boolean isValid = true;
				
				while (iter.hasNext()) {
					int x = iter.next();
					if (i % x == 0) {
						isValid = false;
						break;
					}
				}
				
				if (isValid) {
					int number = i;
					tenes.add(number);
					
					while (number > 0) {
						if (number % 10 == D) {
							cnt++;
							break;
						}
						
						number /= 10;
					}
				}
			}
			
			System.out.println("#" + T + " " + cnt);
		}
	}
}
