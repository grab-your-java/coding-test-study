import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2382 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 한 변의 셀의 개수 .. 즉 map[N][N]
			int M = sc.nextInt(); // 격리 시간, M 시간 후의 미생물 합 구하기 문제
			int K = sc.nextInt(); // 미생물 군집의 개수

			int[][] map = new int[N][N];

			int[] currentY = new int[K]; // 초기 y 좌표
			int[] currentX = new int[K]; // 초기 x 좌표
			int[] cells = new int[K]; // 초기 마릿수
			int[] direction = new int[K]; // 진행 방향

			int[] dx = { 0, 0, -1, 1 }; // 상 하 좌 우
			int[] dy = { -1, 1, 0, 0 };

			for (int i = 0; i < K; i++) {
				currentY[i] = sc.nextInt();
				currentX[i] = sc.nextInt();
				cells[i] = sc.nextInt();
				direction[i] = sc.nextInt(); // 상 하 좌 우 1 2 3 4
			}

			while (M > 0) { // 1시간마다 M-- 해주고 0이 되면 종료
				for (int i = 0; i < K; i++) { // 각 군집별로 순서대로 이동시켜준다.
					int nx = currentX[i] + dx[direction[i] - 1];
					int ny = currentY[i] + dy[direction[i] - 1];

					if (nx > 0 && nx < N - 1 && ny > 0 && ny < N - 1) { // 약품 안 쪽에서의 이동이라면
						currentX[i] = nx;
						currentY[i] = ny;
					} else {// 약품에 도달했을 때
						cells[i] = cells[i] / 2; // 마릿수 절반 감소
						if (direction[i] == 3) {// 진행방향이 좌측이었다면
							direction[i]++; // 우측으로 변경해준다.
						} else if (direction[i] == 4) { // 우측이었다면
							direction[i]--;// 좌측으로 변경해준다.
						} else if (direction[i] == 1) { // 진행방향이 위쪽 이었다면
							direction[i]++;// 아래방향으로 틀어준다.
						} else if (direction[i] == 2) { // 진행방향이 아래라면
							direction[i]--;// 위 방향으로 틀어준다.
						}
						// 진행방향 변경 완료
						currentX[i] = currentX[i] + dx[direction[i] - 1];
						currentY[i] = currentY[i] + dy[direction[i] - 1];
					}
				}
//				System.out.println(Arrays.toString(cells));
				// 1번씩 이동 후
				// 이동 후 군집끼리 만났을 때,
				// 미생물 수 합치고, 진행방향 수정.
				// 2개 이상의 군집이 모일 수 있으므로 브루트 포스를 사용해서
				// i번째 군집과 만나는 군집들의 번호를 찾고
				// 그 번호 군집들 중 가장 많은 cells을 가진 번호를 Q라고 했을 때
				// cells[Q] = cells[i] + cells[j] + cells[Q] ...
				// 나머지 합쳐진 군집들의 cells 값을 0으로 설정
				for (int i = 0; i < K; i++) {
					int cnt = 0; // 기준이 되는 i번 군집과 만나는 인덱스들의 갯수
					for (int j = i + 1; j < K; j++) {
						if (currentX[i] == currentX[j]) {
							cnt++;
						}
//						System.out.println("브루트포스 : " + cnt);
					}
					int[] meetIdx = new int[cnt];// 만나는 인덱스들을 배열에 넣는다.
					int index = 0;
					for (int j = i + 1; j < K; j++) {
						if (currentX[i] == currentX[j]) {
							meetIdx[index++] = j;
						}
					}
//					System.out.print("만나는 인덱스들의 배열 : ");
//					System.out.println(Arrays.toString(meetIdx));
					// 가장 많은 cells를 가진 군집 번호 찾기
					if (cnt > 0) {
						int max = 0;
						int max_cells_index = 0;
						for (int j = 0; j < meetIdx.length; j++) {
							if (cells[meetIdx[j]] > max) {
								max = cells[meetIdx[j]];
								max_cells_index = j;
							}
						}
//						System.out.println("max_cells_index : " + max_cells_index);
						// 군집 미생물 마릿수 합치고
						// 나머지 합병된 군집들의 마릿수 0으로 설정
						// 0으로 설정하면 나중에 다른 군집과 합병되어도
						// 진행방향이나, 최종 마릿수에 영향을 주지 않을 것이다 아마도...?
						int Q = max_cells_index;
						int cellSum = 0;
						for (int j = 0; j < meetIdx.length; j++) {
							cellSum += cells[meetIdx[j]];
							cells[meetIdx[j]] = 0;
//							System.out.println("q" + Q);
//							System.out.println("cellSum" + cellSum);
						}

						// 1. 각 군집별로 이동 시켰음.
						// 2. 이동 후 만나는 경우에 대해
						// 미생물 수 합쳤고, 합병된 군집 미생물 수 0으로 해놔서 진행방향 생각안해도 되고.. 아마도..?
						// 나머지 놓친 조건이 있나
						//
					}
					M--;
				}
				int sum = 0;
				for (int i = 0; i < K; i++) {
					sum += cells[i];
				}
				System.out.println("#" + test_case + " " + sum);

			}
		}

	}
}
//왜 약품에 닿았을 때 cells 절반 감소가 안될까...???
// 
//max_cells_index가 모든 케이스에서 0인 것을 보니 여기서부터 틀렸다. 
//택도 없던 것 같기도하고 아쉽기도 하고,,~~