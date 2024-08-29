import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_5658 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			String[] origin = s.split("");

			int needCycle = n / 4 - 1; // 필요 회전 횟수 .. 12 / 4 - 1 = 2
			int size = n / 4 - 1;
			Stack<String> stack = new Stack();
			List<String> list = new ArrayList();

			for (int i = 0; i < n; i += (needCycle + 1)) {
				list.add(s.substring(i, i + needCycle + 1)); // 0~2 3 ~ 5
			}

			for (int i = 0; i < origin.length; i++) {
				stack.push(origin[i]);
			}
			
			while (needCycle > 0) { // 0회전을 제외한 필요한 회전 수만큼
				// String s 재사용하려고 초기화 시킴.
				s = "";
				stack.add(0, stack.pop());
				for (int i = 0; i < stack.size(); i++) {
					s += stack.get(i);
				}

				for (int i = 0; i < n; i += (size + 1)) { 
					if (!list.contains(s.substring(i, i + size + 1)))// 중복 거르기
						list.add(s.substring(i, i + size + 1)); // 
				}
				needCycle--;
			}
//			System.out.println("최종 : " + list);
			int[] numList = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				numList[i] = Integer.parseInt(list.get(i), 16); // 16진수를 10진수로 변경
			}
			Arrays.sort(numList);
//			System.out.println(Arrays.toString(numList));
			System.out.println("#" + test_case + " " + numList[numList.length - k]);
		}

	}
}
