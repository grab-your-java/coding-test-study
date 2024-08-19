package 실버.N과M;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// N과 M (9)
public class BOJ_15663 {
	static int n;
	static int m;
	static int[] origin;
	static int[] arr;
	static StringBuffer sb = new StringBuffer();
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		origin = new int[n];
		arr = new int[m];
		check = new boolean[n];
		for (int i = 0; i < n; i++) {
			origin[i] = sc.nextInt();
		}
		Arrays.sort(origin);
		per(0);
		System.out.println(sb);
	}

	private static void per(int cnt) {
		
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
		List<Integer> dupCheck = new ArrayList<>();
		for(int i=0; i<n; i++) {
			if(dupCheck.contains(origin[i])) continue;
			if(!check[i]) {
				dupCheck.add(origin[i]);
				check[i]=true;
				arr[cnt] = origin[i];
				per(cnt+1);
				check[i]=false;
			}
		}
	}

}
