package 브론즈;

import java.util.Scanner;

public class BOJ_14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T;test_case++) {
			int a = sc.nextInt();
			int[] aArr = new int[a];
			for(int i=0; i<a; i++) {
				aArr[i] = sc.nextInt();
			}
			int b = sc.nextInt();
			int[] bArr = new int[b];
			for(int i=0; i<b; i++) {
				bArr[i] = sc.nextInt();
			}
			int aCnt = 0;
			int bCnt = 0;
			int k=4;
			while(aCnt==bCnt && k>0) {
				for(int i=0; i<a; i++) {
					if(aArr[i]==k)aCnt++;
				}
				for(int i=0; i<b; i++) {
					if(bArr[i]==k)bCnt++;
				}
				k--;
			}
			if(aCnt==bCnt) {
				System.out.println("D");
			}else if(aCnt>bCnt){
				System.out.println("A");
			}else {
				System.out.println("B");
			}
			
		}
		
	}

}
