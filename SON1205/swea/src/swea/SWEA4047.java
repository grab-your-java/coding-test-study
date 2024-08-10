package swea;

import java.util.Scanner;

public class SWEA4047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int[][] deck = new int[4][14];
			
			String[] input = sc.next().split("");
			
			boolean isValid = true;
			
			for (int p = 0; p < input.length; p += 3) {
				if(!isValid) {
					break;
				}
				
				switch (input[p]) {
				case "S":
					if (input[p + 1].equals("0")) {
						int idx = Integer.parseInt(input[p + 2]);
						if (deck[0][idx] == 0) {
							deck[0][idx]++;
						} else {
							System.out.println("#" + i + " ERROR");
							isValid = false;
						}
					} else {
						int idx = Integer.parseInt(input[p + 2]) + 10;
						if (deck[0][idx] == 0) {
							deck[0][idx]++;
						} else {
							System.out.println("#" + i + " ERROR");
							isValid = false;
						}
					}
					break;
				case "D":
					if (input[p + 1].equals("0")) {
						int idx = Integer.parseInt(input[p + 2]);
						if (deck[1][idx] == 0) {
							deck[1][idx]++;
						} else {
							System.out.println("#" + i + " ERROR");
							isValid = false;
						}
					} else {
						int idx = Integer.parseInt(input[p + 2]) + 10;
						if (deck[1][idx] == 0) {
							deck[1][idx]++;
						} else {
							System.out.println("#" + i + " ERROR");
							isValid = false;
						}
					}
					break;
				case "H":
					if (input[p + 1].equals("0")) {
						int idx = Integer.parseInt(input[p + 2]);
						if (deck[2][idx] == 0) {
							deck[2][idx]++;
						} else {
							System.out.println("#" + i + " ERROR");
							isValid = false;
						}
					} else {
						int idx = Integer.parseInt(input[p + 2]) + 10;
						if (deck[2][idx] == 0) {
							deck[2][idx]++;
						} else {
							System.out.println("#" + i + " ERROR");
							isValid = false;
						}
					}
					break;
				default:
					if (input[p + 1].equals("0")) {
						int idx = Integer.parseInt(input[p + 2]);
						if (deck[3][idx] == 0) {
							deck[3][idx]++;
						} else {
							System.out.println("#" + i + " ERROR");
							isValid = false;
						}
					} else {
						int idx = Integer.parseInt(input[p + 2]) + 10;
						if (deck[3][idx] == 0) {
							deck[3][idx]++;
						} else {
							System.out.println("#" + i + " ERROR");
							isValid = false;
						}
					}
					break;
				}
			}
			
			if (isValid) {
				System.out.print("#" + i + " ");
				for (int q = 0; q < 4; q++) {
					int cnt = 13;
					for (int p = 1; p < 14; p++) {
						cnt -= deck[q][p];
					}
					System.out.print(cnt + " ");
				}
				System.out.println();
			}
			
		}
	}
}
