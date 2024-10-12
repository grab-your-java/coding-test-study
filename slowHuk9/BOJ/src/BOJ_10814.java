import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_10814 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[][] list = new String[N][3];

		for (int i = 0; i < N; i++) {
			list[i][0] = sc.next();
			list[i][1] = sc.next();
			list[i][2] = i + "";
		}

		Arrays.sort(list, (e1, e2) -> {
			if (e1[0] == e2[0]) {
				if (e1[1] == e2[1]) {
					return Integer.parseInt(e1[2]) - Integer.parseInt(e2[2]);
				} else {
					return Integer.parseInt(e1[1]) - Integer.parseInt(e2[1]);
				}
			} else {
				return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
			}
		});

		for (int i = 0; i < N; i++) {
			System.out.println(list[i][0] + " " + list[i][1]);
		}
	}
	
}
