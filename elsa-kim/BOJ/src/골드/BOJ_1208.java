package 골드;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1208 {
	static int cnt, want, mSum, pSum;
	static long ans;
	static List<Integer> pList, mList;
	static boolean[] check;
	static int[] checkCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cnt = sc.nextInt();
		want = sc.nextInt();
		pList = new ArrayList<>();
		mList = new ArrayList<>();
		pSum = 0;
		mSum = 0;
		ans = 0;
		for (int i = 0; i < cnt; i++) {
			int N = sc.nextInt();
			if (N >= 0) {
				pList.add(N);
				pSum += N;
			} else {
				mList.add(N);
				mSum += N;
			}
		}
		check = new boolean[(pSum + 1)];
		checkCnt = new int[(pSum + 1)];
		getPcnt(0, 0);
		getMcnt(0, 0);

		System.out.println(want == 0 ? --ans : ans);
	}

	private static void getPcnt(int idx, int sum) {
		if (want - mSum < sum)
			return;
		if (idx == pList.size()) {
			check[sum] = true;
			checkCnt[sum]++;
			return;
		}
		getPcnt(idx + 1, sum + pList.get(idx));
		getPcnt(idx + 1, sum);
	}

	private static void getMcnt(int idx, int sum) {
		if (want - sum >= check.length) {
			return;
		}

		if (idx == mList.size()) {
			if (want - sum < 0) {
				return;
			}
			if (check[want - sum]) {
				ans += checkCnt[want - sum];
			}
			return;
		}
		getMcnt(idx + 1, sum + mList.get(idx));
		getMcnt(idx + 1, sum);
	}

}
