package Java_Baekjoon._19_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {

    /*각 문자열은 마지막 글자를 제외하고 영문 알파벳, 공백, 소괄호("( )"), 대괄호("[ ]")로 이루어져 있으며,
    온점(".")으로 끝나고, 길이는 100글자보다 작거나 같다.
    입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.
    각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();

        while(!s.equals(".")) {
            s = s.replaceAll("[^\\(\\)\\[\\]]", "");
            char [] arr = s.toCharArray();

            for(int i=0; i<arr.length; i++) {

                if(arr[i]=='(')
                    stack.push(arr[i]);
                else if (arr[i] == ')'){

                    if(stack.isEmpty())
                        stack.push(arr[i]);
                    else if (stack.peek()=='(')
                        stack.pop();
                    else
                        stack.push(arr[i]);
                } else if (arr[i] == '[')
                    stack.push(arr[i]);
                else {

                    if(stack.isEmpty())
                        stack.push(arr[i]);
                    else if (stack.peek() == '[')
                        stack.pop();
                    else
                        stack.push(arr[i]);

                }
            }

            if(stack.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");

            stack.clear();

            s = br.readLine();
        }
    }
}
