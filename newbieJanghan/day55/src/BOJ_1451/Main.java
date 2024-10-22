package BOJ_1451;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[][] square = new int[N][M];
		for (int i = 0; i < N; i++) {
			square[i] = Arrays.stream(sc.next().split("")).mapToInt(Integer::parseInt).toArray();
		}

		long answer = 0;

		for (int c1 = 1; c1 < M; c1++) {
			// two vertical cut
			for (int c2 = c1 + 1; c2 < M; c2++) {
				long first = 0, second = 0, third = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if (c < c1) {
							first += square[r][c];
						} else if (c < c2) {
							second += square[r][c];
						} else {
							third += square[r][c];
						}
					}
				}
				
				answer = Math.max(answer, first * second * third);
			}

			// horizontal cut
			for (int r1 = 1; r1 < N; r1++) {
				// case 1: cross left
				long first = 0, second = 0, third = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if (c < c1) {
							if (r < r1) {
								first += square[r][c];
							} else {
								second += square[r][c];
							}
						} else {
							third += square[r][c];
						}

					}
				}
				
				answer = Math.max(answer, first * second * third);

				// case 2: cross right
				first = 0;
				second = 0;
				third = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if (c < c1) {
							first += square[r][c];

						} else {
							if (r < r1) {
								second += square[r][c];
							} else {
								third += square[r][c];
							}
						}

					}
				}
				
				answer = Math.max(answer, first * second * third);
			}
		}

		for (int r1 = 1; r1 < N; r1++) {
			// two horizontal cut
			for (int r2 = r1 + 1; r2 < N; r2++) {
				long first = 0, second = 0, third = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if (r < r1) {
							first += square[r][c];
						} else if (r < r2) {
							second += square[r][c];
						} else {
							third += square[r][c];
						}
					}
				}
				
				answer = Math.max(answer, first * second * third);
			}

			// vertical cut
			for (int c1 = 1; c1 < M; c1++) {
				// case 1: cross left
				long first = 0, second = 0, third = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if (r < r1) {
							if (c < c1) {
								first += square[r][c];
							} else {
								second += square[r][c];
							}
						} else {
							third += square[r][c];
						}
					}
				}
				
				answer = Math.max(answer, first * second * third);

				// case 2: cross right
				first = 0;
				second = 0;
				third = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if (r < r1) {
							first += square[r][c];
						} else {
							if (c < c1) {
								second += square[r][c];
							} else {
								third += square[r][c];
							}
						}
					}
				}
				
				answer = Math.max(answer, first * second * third);
			}
		}
		
		System.out.println(answer);
	}
}
