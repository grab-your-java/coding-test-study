package SWEA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_5656_벽돌깨기 {
	static int N, W, H;
	static int[] arr;
	static List<List<Integer>> list;
	static int minRest;
	static List<List<Integer>> test;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			list = new ArrayList<>();
			for (int i = 0; i < W; i++) {
				list.add(new ArrayList<>());
			}
			arr = new int[N];
			minRest = W * H;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					int n = sc.nextInt();
					if (n != 0)
						list.get(j).add(0, n);
				}
			}
			per(0);
			System.out.println("#" + tc + " " + minRest);
		}
	}

	private static void per(int cnt) {
		if (cnt == N) {
			test = new ArrayList<>();
			for (int i = 0; i < W; i++) {
				test.add(new ArrayList<>());
			}
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.get(i).size(); j++) {
					test.get(i).add(list.get(i).get(j));
				}
			}
			for (int i = 0; i < N; i++) {
				if (test.get(arr[i]).size() > 0) {
					int range = test.get(arr[i]).get(test.get(arr[i]).size() - 1);
					rm(arr[i], test.get(arr[i]).size() - 1, range);
					for (int j = 0; j < W; j++) {
						int size = test.get(j).size();
						for (int k = size - 1; k >= 0; k--) {
							if (test.get(j).get(k) == 0)
								test.get(j).remove(k);
						}
					}
				}
			}
//			System.out.println(Arrays.deepToString(test.toArray()));
			int total = 0;
			for (int i = 0; i < W; i++) {
				total += test.get(i).size();
			}
//			System.out.println(total);
			if (total < minRest)
				minRest = total;
			return;
		}
		for (int i = 0; i < W; i++) {
			arr[cnt] = i;
			per(cnt + 1);
		}

	}

	private static void rm(int idx, int height, int range) {
		test.get(idx).add(height, 0);
		test.get(idx).remove(height + 1);
		int cnt = 1;
		while (cnt != range) {
			if (idx - cnt >= 0 && test.get(idx - cnt).size() > height) {
				int target = test.get(idx - cnt).get(height);
				if (target > 1) {
					rm(idx - cnt, height, target);
				} else if (target == 1) {
					test.get(idx - cnt).add(height, 0);
					test.get(idx - cnt).remove(height + 1);
				}
			}
			if (idx + cnt < W && test.get(idx + cnt).size() > height) {
				int target = test.get(idx + cnt).get(height);
				if (target > 1) {
					rm(idx + cnt, height, target);
				} else if (target == 1) {
					test.get(idx + cnt).add(height, 0);
					test.get(idx + cnt).remove(height + 1);
				}
			}
			if (height - cnt >= 0) {
				int target = test.get(idx).get(height - cnt);
				if (target > 1) {
					rm(idx, height - cnt, target);
				} else if (target == 1) {
					test.get(idx).add(height - cnt, 0);
					test.get(idx).remove(height - cnt + 1);
				}
			}
			if (height + cnt < H && test.get(idx).size() > height + cnt) {
				int target = test.get(idx).get(height + cnt);
				if (target > 1) {
					rm(idx, height + cnt, target);
				} else if (target == 1) {
					test.get(idx).add(height + cnt, 0);
					test.get(idx).remove(height + cnt + 1);
				}
			}
			cnt++;
		}

	}

}
