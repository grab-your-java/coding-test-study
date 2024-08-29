package swea;

import java.util.Scanner;

public class SWEA1220 {
	 public static void main(String args[]) throws Exception
	    {
	        Scanner sc = new Scanner(System.in);
	 
	        for(int test_case = 1; test_case <= 10; test_case++)
	        {
	        	// 주어진 조건 입력 받기
	            sc.nextInt();
	            int[][] arr = new int[100][100];
	             
	            for (int i = 0; i < 100; i++) {
	                for (int j = 0; j < 100; j++) {
	                    arr[i][j] = sc.nextInt();
	                }
	            }
	             
	            //풀이 시작
	            int cnt = 0;
	            
	            //각 열을 위에서부터 탐색
	            //N극일 때, 또 N극을 만나면 그 다음으로 넘어가기
	            //하지만 S극을 만나면 counting 해주고 그 다음으로 넘어가기
	            for (int i = 0; i < 100; i++) {
	                for (int j = 0; j < 100; j++) {
	                    if (arr[j][i] == 1) {
	                        for (int k = j + 1; k < 100; k++) {
	                            if (arr[k][i] == 1) {
	                                break;
	                            }
	                            if (arr[k][i] == 2) {
	                                cnt++;
	                                break;
	                            }
	                        }
	                    }
	                }
	            }
	             
	            System.out.println("#" + test_case + " " + cnt);
	        }
	    }
}
