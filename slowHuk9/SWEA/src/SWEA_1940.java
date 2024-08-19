import java.util.Scanner;

public class SWEA_1940 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int n = sc.nextInt();
			
			int distance = 0;
			int speed = 0;
			int velocity = 0;
			for (int i = 0; i < n; i++) {
				int command = sc.nextInt();
				if (command == 1) {
					velocity = sc.nextInt();
					speed += velocity;
				}
				if (command == 2) {
					velocity = sc.nextInt();
					speed -= velocity;
					if (speed < 0) {
						speed = 0;
					}
				}
				if (command == 0) {
					speed = speed;
				}
				distance += speed;
			}
			// System.out.println(test_case + " velocity : " + velocity + " speed = " +
			// speed + " distance = " + distance);
			System.out.println("#" + test_case + " " + distance);
		}

	}

}
