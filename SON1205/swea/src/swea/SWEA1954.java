package swea;

import java.util.Scanner;

public class SWEA1954 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int x = -1;
            int y = 0;
            int direction = 1;
            int count = 1;
            
            for (int i = 2 * n - 1; i > 0; i -= 2) {
                for (int j = 0; j < i; j++) {
                    if (j < i / 2 + 1) {
                        x += direction;
                    } else {
                        y += direction;
                    }
                    
                    arr[y][x] = count++;
                }
                direction = -direction;
            }
            
            System.out.println("#" + test_case);
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
		}
	}
}
