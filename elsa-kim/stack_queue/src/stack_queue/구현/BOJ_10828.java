package stack_queue.구현;

import java.util.Scanner;

// 스택 구현
// 시간 초과
public class BOJ_10828 {
	public static void main(String[] args) {
		int[] numArray = new int[0];
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for (int i=0; i<test; i++) {
			int[] newArray;
			String order = sc.next();
			if (order.equals("push")) {
				int pushNum;
				pushNum = sc.nextInt();
				newArray = new int[numArray.length+1];
				for(int j=0; j<numArray.length; j++) {
					newArray[j] = numArray[j];
				}
				newArray[numArray.length] = pushNum;
				numArray = newArray;
			
			}else if(order.equals("top")) {
				if (numArray.length==0) {
					System.out.println(-1);
				}else {
					System.out.println(numArray[numArray.length-1]);
				}
			}else if (order.equals("pop")) {
				if (numArray.length==0) {
					System.out.println(-1);
				}else {
					System.out.println(numArray[numArray.length-1]);
					newArray = new int[numArray.length-1];
					for(int j=0; j<numArray.length-1; j++) {
						newArray[j] = numArray[j];
					}
					numArray = newArray;
					
				}
			}else if(order.equals("size")) {
				System.out.println(numArray.length);
			}else if(order.equals("empty")) {
				if(numArray.length==0) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}
		}
	}
}
