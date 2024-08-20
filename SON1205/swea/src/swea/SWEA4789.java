package swea;

import java.util.Scanner;

public class SWEA4789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			String[] input = sc.next().split("");
			int[] people = new int[input.length];
			
			for (int k = 0; k < input.length; k++) {
				people[k] = Integer.parseInt(input[k]);
			}
			
			int clap = people[0];
			int needs = 0;
			for (int k = 1; k < people.length; k++) {
				if (clap >= k) {
					clap += people[k];
				} else {
					needs += k - clap;
					clap = k + people[k];
				}
			}
			
			System.out.println("#" + i + " " + needs);
		}
	}
}
