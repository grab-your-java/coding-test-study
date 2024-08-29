package swea;

import java.util.Scanner;

public class SWEA1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] arr = new int[9][9];
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			if (checkingSero(arr) && checkingGaro(arr) && checkingBox(arr)) {
				System.out.println("#" + test_case + " " + 1);
			} else {
				System.out.println("#" + test_case + " " + 0);
			}
		}
		
	}
	
	static boolean checkingGaro(int[][] arr) {
		int[] checking = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				checking[arr[i][j]]++;
			}
			
			for (int j = 1; j < 10; j++) {
				if (checking[j] != i + 1) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static boolean checkingSero(int[][] arr) {
		int[] checking = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				checking[arr[j][i]]++;
			}
			
			for (int j = 1; j < 10; j++) {
				if (checking[j] != i + 1) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static boolean checkingBox(int[][] arr) {
		int[] checking = new int[10];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				for (int p = 0; p < 3; p++) {
					for (int q = 0; q < 3; q++) {
						checking[arr[3 * i + p][3 * j + q]]++;
					}
				}
				
				for (int p = 1; p < 10; p++) {
					if (checking[p] != 3 * i + j + 1) {
						return false;
					}
				}	
			}
		}
		
		return true;
	}
}