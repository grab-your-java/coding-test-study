package swea.D4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1218 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int leng = sc.nextInt();
			String inputText = sc.next();
			String[] prevarr = inputText.split("");
			int[] arr = new int[leng];
			List<Integer> testArr = new ArrayList<>();
			for (int i = 0; i < leng; i++) {
				if (prevarr[i].equals("(")) {
					arr[i] = 1;
				} else if (prevarr[i].equals("{")) {
					arr[i] = 2;
				} else if (prevarr[i].equals("[")) {
					arr[i] = 3;
				} else if (prevarr[i].equals("<")) {
					arr[i] = 4;
				} else if (prevarr[i].equals(")")) {
					arr[i] = -1;
				} else if (prevarr[i].equals("}")) {
					arr[i] = -2;
				} else if (prevarr[i].equals("]")) {
					arr[i] = -3;
				} else if (prevarr[i].equals(">")) {
					arr[i] = -4;
				}
				if (testArr.size() == 0 || (testArr.size() > 0 && (testArr.get(testArr.size() - 1) + arr[i] != 0))) {
					testArr.add(arr[i]);
				} else if (testArr.get(testArr.size() - 1) + arr[i] == 0) {
					testArr.remove(testArr.size() - 1);
				}
			}
			System.out.println("#" + test_case + " " + (testArr.size() == 0 ? 1 : 0));

		}
	}
}
