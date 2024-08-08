package 브론즈;

import java.util.Scanner;

public class BOJ_3985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int cnt = sc.nextInt();
		// [i][0]부터 [i][1] 조각 까지 원함, 실제가진 수 : [i][2]
		int[][] arr = new int[cnt][3];
		for(int i=0; i<cnt; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int[] cake = new int[size];
		for(int i=0; i<cnt; i++) {
			for(int j=arr[i][0]-1; j<arr[i][1]; j++) {
				if(cake[j]==0) cake[j] = i+1;
			}
		}
		int ans1 = 0;
		for(int i=0; i<cnt; i++) {
			if(arr[ans1][1]-arr[ans1][0]<arr[i][1]-arr[i][0])ans1=i;
		}
		ans1++;
		for(int i=0; i<size; i++) {
			if(cake[i]!=0) arr[cake[i]-1][2]++;
		}
		int ans2 = 0;
		for(int i=0; i<cnt; i++) {
			if(arr[ans2][2]<arr[i][2])ans2 = i;
		}
		ans2++;
		System.out.println(ans1);
		System.out.println(ans2);
		
	}
}
