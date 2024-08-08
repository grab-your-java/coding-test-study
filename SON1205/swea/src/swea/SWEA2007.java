package swea;

import java.util.Scanner;

public class SWEA2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {			
			String[] input = sc.next().split("");
			
			int idx = 1;
			
			while (idx < 11) {
				boolean findMadi = true;
				
				for (int j = 0; j < input.length / idx * idx; j++) {
					if (!input[j % idx].equals(input[j])) {
						findMadi = false;
						break;
					}
				}
				
				if (findMadi) {
					break;
				}
				
				idx++;
			}
			
			System.out.println("#" + i + " " + idx);
		}
	}
}
