package SWEA_2383;

import java.util.ArrayList;
import java.util.List;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 맵의 크기
			map = new int[N][N];
			stair = new int[2][2]; // [계단번호][1] row , [2] col
			stair1 = new ArrayList<>();
			stair2 = new ArrayList<>();
			int personCnt = 0;
			int idx = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) {
						personCnt++;
					}
					if (map[i][j] != 0 && map[i][j] != 1) {
						System.out.println("계단 찾음. idx값" + idx);
						stair[idx][0] = i;
						stair[idx][1] = j;
						idx++;
					}
				}
			}
			sel = new boolean[personCnt]; // 
			personNum = new int[personCnt];
			idx = 1;
			person = new int[personCnt + 1][3]; // person[사람번호][1] row, person[2] col
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == 1) {
						personNum[idx-1] = idx;
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
		
		//기저 조건
		if(depth == sel.length ) {
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					stair1.add(personNum[i]);
				}else {
					stair2.add(personNum[i]);
				}
			}
			System.out.println(stair1);
			System.out.println(stair2);
			return;
		}
		
		//재귀 부분
		
		sel[depth] = true;
		powerSet(depth + 1);
		sel[depth] = false;
		powerSet(depth + 1);
		
	}

}
