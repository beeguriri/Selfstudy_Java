package Java_Baekjoon._19_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {

    /* 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
    각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다.
    하나의 괄호 문자열의 길이는 2 이상 50 이하이다.
    여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){

            char [] arr = br.readLine().toCharArray();

            for(int j=0; j<arr.length; j++) {

                if(arr[j]=='(')
                    stack.push('(');
                else
                    if(stack.isEmpty())
                        stack.push(')');
                    else if (stack.peek() == '(')
                        stack.pop();
                    else
                        stack.push(')');

            }

            if(stack.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");

            stack.clear();

        }


    }
}
