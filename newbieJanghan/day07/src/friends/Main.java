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

			// ballIdx 계산
			if (currentBallerCount % 2 == 1) {
				// 홀수. 시계방향으로 L만큼
				ballIdx += L;
			} else {
				// 짝수. 반시계방향으로 L만큼
				ballIdx -= L;
			}
			// ballIdx 보정
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
