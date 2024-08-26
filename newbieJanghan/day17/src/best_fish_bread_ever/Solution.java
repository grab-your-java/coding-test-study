package best_fish_bread_ever;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Case: for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] guestPerSec = new int[11112];
			while (N-- > 0) {
				int second = sc.nextInt();
				guestPerSec[second]++;	
			}
			
			int visited = 0;
			for (int sec = 0; sec<=11111; sec++) {
				int guest = guestPerSec[sec]; 
				if (guest == 0) {
					continue;
				}
				
				int baked = sec / M * K - visited;
				if (baked >= guest) {
					visited += guest;
				} else if (baked < guest) {
					System.out.println("#" + t + " Impossible");
					continue Case;
				}
			}
			
			System.out.println("#" + t + " Possible");

		}
	}

}
