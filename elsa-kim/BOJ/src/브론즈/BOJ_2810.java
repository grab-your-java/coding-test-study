package 브론즈;

import java.util.Scanner;

public class BOJ_2810 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		String[] arr = sc.next().split("");
		
		int leng = cnt+1;
		for(int i=0; i<cnt; i++) {
			if(arr[i].equals("S")){
				leng++;
			}else if(i+1<arr.length&&arr[i].equals("L") && arr[i+1].equals("L")) {
				leng++;
				arr[i+1] = "X";
			}
		}
		int[] newArr = new int[leng];
		newArr[0] = 1;
		for(int i=0, idx=1; i<cnt; i++) {
			if(arr[i].equals("S")){
				// 0: 사람, 1: 음료
				newArr[idx++] = 0;
				newArr[idx++] = 1;
			}else if(arr[i].equals("L") && arr[i+1].equals("X")){
				newArr[idx++] = 0;				
				newArr[idx++] = 0;				
				newArr[idx++] = 1;				
			}
		}
		
		for(int i=0; i<leng; i++) {
			if(newArr[i]!=0) continue;
			if((i-1)>=0 && newArr[i-1]==1) {
				newArr[i-1]=2;
				continue;
			}else if(i+1<newArr.length&&newArr[i+1]==1) {
				newArr[i+1]=2;
				continue;
			}else {
				cnt--;
			}
		}
		System.out.println(cnt);
	}
}
