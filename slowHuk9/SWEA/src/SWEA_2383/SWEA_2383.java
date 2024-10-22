package SWEA_2383;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_2383 {
	static int N;
	static int[][] map;
	static int[][] person;
	static int[] personNum;
	static int[][] stair;
	static List<Integer> stair1;
	static List<Integer> stair2;
	static boolean[] sel;
	static Queue<Integer> queue1; // 계단1 이용중
	static Queue<Integer> queue2; // 계단2 이용중

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 맵의 크기
			map = new int[N][N];
			stair = new int[3][3]; // [계단번호][1] row , [2] col
			stair1 = new ArrayList<>();
			stair2 = new ArrayList<>();
			int personCnt = 0;
			int idx = 1;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) {
						personCnt++;
					}
					if (map[i][j] != 0 && map[i][j] != 1) {
						System.out.println("계단 찾음. idx값" + idx);
						stair[idx][1] = i;
						stair[idx][2] = j;
						idx++;
					}
				}
			}
			sel = new boolean[personCnt + 1]; //
			personNum = new int[personCnt + 1];
			idx = 1;
			person = new int[personCnt + 1][3]; // person[사람번호][1] row, person[2] col
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == 1) {
						personNum[idx] = idx;
						person[idx][1] = i;
						person[idx][2] = j;
						idx++;
					}
				}
			}
			powerSet(0);
		}

	}

	static void powerSet(int depth) {
		stair1.clear();
		stair2.clear();

		// 기저 조건
		if (depth == sel.length) {
			for (int i = 1; i < sel.length; i++) {
				if (sel[i]) {
					stair1.add(personNum[i]);
				} else {
					stair2.add(personNum[i]);
				}
			}
			calculation();
			return;
		}

		// 재귀 부분

		sel[depth] = true;
		powerSet(depth + 1);
		sel[depth] = false;
		powerSet(depth + 1);
	}

	static int calculation() {
		System.out.println("__________________________________");
		// stair1 리스트
//		System.out.println(stair2);

		System.out.println("계단 1으로 가는 사람들 :  " + stair1);
		// 계단1까지 가는데 걸리는 시간 계산
		int[] distToStair1 = new int[stair1.size()];
		for (int i = 0; i < stair1.size(); i++) {
			int rowDistance = Math.abs(person[stair1.get(i)][1] - stair[1][1]); // i+1 번 사람의 row 좌표 - 계단1의 row 좌표
			int colDistance = Math.abs(person[stair1.get(i)][2] - stair[1][2]); // i+1 번 사람의 col 좌표 - 계단1의 col 좌표
			distToStair1[i] = rowDistance + colDistance;
		}
		System.out.println(Arrays.toString(distToStair1));
		Arrays.sort(distToStair1);
		System.out.println("______________오름차순 정렬 후____________");
		System.err.println(Arrays.toString(distToStair1));
		int latest1 = 0;
		if (distToStair1.length > 0) {
			latest1 = distToStair1[distToStair1.length - 1];
		}
		System.err.println(latest1);

		int stair1Time = 0;

		queue1 = new ArrayDeque<>();
		if (stair1.size() <= 3) { // 해당 계단에 3명 이하라면
			stair1Time = map[stair[1][1]][stair[1][2]] + latest1; // 가장 늦는 사람이 계단에 도착하는 시간 + 그 사람이 계단 이용 시간
		} else {
			if (stair1.size() > 3) {
				// 계단으로 내려가는데 걸리는 시간 = stair1Time
				int timer = 0;
				for (int i = 0; i < stair1.size(); i++) {
					timer = distToStair1[i];
					queue1.add(distToStair1[i]);
					if (queue1.size() > 3) {

					}
				}
			}
		}
		// 계단2
		int[] distToStair2 = new int[stair2.size()];
		for (int i = 0; i < stair2.size(); i++) {
			int rowDistance = Math.abs(person[stair2.get(i)][1] - stair[2][1]); // i+1 번 사람의 row 좌표 - 계단1의 row 좌표
			int colDistance = Math.abs(person[stair2.get(i)][2] - stair[2][2]); // i+1 번 사람의 col 좌표 - 계단1의 col 좌표
			distToStair2[i] = Math.abs(rowDistance - colDistance);
		}

		// stair2 리스트
		return -1;
	}

}
