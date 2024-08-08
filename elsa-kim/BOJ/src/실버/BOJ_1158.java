package 실버;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		
		for(int i = 0; i<n;i++) {
			arr.add(i+1);
		}
		System.out.print("<");
		for(int i = 0, idx = k; i<n;i++) {
			idx--;
			if(idx>=arr.size()) {
				idx = idx%arr.size();
			}else if(idx<0){
				idx=arr.size()-idx;
			}
			System.out.print(arr.remove(idx));
			if(i!=n-1) {
				System.out.print(", ");
			}
			idx += k;
		}
		System.out.print(">");

	}

}
