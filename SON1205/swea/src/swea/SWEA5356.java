package swea;

import java.util.Scanner;

public class SWEA5356 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int TC = 1; TC <= T; TC++) {
			String[] inputs = new String[5];
			
			for (int i = 0; i < 5; i++) {
				inputs[i] = sc.next();
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 5; j++) {
					if (inputs[j].length() <= i) {
						continue;
					}
						
					sb.append(inputs[j].charAt(i));
				}
			}
			
			System.out.println("#" + TC + " " + sb.toString());
		}
	}

}
