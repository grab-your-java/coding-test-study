package 실버;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_10816 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> list = new HashMap<>();
		int listLeng = Integer.parseInt(sc.nextLine());
		String[] listItem = sc.nextLine().split(" ");
		for (int i = 0; i < listLeng; i++) {
			list.put(listItem[i], (list.get(listItem[i]) == null) ? 1 : list.get(listItem[i]) + 1);
		}
		int cnt = Integer.parseInt(sc.nextLine());
		String[] wantList = sc.nextLine().split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < cnt; i++) {
			sb.append(list.get(wantList[i]) == null ? 0 : list.get(wantList[i]));
			sb.append(" ");
		}
		System.out.print(sb);
	}

}
