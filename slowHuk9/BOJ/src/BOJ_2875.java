import java.util.Scanner;

public class BOJ_2875 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 여학생 수
		int M = sc.nextInt(); // 남학생 수
		int K = sc.nextInt(); // 인턴쉽 참가 필요 인원

		int maxTeams = Math.min(N / 2, M);
		int remain = (N - maxTeams * 2) + (M - maxTeams);

		if (remain >= K) { // 남은 인원으로 인턴쉽 참가 인원을 땜빵할 수 있다면
			System.out.println(maxTeams);
		} else {
			int needed = K - remain; // 보충 필요한 인원 수
			//보충을 위해 깨야하는 팀의 수 구하기
			int teamMinus = (needed + 2) / 3; // 올림 계산을 위해 2를 더함 / 1명, 2명, 3명 필요할 때는 1팀 부시고, 4 5 6 은 2팀 이므로 
			System.out.println(maxTeams - teamMinus);
		}
	}
}
