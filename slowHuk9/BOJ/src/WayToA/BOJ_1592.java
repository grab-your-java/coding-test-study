package WayToA;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1592 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 친구 수
        int M = sc.nextInt(); // 공 받는 목표 횟수
        int L = sc.nextInt(); // 건너뛰는 차례

        int[] arr = new int[N];
        int result = 0; // 공을 던진 횟수
        int index = 0 ; // 현재 공 갖고 있는 친구의 인덱스
        
        arr[0] = 1;
        
        while(arr[index] < M) {
        	if(arr[index] % 2 == 1) { // 홀수다
        		index = (index + L) % N; 
        	}else { // 짝수다
        		index = (index - L + N) % N ;
        	}
        	arr[index] += 1;
        	result++;
        	
        }
        System.out.println(result);
        sc.close();
    }

}
