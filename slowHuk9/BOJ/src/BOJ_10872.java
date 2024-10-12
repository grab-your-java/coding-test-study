import java.util.Scanner;

public class BOJ_10872 {
//	static int[] factorial = {0, 1, 2, 6, 24, 120, 720};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// memo - 0 ~ 6!
		int[] factorial = new int[13];
		factorial[0] = 1;
		factorial[1] = 1;
		factorial[2] = 2;
		factorial[3] = 6;
		factorial[4] = 24;
		factorial[5] = 120;
		factorial[6] = 720;
		for (int i = 7; i < factorial.length; i++) {
			factorial[i] = factorial[i-1] * i;
		}
		int target = sc.nextInt();
		System.out.println(factorial[target]);
		
	}

}
