package swea;

import java.util.Scanner;

public class SWEA1493 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            int idxA = 1;
            int endNumA = 1;
            
            while (A > endNumA) {
            	endNumA += ++idxA;
            }
            
            int rA = endNumA - A + 1;
            int cA = idxA - rA + 1;
            
            int idxB = 1;
            int endNumB = 1;
            
            while (B > endNumB) {
            	endNumB += ++idxB;
            }
            
            int rB = endNumB - B + 1;
            int cB = idxB - rB + 1;
            
            int rC = rA + rB;
            int cC = cA + cB;
            
            int endNumC = 1;
            for (int i = 2; i < rC + cC; i++) {
            	endNumC += i;
            }
            
            System.out.println("#" + test_case + " " + (endNumC - rC + 1));
		}
		
	}
}
