package SWEA_2112_보호필름;

import java.util.Scanner;

public class Solution {
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int D = sc.nextInt();
			int W = sc.nextInt();
			int K = sc.nextInt();
			
			result = K;
			
			int[][] map = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			subset(map, 0, 0, K);
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static void subset(int[][] map, int idx, int cnt, int K) {
		if (checkingFilm(map, K)) {
			if (result > cnt) {
				result = cnt;
			}
			return;
		}
		
		if (idx == map.length) {
			return;
		}
		
		subset(map, idx + 1, cnt, K);
		
		int[] tmp = new int[map[0].length];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = map[idx][i];
		}
		
		for (int i = 0; i < tmp.length; i++) {
			map[idx][i] = 0;
		}
		
		subset(map, idx + 1, cnt + 1, K);
		
		for (int i = 0; i < tmp.length; i++) {
			map[idx][i] = 1;
		}
		
		subset(map, idx + 1, cnt + 1, K);
		
		for (int i = 0; i < tmp.length; i++) {
			map[idx][i] = tmp[i];
		}
	}
	
	static boolean checkingFilm(int[][] map, int K) {
		for (int i = 0; i < map[0].length; i++) {
			int cnt = 1;
			boolean isValid = false;
			
			for(int r = 1; r < map.length; r++) {
				if(map[r][i] == map[r - 1][i]) cnt++; //이전과 나와 같다면 카운트
				else cnt = 1;
				
				if(cnt >= K) {
					isValid = true;
					break;
				}
			}
			
			if (!isValid) {
				return false;
			}
		}
		return true;
	}
}