import java.util.Scanner;

public class BOJ_8320 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int sum = 0;
		int i = 1;
		while(i <= n/i) {
			int cnt = n/i - (i-1);
			sum+= cnt;
			i++;
		}
		System.out.println(sum);
		
	}
}