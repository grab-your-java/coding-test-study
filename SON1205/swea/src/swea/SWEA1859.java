package swea;

import java.util.Scanner;

public class SWEA1859 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int days = sc.nextInt();
            int[] price = new int[days];
            
            for (int i = 0; i < days; i++) {
                price[i] = sc.nextInt();
            }
            
            // 가장 큰 값 찾아서 그 전까지 차이를 더해 줌
            // 가장 큰 값의 다음 수부터 다시 시작
            int preIdx = 0;
            int maxIdx = 0;
            long sum = 0;
            while (maxIdx < days) {
                for (int i = maxIdx; i < days; i++) {
                	if (price[maxIdx] < price[i]) {
                    	maxIdx = i;
                	}
            	}
                
                for (int i = preIdx; i < maxIdx; i++) {
                    sum += price[maxIdx] - price[i];
                }
				
            	preIdx = ++maxIdx;
            }
            
            System.out.println("#" + test_case + " " + sum);
            
		}
	}
}
