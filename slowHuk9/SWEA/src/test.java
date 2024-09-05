import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class test {
	static Stack<Integer> magnet1 = new Stack<>();
	static Stack<Integer> magnet2 = new Stack<>();
	static Stack<Integer> magnet3 = new Stack<>();
	static Stack<Integer> magnet4 = new Stack<>();
	static List<Stack<Integer>> list =new ArrayList<>();
	static int K;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			K = sc.nextInt();
			for (int i = 0; i < 8; i++) {
				int pole = sc.nextInt();
				magnet1.add(pole);
			}
			for (int i = 0; i < 8; i++) {
				int pole = sc.nextInt();
				magnet2.add(pole);
			}
			for (int i = 0; i < 8; i++) {
				int pole = sc.nextInt();
				magnet3.add(pole);
			}
			for (int i = 0; i < 8; i++) {
				int pole = sc.nextInt();
				magnet4.add(pole);
			}
			list.add(magnet1);
			list.add(magnet2);
			list.add(magnet3);
			list.add(magnet4);
			
			for (int i = 0; i < K; i++) {
				int selMagnet = sc.nextInt();
				int spinDirection = sc.nextInt();
				spin(selMagnet, spinDirection, 0);
			}
		}
	}

	static void spin(int selMagnet, int spinDirection, int cnt) {
		//기저 조건
		if(cnt == K) { // K번 회전했을 때!!
			// 각 자석마다 화살표에 해당하는 인덱스의 값을 구하고 자석별 점수 구해서 더하기.
			return;
		}
		
		//재귀 부분
		if(selMagnet == 1) { // 돌리는 자석 번호가 1일때
			if(spinDirection ==1) { // 시계방향일때
				
			}else { // 반시계일때
				
			}
		}
	}

}
