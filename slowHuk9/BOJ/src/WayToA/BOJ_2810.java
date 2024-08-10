package WayToA;

import java.util.Scanner;

public class BOJ_2810 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 좌석의 수
		String s = sc.next();
		int[] arr = new int[s.length() + 1];
		

		int index = 0;
		arr[0] = 1; // 좌석 맨 왼쪽 끝은 무조건 컵홀더가 있음
		arr[arr.length - 1] = 1; // 좌석 맨 오른쪽 끝은 무조건 컵홀더가 있음.
		int Lcnt = 0;
		int cupHolder = 0;
		
		for (int i = 1; i < arr.length; i++) {
			if (s.charAt(index) == 'S') { // S좌석의 오른쪽팔걸이에는 컵홀더가 무조건 있다.
				index++;
				arr[i] = 1;
			} else { // 좌석이 L 일때
				if (Lcnt % 2 == 1) { // 좌석이 L이고, 커플좌석 사이에는 컵홀더가 없고 커플좌석이 끝나야 컵홀더가 있다.
					index++;
					arr[i] = 1;
					Lcnt ++;
				}
				else if(Lcnt % 2 == 0) {
					index ++;
					arr[i] = 0;
					Lcnt++;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 1) {
				cupHolder ++;
			}
		}
		if (cupHolder >= n ) {
			System.out.println(n);
		}
		else {
			System.out.println(cupHolder);
		}
		
	}
}
