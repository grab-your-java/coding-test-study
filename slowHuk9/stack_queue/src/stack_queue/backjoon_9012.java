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
        if (VPS && stack.empty()) { // 순회 다 끝내고나서 여는 괄호가 더 많을때를 판별해야 하는데
            // 왜 for문 다 돌고 나온 stack이 안나올까요
            // 했었는데 break; 문을 써가지구 남은 스택이 전달이 안됐나...???///?
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        // 6. 순회가 다 끝났는데 여는 괄호가 남아있다면(stack.empty가 false일때) no 출력
        // 7. 순회가 다 끝났는데 여는괄호가 없다면 (stack.empty가 true라면) yes
        //스택초기화해주기

    }
}
}