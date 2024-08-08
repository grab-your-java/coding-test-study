package 백준;

import java.util.Scanner;

public class 백준_2750_삽입정렬구현 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다
		 * 작거나 같은 정수이다. 수는 중복되지 않는다.
		 */

		// 1. 스캐너를 열어서 수의 개수를 입력받는다.
		// 2. 받은 개수 만큼 int[] arr 생성
		// 3. for 문으로 arr[i] 에 스캐너값 저장하기
		// 4. 조건이 있다면 Math.abs가 1000보다 작거나 같다.?
		// 5. 다시 배열 for문 돌면서 작은 값을 앞으로 보내는 교환 형식으로 실행

		// 1. 스캐너를 열어 수의 개수를 받는다.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 2. 받은 개수 만큼 int[] arr 생성
		int[] arr = new int[n];

		// 3. for 문으로 arr[i] 에 스캐너값 저장하기
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		//배열의 두번째 요소부터 시작
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
			sc.close();
	}

}
