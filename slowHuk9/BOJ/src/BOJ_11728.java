import java.util.Scanner;

public class BOJ_11728 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] x = new int[N];
		int[] y = new int[M];
		
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		
		for (int i = 0; i < y.length; i++) {
			y[i] = sc.nextInt();
		}
		
		StringBuilder sb = new StringBuilder();
		
		int xPointer = 0;
		int yPointer = 0;
		
		while(xPointer < N && yPointer < M) {
			// 두개의 배열 원소를 하나씩 비교해서
			// 더 작은 배열 원소를 먼저 넣는다.
			if(x[xPointer] <= y[yPointer]) { 
				sb.append(x[xPointer]+" ");
				xPointer++;
			}else {
				sb.append(y[yPointer] + " ");
				yPointer++;
			}
		}
		// while문을 다 돌았다고 해서 모든 정렬이 끝난 것이 아님, 어느 한쪽의 배열의 포인터가 배열의 길이를 벗어나
		// while문을 나온 것일 수도 있음
		
		//while문 이후에 x배열의 포인터가 배열 끝까지 도달했다면
		//y배열은 아직 정렬을 진행해야할 원소가 남아있다.
		if(xPointer == N) {
			for (int i = yPointer; i < y.length; i++) {
				sb.append(y[i] + " ");
			}
		}
		if(yPointer == M) {
			for (int i = xPointer; i < x.length; i++) {
				sb.append(x[i] + " ");
			}
		}
		System.out.println(sb);
		
		
		
	}
}
