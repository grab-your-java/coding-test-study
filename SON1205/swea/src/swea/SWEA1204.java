package swea;

import java.util.Scanner;

public class SWEA1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sc.nextInt();
            
            int[] arr = new int[101];
            
            for (int i = 0; i < 1000; i++) {
                arr[sc.nextInt()]++;
            }
            int maxCount = arr[0];
            int max = 0;
            for (int i = 1; i < 101; i++) {
            	if (maxCount <= arr[i]) {
                    maxCount = arr[i];
                    max = i;
                }
            }
            
			System.out.println("#" + test_case + " " + max);
		}
	}
}
