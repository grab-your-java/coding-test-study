package stack_queue.구현;

import java.util.Scanner;

// 큐
// 시간 초과
public class BOJ_18258 {
	public static void main(String[] args) {
		int fi = -1;
		int bi = -1;
		Scanner sc = new Scanner(System.in);
		int orderCnt;
		String order;
		orderCnt = sc.nextInt();
		int[] que = new int[orderCnt];
		while(orderCnt>0) {
			order=sc.next();
			switch(order) {
				case "push":
					int n;
					n = sc.nextInt();
					fi++;
					que[fi] = n;
					break;
				case "pop":
					if(fi==bi) {
						System.out.println(-1);
					}else {
						bi++;
						System.out.println(que[bi]);
						que[bi] = 0;
					}
					break;
				case "size":
					System.out.println(fi-bi);
					break;
				case "empty":
					if(fi==bi) {
						System.out.println(1);
					}else {
						System.out.println(0);
					}
					break;
				case "front":
					if(fi==bi) {
						System.out.println(-1);
					}else {
						System.out.println(que[bi+1]);
					}
					break;
				case "back":
					if (fi==bi) {
						System.out.println(-1);
					}else {
						System.out.println(que[fi]);
					}
					break;
					
			}
			orderCnt--;
		}
		
	}
}
