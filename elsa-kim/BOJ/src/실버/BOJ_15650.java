package 실버;

import java.util.Scanner;

//N과 M (2) - 조합
public class BOJ_15650 {
	static int n;
	static int m;
	static int[] arr;
	static StringBuffer sb = new StringBuffer();
	
	public static void com(int cnt, int start) {
		if(cnt == m) {
			for(int i=0; i<arr.length; i++) {
				sb.append(arr[i]);
				if(i!=arr.length-1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<=n; i++) {
			arr[cnt] = i;
			com(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		
		com(0, 1);
		System.out.println(sb);
		
	}
}
