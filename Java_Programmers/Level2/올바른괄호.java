package Java_Programmers.Level2;

import java.util.*;

public class 올바른괄호 {

    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack();

        for(char c : s.toCharArray()) {

            if(c == '(')
                stack.push(c);
            else {
                if(!stack.isEmpty() && stack.peek()=='(')
                    stack.pop();
                else
                    stack.push(c);
            }
        }



        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(stack);

        if(!stack.isEmpty())
            answer = false;

        return answer;
    }
}
