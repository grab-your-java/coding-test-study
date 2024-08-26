package Joker;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[1000001];
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			numbers[sc.nextInt()]++;
		}
		int jokerCnt = numbers[0];
		
		int max = jokerCnt; // 오직 조커만으로 스트레이트를 이룬 경우를 초기값으로 설정
		int remainJoker = 0;
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] == 0) continue;

			int currentJokerCnt = jokerCnt; // 각 스트레이트 계산마다 조커 수 복원
			int straightCnt = 1;

			for (int j = i + 1; j < numbers.length && currentJokerCnt >= 0; j++) {
				if (numbers[j] == 0) {
					if (currentJokerCnt > 0) {
						currentJokerCnt--; // 조커를 사용해 빈 공간을 채움
					} else {
						break;
					}
				}
				straightCnt++;
			}
			max = Math.max(max, straightCnt);
			remainJoker = currentJokerCnt;
		}
		max += remainJoker; // 조커가 남아있다면 더해서 최대 스트레이트로 만들어주기

		System.out.println(max);
	}
}
