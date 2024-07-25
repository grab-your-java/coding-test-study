package 실버;

import java.util.Scanner;

public class BOJ_2527 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase:for(int test=0; test<4; test++) {
			int a[] = new int[4];
			int b[] = new int[4];
			for(int i=0; i<4; i++) {
				a[i]=sc.nextInt();
			}
			for(int i=0; i<4; i++) {
				b[i]=sc.nextInt();
			}
			if(a[2]<b[0]|| a[0]>b[2]||a[1]>b[3]||a[3]<b[1]) {
				System.out.println("d"); 
				continue testCase;
			}else if((a[2]==b[0]&&a[3]==b[1])||(a[0]==b[2]&&a[3]==b[1])||(a[0]==b[2]&&a[1]==b[3])||(a[2]==b[0]&&a[1]==b[3])) {
				System.out.println("c"); 
				continue testCase;
			}
			else if ((a[0]==b[2]&&((a[1]>b[1]&&a[1]<b[3])||(a[3]>b[1]&&a[3]<b[3])||(a[1]==b[1]&&a[3]==b[3])))
					||(a[1]==b[3]&&((a[0]>b[0]&&a[0]<b[2])||(a[2]>b[0]&&a[2]<b[2])||(a[0]==b[0]&&a[2]==b[2])))
					||(a[2]==b[0]&&((a[3]>b[1]&&a[3]<b[3])||(a[1]>b[1]&&a[1]<b[3])||(a[1]==b[1]&&a[3]==b[3])))
					||(a[3]==b[1]&&((a[0]>b[0]&&a[0]<b[2])||(a[2]>b[0]&&a[2]<b[2])||(a[0]==b[0]&&a[2]==b[2])))
					||(b[0]==a[2]&&((b[1]>a[1]&&b[1]<a[3])||(b[3]>a[1]&&b[3]<a[3])||(a[1]==b[1]&&a[3]==b[3])))
					||(b[1]==a[3]&&((b[0]>a[0]&&b[0]<a[2])||(b[2]>a[0]&&b[2]<a[2])||(a[0]==b[0]&&a[2]==b[2])))
					||(b[2]==a[0]&&((b[3]>a[1]&&b[3]<a[3])||(b[1]>a[1]&&b[1]<a[3])||(a[1]==b[1]&&a[3]==b[3])))
					||(b[3]==a[1]&&((b[0]>a[0]&&b[0]<a[2])||(b[2]>a[0]&&b[2]<a[2])||(a[0]==b[0]&&a[2]==b[2])))){
				System.out.println("b"); 
				continue testCase;
			}else {
				System.out.println("a"); 
				continue testCase;
				
			}
			
		}
	}
}
