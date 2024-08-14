package 실버.N과M;

import java.util.Arrays;
import java.util.Scanner;

//N과 M (8)
public class BOJ_15657 {
	static int n;
	static int m;
	static int[] origin;
	static int[] arr;
	static StringBuffer sb = new StringBuffer();
	
	private static void com(int cnt, int start) {
		if(cnt == m) {
			for(int i=0; i<m; i++) {
				sb.append(arr[i]);
				if(i!=m-1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<n; i++) {
			arr[cnt] = origin[i];
			com(cnt+1, i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		origin = new int[n];
		arr = new int[m];
		for(int i=0; i<n; i++) {
			origin[i] = sc.nextInt();
		}
		Arrays.sort(origin);
		com(0, 0);
		System.out.println(sb);
	}	
}
