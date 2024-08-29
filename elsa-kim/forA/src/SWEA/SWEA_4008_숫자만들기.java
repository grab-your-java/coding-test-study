package SWEA;

import java.util.Scanner;

public class SWEA_4008_숫자만들기 {
	static int[] oper, num, arr; // 연산자 배열, 숫자 배열, 순열
	static int calcNum, max, min;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int cnt = sc.nextInt();
			oper = new int[cnt - 1];
			check = new boolean[cnt - 1];
			num = new int[cnt];
			arr = new int[cnt - 1];
			calcNum = 0;
			max = -100000000;
			min = 100000000;
			for (int i = 0, idx = 0; i < 4; i++) {
				int n = sc.nextInt();
				for (int k = 0; k < n; k++) {
					oper[idx++] = i;
				}
			}
			for (int i = 0; i < cnt; i++) {
				num[i] = sc.nextInt();
			}
			per(0, num[0]);
			System.out.println("#" + tc + " " + (max - min));
		}
	}

	private static void per(int cnt, int sum) {
		if (cnt == arr.length) {
			if (sum > max)
				max = sum;
			if (sum < min)
				min = sum;
			return;
		}
		int now = -1;
		for (int i = 0; i < oper.length; i++) {
			if(i!=0 &&now==oper[i]) {
				continue;
			}
			if (!check[i]) {
				now = oper[i];
				check[i] = true;
				if(oper[i]==0) {
					per(cnt + 1, sum+num[cnt+1]);
				}else if(oper[i]==1) {
					per(cnt + 1, sum-num[cnt+1]);
				}else if(oper[i]==2) {
					per(cnt + 1, sum*num[cnt+1]);
				}else if(oper[i]==3) {
					per(cnt + 1, sum/num[cnt+1]);
				}
				check[i] = false;
			}
		}
	}

}
