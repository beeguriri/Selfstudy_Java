package Java_Programmers.Level2;

import java.util.*;
import static java.util.Collections.*;

public class 괄호회전하기 {

    public static int count;

    public int solution(String s) {

        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray())
            list.add(c);

        for(int i=0; i<list.size(); i++) {

            rotate(list, -1);
            Stack<Character> stack = new Stack<>();

            for (int j=0; j<list.size(); j++) {

                if(stack.isEmpty()) {
                    stack.push(list.get(j));
                    continue;
                }

                if(list.get(j)=='[' || list.get(j)=='(' || list.get(j)=='{')
                    stack.push(list.get(j));
                else {
                    char x = stack.peek();

                    if(x=='[' && list.get(j)==']')
                        stack.pop();
                    else if (x=='(' && list.get(j)==')')
                        stack.pop();
                    else if (x=='{' && list.get(j)=='}')
                        stack.pop();
                }
            }

            if(stack.isEmpty())
                count++;

        }

        return count;
    }
}
