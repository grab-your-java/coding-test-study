package 실버;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11728 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aCnt = sc.nextInt();
		int bCnt = sc.nextInt();
		int[] aArr = new int[aCnt];
		int[] bArr = new int[bCnt];
		for (int i = 0; i < aCnt; i++) {
			aArr[i] = sc.nextInt();
		}
		for (int i = 0; i < bCnt; i++) {
			bArr[i] = sc.nextInt();
		}
		Arrays.sort(aArr);
		Arrays.sort(bArr);
		int aIdx = 0;
		int bIdx = 0;
		StringBuilder sb = new StringBuilder();
		while (aIdx < aCnt || bIdx < bCnt) {
			if (aIdx == aCnt) {
				sb.append(bArr[bIdx++]).append(" ");
			} else if (bIdx == bCnt) {
				sb.append(aArr[aIdx++]).append(" ");
			} else if (aArr[aIdx] < bArr[bIdx]) {
				sb.append(aArr[aIdx++]).append(" ");
			} else {
				sb.append(bArr[bIdx++]).append(" ");
			}
		}
		System.out.println(sb);
	}
}