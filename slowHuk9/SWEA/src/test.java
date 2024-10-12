import java.util.Arrays;

public class test{
	public static void main(String[] args) {
		int direction = 1;
		System.out.println(-direction);
		
		int[] arr = {1,2,3,4,5,6,7,8};
		int[] copy = Arrays.copyOfRange(arr, 0, 5);
		System.out.println(Arrays.toString(copy));
	}
}