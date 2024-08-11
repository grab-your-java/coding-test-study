package SWEA_1249_보급로;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int[][] TIMES;
	static int[][] VISITED;
	static int[] dr = { -1 , 0, 1, 0};
	static int[] dc = { 0, 1, 0, -1};

 	static class Obstacle {
		int r, c, time;
		Obstacle(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Obstacle{" +
					"r=" + r +
					", c=" + c +
					", time=" + time +
					'}';
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();

			TIMES = new int[N][N];
			VISITED = new int[N][N];
			for (int r=0; r<N; r++) {
				char[] numChars = sc.next().toCharArray();
				for (int c=0; c<N; c++) {
					TIMES[r][c] = Character.getNumericValue(numChars[c]);
					VISITED[r][c] = Integer.MAX_VALUE;
				}
			}

			TIMES[0][0] = 0;

			dijkstra();
			System.out.println("#" + t + " " + VISITED[N-1][N-1]);
		}

	}

	static void dijkstra() {
		PriorityQueue<Obstacle> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
		pq.add(new Obstacle(0, 0, 0));

		while(!pq.isEmpty()) {
			Obstacle cur = pq.poll();
			if (cur.time > VISITED[cur.r][cur.c]) {
				continue;
			}

			for (int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (nr <0 || nr >= TIMES.length || nc < 0 || nc >= TIMES.length) {
					continue;
				}
				int calculatedTime = cur.time + TIMES[nr][nc];
				if (calculatedTime < VISITED[nr][nc] ) {
					pq.add(new Obstacle(nr, nc, calculatedTime));
					VISITED[nr][nc] = calculatedTime;
				}

			}

		}
	}

}
