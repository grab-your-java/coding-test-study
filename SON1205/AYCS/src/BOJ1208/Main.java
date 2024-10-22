package BOJ1208;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int index;
	static long result;
	
	public static void main(String[] args) {
		result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		
		int[] left = new int[N / 2];
		int[] right = new int[N - N / 2];
		
		for (int i = 0; i < left.length; i++) {
			left[i] = sc.nextInt();
		}
		
		for (int i = 0; i < right.length; i++) {
			right[i] = sc.nextInt();
		}
		
		int[] leftSubset = new int[(int) Math.pow(2, left.length)];
		int[] rightSubset = new int[(int) Math.pow(2, right.length)];
		
		subset(left, leftSubset, 0, 0);
		index = 0;
		subset(right, rightSubset, 0, 0);
		
		Arrays.sort(leftSubset);
		Arrays.sort(rightSubset);
		
		checking(leftSubset, rightSubset, S);
		
		if (S == 0) {
			result--;
		}
		
		System.out.println(result);
	}
	
	static void subset(int[] input, int[] subset, int cnt, int tmp) {
		if (cnt == input.length) {
			subset[index++] = tmp;
			return;
		}
		
		subset(input, subset, cnt + 1, tmp + input[cnt]);
		subset(input, subset, cnt + 1, tmp);
	}
	
	static void checking(int[] negSubset, int[] posSubset, int S) {
		for (int i = 0; i < negSubset.length; i++) {
			int tmp = negSubset[i];
			
//			System.out.println("upperBound(posSubset, S - tmp): " + upperBound(posSubset, S - tmp));
//			System.out.println("lowerBound(posSubset, S - tmp): " + lowerBound(posSubset, S - tmp));
			
			result += upperBound(posSubset, S - tmp) - lowerBound(posSubset, S - tmp);
		}
	}
	
	private static int lowerBound(int[] posSubset, int target) {
	    int begin = 0;
	    int end = posSubset.length;
	    
	    while (begin < end) {
	    	int mid = (begin + end) / 2;
	        
	        if(posSubset[mid] >= target) {
	        	end = mid;
	        }
	        else {
	        	begin = mid + 1;
	        }
	    }
	    return end;
	}
	
	private static int upperBound(int[] posSubset, int target) {
	    int begin = 0;
	    int end = posSubset.length;
	    
	    while (begin < end) {
	    	int mid = (begin + end) / 2;
	        
	        if(posSubset[mid] <= target) {
	        	begin = mid + 1;
	        }
	        else {
	        	end = mid;
	        }
	    }
	    return end;
	}
}
