import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1216 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		int size = 100;
		for (int i = 1; i <= testCase; i++) {
			
			
			// map에 문자 넣기
			char[][] map = new char[size][size];
			int index;
			for (int j = 0; j < size; j++) {
				String s = sc.next();
				for (int k = 0; k < size; k++) {
					map[j][k] = s.charAt(k);
				}
			}
			
			// 가로 회문 검사
			int max = 0;
			for (int j = 0; j < size; j++) {
				index = 0;
				for (int k = 50; k < size; k++) {
					while (k + index >= size) {
						if (map[j][k - index] == map[j][k + index]) {
							index++;
						}
						break;
					}
					int length = 2 * index + 1;
					System.out.println("현재 기준이  " + k + " 일때의 가로 회문 길이 " + length);
					max = Math.max(max, length);
					System.out.println("현재 가로 회문 길이 중 최대 길이는 " + max);
				}
			}

			// 세로 회문 검사
			for (int k = 0; k < size; k++) {
				index = 0;
				for (int j = 50; j < size; j++) {
					while (j + index >= size) {
						if (map[j - index][k] == map[j + index][k]) {
							index++;
						}
						break;
					}
					int length = 2 * index + 1;
					max = Math.max(max, length);
					System.out.println("현재 기준이  " + j + " 일때의 세로 회문 길이 " + length);
					System.out.println("현재 가로, 세로 중 회문 최대 길이는 " + max);
				}
			}

		}

		//
	}

}
