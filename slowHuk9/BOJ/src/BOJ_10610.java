import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10610 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		
		int[] digits = new int[N.length()];
		
		int sum = 0;
		boolean hasZero = false;
		for (int i = 0; i < digits.length; i++) {
			digits[i] = N.charAt(i) -'0';
			sum += digits[i];
			if(digits[i] == 0) {
				hasZero = true;
			}
		}
		
		if(sum % 3 == 0 && hasZero) {
			Arrays.sort(digits);
			StringBuilder target = new StringBuilder();
			for (int i = digits.length-1; i >= 0; i--) {
				target.append(digits[i]);
			}
			System.out.println(target.toString());
			return;
		}else {
			System.out.println(-1);
			return;
		}
	}
	
}
