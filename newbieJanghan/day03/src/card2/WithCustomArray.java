package card2;

import java.util.Scanner;

public class WithCustomArray {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] list = new int[2*N];
		int top = 0;
		int entry = N;
		
		// Mapping
		for (int i=1; i<=N; i++) {
			list[i-1]=i;
		}
		
		// poll or add after poll
		boolean pollOnly = true;
		while (top != entry-1) {
			int polled = list[top];
			list[top] = 0;
			top++;
			
			if (pollOnly) {
				pollOnly = false;
			} else {
				list[entry] = polled;
				entry++;
				pollOnly = true;
			}
		}
		
		System.out.println(list[top]);
	}
	
}
