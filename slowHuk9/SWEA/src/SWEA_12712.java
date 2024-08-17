import java.util.Arrays;
import java.util.Scanner;

public class SWEA_12712 {
	static int n;
	static int m;
	static int[][] map;
	static int[] cntList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt(); //
			m = sc.nextInt(); //
			map = new int[n + 2 * (m - 1)][n + 2 * (m - 1)];
			map = new int[n + 2 * (m - 1)][n + 2 * (m - 1)];
			cntList = new int[n * n * 2];
			for (int i = m - 1; i < map.length - m + 1; i++) {
				for (int j = m - 1; j < map.length - m + 1; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			nozlePlus();
			nozleX();
			Arrays.sort(cntList);
			System.out.println("#" + test_case + " " + cntList[cntList.length - 1]);
		}
	}

	static void nozlePlus() {
		int index = 0;
		for (int i = m - 1; i < map.length - m + 1; i++) {
			for (int j = m - 1; j < map.length - m + 1; j++) {
				int sum = 0;
				for (int k = 1; k < m; k++) {
					sum += map[i][j + k] + map[i][j - k] + map[i + k][j] + map[i - k][j];
				}
				cntList[index++] = sum + map[i][j];
			}
		}
	}

	static void nozleX() {
		int index = n * n;
		for (int i = m - 1; i < map.length - m + 1; i++) {
			for (int j = m - 1; j < map.length - m + 1; j++) {
				int sum = 0;
				for (int k = 1; k < m; k++) {
					sum += map[i + k][j + k] + map[i - k][j - k] + map[i + k][j - k] + map[i - k][j + k];
				}
				cntList[index++] = sum + map[i][j];
			}
		}
	}
}
