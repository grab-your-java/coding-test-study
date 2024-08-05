package swea;

import java.util.Scanner;

public class SWEA1984 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[] arr = new int[10];
            
            for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
            }
            
            int max = arr[0];
            int min = arr[0];
            int total = arr[0];
            for (int i = 1; i < 10; i++) {
                total += arr[i];
                if (max < arr[i]) {
                    max = arr[i];
                }
                
                if (min > arr[i]) {
                    min = arr[i];
                }
            }
            
            total -= max + min;
            
            System.out.println("#" + test_case + " " + Math.round((double) total / 8));
		}
	}
}
