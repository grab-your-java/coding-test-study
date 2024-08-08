import java.util.Scanner;

public class SWEA_1289 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int x = 1; x <= T; x++) {
			String input = sc.next();
			int cnt = 0;
			char[] firstMemory = new char[input.length()];
			char[] currentMemory = new char[input.length()];


			// 초기화된 메모리 인덱스 요소들은 모두 0 0 0 0 0 0
			for (int i = 0; i < currentMemory.length; i++) {
				currentMemory[i] = '0';
			}
//			System.out.print("초기화 값: ");
//			for (int i = 0; i < currentMemory.length; i++) {
//				System.out.print(currentMemory[i]);
//			}
			// input 문자열을 char로 반환한다.
			for (int i = 0; i < firstMemory.length; i++) {
				firstMemory[i] = input.charAt(i);
			}
			// 값 잘 들어갔나 확인

//			System.out.print("기존 메모리 값: ");
//			for (int i = 0; i < firstMemory.length; i++) {
//				System.out.print(firstMemory[i]);
//			}
			// 현재 메모리와 기존 메모리의 인덱스 요소들을 비교하면서
			// 다르면 기존 메모리 인덱스 값을
			// change 에 저장하고
			// 현재 메모리의 i 인덱스부터 마지막 인덱스까지
			// change 값으로 덮어쓴다.
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