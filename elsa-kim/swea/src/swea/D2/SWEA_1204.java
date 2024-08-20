package swea.D2;

import java.util.Scanner;

// 최빈수구하기
public class SWEA_1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt();
			int[] arr = new int[1000];
			int[] cnt = new int[101];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				cnt[arr[i]]++;
			}
			int max = 0;
			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] > max)
					max = cnt[i];
			}
			for (int i = cnt.length - 1; i >= 0; i--) {
				if (cnt[i] == max) {
					System.out.println("#" + t + " " + i);
					break;
				}
			}
		}
	}
}
