package stack_queue;


import java.util.Scanner;
import java.util.Stack;

public class backjoon_9012 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
        Stack<Character> stack = new Stack<>();
            
    
        // 1. 일단 문자열을 받는다.
        String s = sc.next();

        if (s.length() < 2 || s.length() > 50) {
            System.out.println("NO");
            continue; // 문자열이 2~50사이가 아닌경우 NO출력하고 맞으면 진행
        }
        boolean VPS = true;
        // 2. 문자열을 한글자씩 분리하면서 순회
        for (int j = 0; j < s.length(); j++) {
            // 3. 그 글자가 여는 괄호라면 stack.push 해버리기
            if (s.charAt(j) == '(') {
                stack.push(s.charAt(j));
                // 4. 그리고 닫는 괄호라면 바로 stack.pop
                // 5. 순회가 다 끝나기 전에 스택이 비어있는데, 닫는 괄호가 왔다면 no 출력
            } else { // ')' 일때
                if (stack.empty()) {
                    VPS = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (VPS && stack.empty()) { 
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
       
    }
}
}