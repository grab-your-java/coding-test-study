package 실버;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_10814 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		int[] age = new int[cnt];
		String[] name = new String[cnt];
		for (int i = 0; i < cnt; i++) {

			age[i] = sc.nextInt();
			name[i] = sc.next();
			if (i == 0) {
				list.add(i);
			} else {
				int idx = list.size() / 2;
				int startIdx = 0;
				int endIdx = list.size();
				while (startIdx < endIdx && idx < list.size() && idx >= 0) {
					if (age[list.get(idx)] < age[i]) {
						startIdx = idx + 1;
						idx = (startIdx + endIdx) / 2;
					} else if (age[list.get(idx)] > age[i]) {
						if (idx == 0 || age[list.get(idx - 1)] <= age[i]) {
							break;
						}
						endIdx = idx;
						idx = (startIdx + endIdx) / 2;
					} else {
						idx++;
					}

				}
				list.add(idx, i);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(age[list.get(i)] + " " + name[list.get(i)]);
		}
	}

}
