package WayToA;

import java.util.Scanner;
import java.lang.Math;

public class BOJ_2477 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int charm = sc.nextInt(); // 참외 수

		int[] direction = new int[6];
		int[] length = new int[6];

		int bigWidth = 0;
		int bigHeight = 0;

		int bigWidthIndex = 0;
		int bigHeightIndex = 0;

		int smallWidth = 0;
		int smallHeight = 0;

		for (int i = 0; i < 6; i++) {
			direction[i] = sc.nextInt();
			length[i] = sc.nextInt();

			if (direction[i] == 3 || direction[i] == 4) { // 진행방향이 남, 북일때
				if (length[i] > bigHeight) { //
					bigHeight = length[i]; // 가장 긴 변의 길이 저장
					bigHeightIndex = i; // 가장 긴 변의 길이를 진행한 인덱스 저장
				}
			} else { // 진행방향이 동, 서일때
				if (length[i] > bigWidth) {
					bigWidth = length[i];
					bigWidthIndex = i;
				}
			}
		}

		// 작은 사각형의 세로 길이 구하기
		if (bigHeightIndex >= 1 && bigHeightIndex <= 4) {
			smallHeight = Math.abs(length[bigHeightIndex + 1] - length[bigHeightIndex - 1]);
		} else if (bigHeightIndex == 5) {
			smallHeight = Math.abs(length[0] - length[4]);
		} else { // bigHeightIndex == 0
			smallHeight = Math.abs(length[1] - length[5]);
		}
		// 작은 사각형의 가로 길이 구하기
		if (bigWidthIndex >= 1 && bigWidthIndex <= 4) {
			smallWidth = Math.abs(length[bigWidthIndex + 1] - length[bigWidthIndex - 1]);
		} else if (bigWidthIndex == 5) {
			smallWidth = Math.abs(length[0] - length[4]);
		} else { // bigWidthIndex == 0
			smallWidth = Math.abs(length[1] - length[5]);
		}

		// 큰 사각형의 넓이
		int bigArea = bigHeight * bigWidth;
		// 작은 사각형 넓이
		int smallArea = smallHeight * smallWidth;
		// 참외밭의 넓이
		int targetArea = bigArea - smallArea;
		// 참외밭에 있는 참외의 개수
		int result = targetArea * charm;
		
		System.out.println(result);
		
	}

}
