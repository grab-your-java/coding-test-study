package swea_6808_규영이와_인영이의_카드게임;

import java.io.*;
import java.util.*;

class Solution1 {
	static int[] myCards = new int[9];
	static int[] opCards = new int[9];
	static int[] f = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 }; // 9!
	static int[][] b = new int[121][1 << 9]; // 121*512

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(' ');
			
			boolean[] picked = new boolean[19];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				myCards[i] = Integer.parseInt(st.nextToken());
				picked[myCards[i]] = true;
			}
			
			for (int i = 1, j = 0; i <= 18; i++) {
				if (!picked[i]) {
					opCards[j++] = i;
				}
			}
					
			for (int i = 0; i < 121; i++) {
				Arrays.fill(b[i], -1);
			}
			
			Arrays.sort(myCards);
			dfs(0, 9, 0, 0);
			
			sb.append(b[0][0]).append(' ').append(f[9] - b[0][0]).append('\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
	}

	private static int dfs(int visited, int lev, int scoreA, int scoreB) {
		if (b[scoreA][visited] != -1) {
			return b[scoreA][visited];
		}
			
		if (scoreA > 85) {
			return b[scoreA][visited] = f[lev];
		}
			
		else if (scoreB > 85) {
			return b[scoreA][visited] = 0;
		}
			
		int ret = 0;
		for (int next = 8; next > -1; next--) {
			if ((visited & (1 << next)) == 0) {
				int plus = myCards[lev - 1] + opCards[next];
				if (myCards[lev - 1] > opCards[next]) {
					ret += dfs(visited | (1 << next), lev - 1, scoreA + plus, scoreB);
				}
					
				else if (myCards[lev - 1] < opCards[next]) {
					ret += dfs(visited | (1 << next), lev - 1, scoreA, scoreB + plus);
				}
					
			}
		}
		return b[scoreA][visited] = ret;
	}
}