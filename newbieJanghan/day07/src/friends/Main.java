package friends;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		int[] friends = new int[N];
		// first baller
		friends[0]++;
		int ballIdx = 0;
		int maxBallCount = 1;
		
		int throwCount = 0;
		while (maxBallCount < M) {
			int currentBallerCount = friends[ballIdx];

			// calculate ballIdx
			// if odd, clockwise L else -L
			if (currentBallerCount % 2 == 1) {
				ballIdx += L;
			} else {
				ballIdx -= L;
			}
			// correct index for circular array
			if (ballIdx >= 0) {
				ballIdx %= N;
			} else {
				ballIdx = N - ((-1 * ballIdx) % N);
			}
			
			friends[ballIdx]++;
			throwCount++;
			maxBallCount = Math.max(maxBallCount, friends[ballIdx]);
		}

		System.out.println(throwCount);
	}
}
