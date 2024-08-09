package swea.D2;

import java.util.Scanner;

public class SWEA_1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int[] arr = new int[10];
            for(int i=0; i<arr.length; i++){
            	arr[i] = sc.nextInt();
            }
            int maxIdx = 0;
            int minIdx = 0;
            for(int i=0; i<arr.length; i++){
            	if(arr[i] > arr[maxIdx]) maxIdx = i;
                if(arr[i] < arr[minIdx]) minIdx = i;
            }
            int sum = 0;
             for(int i=0; i<arr.length; i++){
            	if(i==maxIdx || i==minIdx) continue;
                 sum+=arr[i];
               
            }
            
            System.out.println("#"+test_case+" "+Math.round(sum/8.0));
		}
	}

}
