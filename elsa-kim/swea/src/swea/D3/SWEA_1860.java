package swea.D3;

import java.util.Scanner;

public class SWEA_1860 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 사람수
			int pCnt = sc.nextInt();
			// 붕어빵 굽는 시간
			int time = sc.nextInt();
			// 굽는 시간 동안 만들어지는 빵 수
			int cnt = sc.nextInt();
			// 사람 입력 순서대로 배열만들기
			int[] arr = new int[pCnt];
			// 가장 오래걸리는 사람 시간 저장
			int max = 0;
			// 사람 시간 입력값 받고 최대값 찾기
			for (int i = 0; i < pCnt; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] > max)
					max = arr[i];
			}
			// 사람 시간을 인덱스로 하는 배열 => 2초 걸리는 사람 세명이면 인덱스 2에 값 3
			int[] cntArr = new int[max + 1];
			for (int i = 0; i < pCnt; i++) {
				cntArr[arr[i]]++;
			}
			// 만들어진 빵 개수
			int ppang = 0;
			// 결과 성공이냐 실패냐
			boolean isPossible = true;
			
			for (int i = 0; i < cntArr.length; i++) {
				// 현재 시간(포문 도는 i)가 입력받은 시간으로 나눠지면
				if (i != 0 && i % time == 0)
					// 빵 개수 플러스
					ppang += cnt;
				// 사람 배열에 사람 없으면 넘기고
				if (cntArr[i] == 0)
					continue;
				// 있으면 빵개수에서 마이너스
				ppang -= cntArr[i];
				// 빵 개수 -되면 false
				if (ppang < 0)
					isPossible = false;
			}
			System.out.println("#" + tc + " " + (isPossible ? "Possible" : "Impossible"));
		}
	}
}
