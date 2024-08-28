package swea;

import java.util.Scanner;

class SWEA1210 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            sc.nextInt();
			int[][] arr = new int[100][100];
            
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            int direction = 0;  // 좌 -1, 위 0, 우 1
            int rowCnt = 1;
            int column = -1;
            
            while (rowCnt < 100) {
                	if (rowCnt == 1) {
                        for (int i = 0; i < 100; i++) {
                			if (arr[99][i] == 2) {
                   			column = i;
                    		rowCnt++;
                    		break;
                			}
            			}
                    }
                
                    if (direction != 1 && column - 1 >= 0 && arr[100 - rowCnt][column - 1] == 1) {
                    	column -= 1;
                        direction = -1;
                	} else if (direction != -1 && column + 1 < 100 && arr[100 - rowCnt][column + 1] == 1) {
                    	column += 1;
                        direction = 1;
                	} else {
                    	rowCnt++;
                        direction = 0;
                	}
            }
            
            System.out.println("#" + test_case + " " + column); 
		}
	}
}
