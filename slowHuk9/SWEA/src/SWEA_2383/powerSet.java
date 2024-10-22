package SWEA_2383;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class powerSet {

	static int[] personNum = { 1, 2, 3, 4, 5 };
	static int N; // 사람의 수
	static boolean[] sel;
	static List<Integer> stair1;
	static List<Integer> stair2;

	public static void main(String[] args) {
		N = 5;
		sel = new boolean[N];
		stair1 = new ArrayList<>();
		stair2 = new ArrayList<>();
		powerSet(0);
		
	}
	
	static void powerSet(int idx) {
		stair1.clear();
		stair2.clear();
		if(idx == N) {
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					stair1.add(personNum[i]);
				}else {
					stair2.add(personNum[i]);
				}
			}
			System.out.println("stair1 : " + stair1);
			System.out.println("stair2 : " + stair2);
			return;
		}
		
		sel[idx] = true;
		powerSet(idx+1);
		sel[idx] = false;
		powerSet(idx+1);
	}
}
