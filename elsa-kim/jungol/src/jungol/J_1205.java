package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class J_1205 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[] arr = new int[cnt];
		int zeroCnt = 0;
		for (int i = 0; i < cnt; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int maxLen = 0;
		for (int i = 0; i < cnt; i++) {
			if (arr[i] == 0) {
				zeroCnt++;
			} else if (i - 1 >= 0 && arr[i] == arr[i - 1]) {
				continue;
			} else {
				int canUse = zeroCnt;
				int leng = 1;
				int now = i;
				int nowNum = arr[i];
				while (canUse != 0) {
					if (now + 1 < cnt && nowNum == arr[now + 1]) {
						now++;
						nowNum = arr[now];
					} else if (now + 1 < cnt && nowNum + 1 == arr[now + 1]) {
						leng++;
						now++;
						nowNum = arr[now];
					} else {
						leng++;
						canUse--;
						nowNum++;
					}
				}
				while (now + 1 < cnt && nowNum + 1 == arr[now + 1]) {
					leng++;
					now++;
					nowNum = arr[now];
				}
				if (maxLen < leng)
					maxLen = leng;
			}
			if (zeroCnt == cnt) {
				maxLen = cnt;
			}
		}
		System.out.println(maxLen);
	}
}
