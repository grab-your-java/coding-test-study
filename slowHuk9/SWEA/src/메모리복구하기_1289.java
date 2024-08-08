import java.util.Scanner;

public class 메모리복구하기_1289 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int x = 1; x <= T; x++) {
			String input = sc.next();
			int cnt = 0;
			char[] firstMemory = new char[input.length()];
			char[] currentMemory = new char[input.length()];
			
			
			for (int i = 0; i < currentMemory.length; i++) {
				currentMemory[i] = '0';
			}
//			System.out.print("초기화 값: ");
//			for (int i = 0; i < currentMemory.length; i++) {
//				System.out.print(currentMemory[i]);
//			}
			// 초기화된 메모리 인덱스 요소들은 모두 0 0 0 0 0 0
			// 기존 메모리와 현재 초기화된 메모리 인덱스값 하나하나 씩 비교해서
			// 같으면 넘어가고
			// 비교했을 때 값이 다르면
			// currentMemory[i]가 1일 때 ==> 그 인덱스 포함한 뒤의 인덱스 모두 0으로
			// 0일때 --> 1로

			for (int i = 0; i < firstMemory.length; i++) {
				firstMemory[i] = input.charAt(i);
			}
			// 값 잘 들어갔나 확인

//			System.out.print("기존 메모리 값: ");
//			for (int i = 0; i < firstMemory.length; i++) {
//				System.out.print(firstMemory[i]);
//			}

			for (int i = 0; i < firstMemory.length; i++) {
				if (firstMemory[i] != currentMemory[i]) {
					char change = firstMemory[i];
					cnt++;
					for (int j = i; j < currentMemory.length; j++) {
						currentMemory[j] = change;
					}
				}
			}
			System.out.println("#"+x + " " + cnt);
		}

	}

}
