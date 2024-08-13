package 실버;

import java.util.Scanner;

public class BOJ_15652 {
	static int n;
	static int m;
	static int[] arr;
	static StringBuffer sb = new StringBuffer();
	
	public static void per(int cnt, int start) {
		if(cnt == m) {
			for(int i=0; i<m; i++) {
				sb.append(arr[i]);
				if(i != m-1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<=n; i++) {
			arr[cnt] = i;
			per(cnt+1, i);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		
		per(0, 1);
		System.out.println(sb);
	}
}
