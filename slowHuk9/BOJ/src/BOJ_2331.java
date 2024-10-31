import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2331 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int p = sc.nextInt();

		String number = Integer.toString(num);
		List<Integer> list = new ArrayList<>();
		list.add(num);
		solve(number, list, p);
//		System.out.println(list);
//		System.out.println(list.size());
		int idx = 0;
		for (int x : list) {
			idx++;
			if (x == list.get(list.size() - 1)) {
				System.out.println(idx - 1);
				return;
			}
		}

	}

	static void solve(String num, List<Integer> list, int p) {
		int sum = 0;
		for (int i = 0; i < num.length(); i++) {
			int n = num.charAt(i) - '0';
			sum += Math.pow(n, p);
		}
		if (!list.contains(sum)) {
			list.add(sum);
			solve(Integer.toString(sum), list, p);
		} else {
			list.add(sum);
			return;
		}
	}
}
