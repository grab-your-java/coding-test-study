import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_11653 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		
		soinsu(N, list);
		for(int x : list) {
			System.out.println(x);
		}
	}

	static void soinsu(int N, List<Integer> list) {
		int mok = 2;
		while(N != 1) {
			if(N % mok != 0) {
				mok++;
			}else {
				list.add(mok);
				N /= mok;
			}
		}

	}
}
