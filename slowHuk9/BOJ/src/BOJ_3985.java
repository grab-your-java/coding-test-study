import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3985 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();

		int[] cake = new int[L];
		int[] want = new int[N];
		int[] receive = new int[N];
		int t = 1;
		while (t <= N) {
			int p = sc.nextInt();
			int k = sc.nextInt();
			want[t - 1] = k - p + 1;
			int cnt = 0;
			for (int i = p - 1; i < k; i++) {
				if (cake[i] == 0) {
					cake[i] = t;
					cnt++;
				}
			}
		//	System.out.println(cnt);
			receive[t - 1] = cnt;
			t++;
		}
	//	System.out.println(Arrays.toString(cake));

		// 1. 가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호 출력
	//	System.out.println(Arrays.toString(want)); // 에서 가장 큰 값을 가진 인덱스 번호 추출하기
		int max_want = want[0];
		int max_want_index = 0;
		for (int i = 1; i < want.length; i++) {
			if (want[i] > max_want) {
				max_want = want[i];
				max_want_index = i;
			}
		}
		System.out.println(max_want_index + 1);

		int max_receive = receive[0];
		int max_receive_index = 0;
		for (int i = 1; i < receive.length; i++) {
			if (receive[i] > max_receive) {
				max_receive = receive[i];
				max_receive_index = i;
			}
		}
		System.out.println(max_receive_index + 1);
		// 2. 실제로 가장 많은 조각을 받은 방청객의 번호 출력
	//	System.out.println(Arrays.toString(receive));
	}

}
