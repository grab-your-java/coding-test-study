package SWEA_4012_요리사;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int[][] food;
	static int N;
	static int M;
	static boolean[] visited;
	static List<Integer> output;
	
	static List<Long> result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			M = N / 2;
			visited = new boolean[N];
			output = new ArrayList<>();
			result = new ArrayList<>();
			
			food = new int[N][N];
			
			for (int i = 0 ; i < N; i++) {
				for (int j = 0; j < N; j++) {
					food[i][j] = sc.nextInt();
				}
			}
			
			chooseIngredient(0, 0);
			
			long min = result.get(0);
			
			for (int i = 1; i < result.size(); i++) {
				if (min > result.get(i)) {
					min = result.get(i);
				}
			}
			
			System.out.println("#" + tc + " " + min);
		}
	}
	
	static void chooseIngredient(int start, int depth) {
		if (depth == M) {
			result.add(compareAB(output));
			return;
		}
		
		for (int i = start; i < food.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output.add(i);
				chooseIngredient(i + 1, depth + 1);
				output.remove(depth);
				visited[i] = false;
			}
		}
	}
	
	static long compareAB(List<Integer> output) {
		long sumA = 0;
		long sumB = 0;
		
		for (int i = 0; i < food.length - 1; i++) {
			for (int j = i + 1; j < food.length; j++) {
				if (output.contains(i) && output.contains(j)) {
					sumA += food[i][j] + food[j][i];
				}
				
				if (!output.contains(i) && !output.contains(j)) {
					sumB += food[i][j] + food[j][i];
				}
			}
		}
		
		return Math.abs(sumA - sumB);
	}
}