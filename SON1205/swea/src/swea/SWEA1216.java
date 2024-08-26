package swea;

import java.util.Scanner;

/*
 * printf가 println보다 오래 걸림
 */
public class SWEA1216 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int n = sc.nextInt();
            
            char[][] arr = new char[100][];
            
            for (int i = 0; i < 100; i++) {
                arr[i] = sc.next().toCharArray();
            }
            
            int N = 100;
            boolean flag = true;
            
            while (N > 0 && flag) {
            	if (N == 1) {
         			System.out.println("#" + test_case + " " + 1);
     				break;
         		}
            	
            	 for (int i = 0; i <= 100 - N; i++) {
            		 if (!flag) {
            			 break;
            		 }
                 	for (int j = 0; j < 100; j++) {
                 		boolean palinX = true;
                    	boolean palinY = true;
                 		
                 		char[] arr1 = new char[N];
                 		char[] arr2 = new char[N];

                         for (int p = 0; p < N; p++) {
                             arr1[p] = arr[j][i + p];
                             arr2[p] = arr[i + p][j];
                         }
                 		
                        
             			for (int p = 0; p < N / 2; p++) {
             				if (!(arr1[p] == arr1[arr1.length - 1 - p])) {
             					palinX = false;
             					break;
             				}
             			}
             			
             			for (int p = 0; p < N / 2; p++) {
             				if (!(arr2[p] == arr2[arr2.length - 1 - p])) {
             					palinY = false;
             					break;
             				}
             			}
             			
             			if (palinX || palinY) {
             				System.out.println("#" + n + " " + N);
//             				System.out.printf("#%d %d%n", n, N);
             				flag = false;
             				break;
             			}
                 	}
                 }
            	 
            	 N--;
            }
		}
	}
}