package 실버;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		String line;
		for (int i = 0; i < n; i++) {
			line = sc.next();
			for (int j = 0; j < m; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		
		
		int[][] check = new int[n][m];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		queue.add(0);
		check[0][0] = 1;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			if(x-1>=0 && arr[x-1][y]==1 && check[x-1][y]==0) {
				queue.add(x-1);
				queue.add(y);
				check[x-1][y] = check[x][y]+1;
			}
			if(x+1<n && arr[x+1][y]==1 && check[x+1][y]==0) {
				queue.add(x+1);
				queue.add(y);
				check[x+1][y] = check[x][y]+1;
			}
			if(y-1>=0 && arr[x][y-1]==1 && check[x][y-1]==0) {
				queue.add(x);
				queue.add(y-1);
				check[x][y-1] = check[x][y]+1;
			}
			if(y+1<m && arr[x][y+1]==1 && check[x][y+1]==0) {
				queue.add(x);
				queue.add(y+1);
				check[x][y+1] = check[x][y]+1;
			}
		}
		
		System.out.println(check[n-1][m-1]);

	}

}
