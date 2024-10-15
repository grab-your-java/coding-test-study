import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_1107 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int pushCnt = 0;

		boolean isLarger = false;
		boolean compare = false;
		// 목표 채널
		String targetNum = sc.next(); // 5457
		int target = Integer.parseInt(targetNum);
		int targetLength = targetNum.length(); // 4 .. 10*3 부터 나눈다.

		int[] num = new int[targetLength];
		int idx = 0;
		int tmp = target;
		for (int i = targetLength - 1; i >= 0; i--) {
			num[idx] = (int) (tmp / Math.pow(10, i));
			idx++;
			tmp %= (int) Math.pow(10, i);
		}
//		System.out.println(Arrays.toString(num));

		List<Integer> btns = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			btns.add(i); // 리모콘 버튼 추가
		}
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int brokenBtn = sc.nextInt();
			for (int j = 0; j < btns.size(); j++) {
				if (btns.get(j) == brokenBtn)
					btns.remove(j); // 고장난 버튼은 리스트에서 제외
			}
		}

		if (target == 100) {
			pushCnt = 0;
			System.out.println(pushCnt);
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length; i++) {
			if(compare && sb.charAt(0)-'0' < num[0]) {
				sb.append(btns.get(btns.size()-1));
				pushCnt++;
				continue;
			}
			
			int mindiff = 100;
			for (int j = 0; j < btns.size(); j++) {
				int diff = Math.abs(num[i] - btns.get(j));
				mindiff = Math.min(mindiff, diff);
			}
			out: for (int j = 0; j < btns.size(); j++) {
				if (Math.abs(num[i] - btns.get(j)) == mindiff) {
					sb.append(btns.get(j));
					compare = true; // 이제부터 큰지 작은지 비교 가능
					break out;
				}
			}
			pushCnt++;
			
		}
		System.out.println("작동 가능 버튼 : " + btns);
		System.out.println("입력 채널 : " + sb.toString());
		pushCnt += Math.abs(target - Integer.parseInt(sb.toString()));

		System.out.println(pushCnt);
	}
}
