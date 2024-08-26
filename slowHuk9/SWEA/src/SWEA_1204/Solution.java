package SWEA_1204;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int student = 1000;
		for (int test_case = 1; test_case <= T; test_case++) {
			sc.next();
			int[] scoreList = new int[101]; // 점수가 나온 횟수를 담을 배열
			for (int i = 0; i < student; i++) {
				int score = sc.nextInt();
				scoreList[score]++;
			}
			int[] scoreList2 = Arrays.copyOf(scoreList, scoreList.length);
			Arrays.sort(scoreList);
			int target = scoreList[scoreList.length - 1]; // 최빈값의 횟수
			int max = 0;
			for (int i = 0; i < scoreList2.length; i++) {
				if (scoreList2[i] == target) {
					max = i;
				}
			}

			System.out.println("#" + test_case + " " + max);

		}
	}

}
