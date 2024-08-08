package swea;

import java.util.Scanner;

public class SWEA1289 {
	public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int cnt = 0;
            
            //String으로 입력받아 숫자 배열로 변환
            String[] arr = sc.next().split("");
            int[] bits = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                bits[i] = Integer.parseInt(arr[i]);
            }
            
            // 초기 상태가 0이므로 1인 경우 cnt 증가
            if (bits[0] == 1) {
                cnt++;
            }
            
            // 다음 숫자와 다르면 cnt 증가
            for (int i = 0; i < bits.length - 1; i++) {
                if (bits[i + 1] - bits[i] != 0) {
                    cnt++;
                }
            }
             
            System.out.println("#" + test_case + " " + cnt);
        }
    }
}
