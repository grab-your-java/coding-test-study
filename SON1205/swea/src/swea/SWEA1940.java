package swea;

import java.util.Scanner;

public class SWEA1940 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int sec = sc.nextInt();
            int speed = 0;
            int total = 0;
            
            for (int i = 0; i < sec; i++) {
                int input = sc.nextInt();
                
                if (input == 1) {
                    speed += sc.nextInt();
                    total += speed;
                }
                
                if (input == 2) {
                    int desc = sc.nextInt();
                    if (speed < desc) {
                        speed = 0;
                    } else {
                        speed -= desc;
                    }
                    
                    total += speed;
                }
                
                if (input == 0) {
                    total += speed;
                }
            }
            
            System.out.println("#" + test_case + " " + total);
		}
	}
}
