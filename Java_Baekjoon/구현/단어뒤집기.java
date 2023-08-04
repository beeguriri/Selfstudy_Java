package Java_Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 단어뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for(int i=0; i<s.length(); i++) {

            if(s.charAt(i)=='<'){
                flag = true;
                //그전에 저장된거 전부 뽑기
                while(!stack.isEmpty())
                    sb.append(stack.pop());

                sb.append(s.charAt(i));

            } else if(s.charAt(i)=='>'){
                sb.append(s.charAt(i));
                flag = false;
            } else {
                if(flag)
                    //괄호안일때는 차례대로 출력하기
                    sb.append(s.charAt(i));
                else {
                    //괄호밖일때는 공백 전까지 거꾸로 출력해야됨
                    if (s.charAt(i) == ' ') {
                        while (!stack.isEmpty())
                            sb.append(stack.pop());
                        sb.append(s.charAt(i));
                    } else
                        stack.push(s.charAt(i));
                }
            }
        }

        while(!stack.isEmpty())
            sb.append(stack.pop());

        System.out.println(sb);
    }
}
