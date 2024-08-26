package swea.D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_7964 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int city = sc.nextInt();
			int limit = sc.nextInt();
			int[] arr = new int[city];
			int ans = 0;
			List<Integer> list = new ArrayList<>();
			list.add(-1);
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] == 1)
					list.add(i);
			}
			list.add(city);
			for (int i = 0; i < list.size() - 1; i++) {
				ans += (list.get(i + 1) - list.get(i)) / limit;
				if ((list.get(i + 1) - list.get(i)) % limit == 0)
					ans--;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
