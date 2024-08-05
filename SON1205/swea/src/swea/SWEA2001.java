package swea;

import java.util.Scanner;

public class SWEA2001 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int M = sc.nextInt();
            
           	int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            int max = 0;
            int[][] sums = new int[N + 1][N + 1];
            
            for (int i = 1; i < N + 1; i++) {
            	for (int j = 1; j < N + 1; j++) {
            		sums[i][j] = arr[i - 1][j - 1] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
            	}
            }
            
            for (int i = M; i < N + 1; i += 1) {
            	for (int j = M; j < N + 1; j += 1) {
            		int tmp = sums[i][j] - sums[i - M][j] - sums[i][j - M] + sums[i - M][j - M];
            		if (tmp > max) {
            			max = tmp;
            		}
            	}
            }
                    
            System.out.println("#" + test_case + " " + max);
		}
	}
}
