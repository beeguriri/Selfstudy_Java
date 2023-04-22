package Java_Baekjoon._19_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발 {

    public static Stack<Character> stack = new Stack<>();

    public static void isBomb(String str, String bomb){

        for(int i=0; i<str.length(); i++){

            stack.push(str.charAt(i));

            if(stack.size()>=bomb.length()){

                boolean isSame = true;
                for(int j=0; j<bomb.length(); j++){

                    if(stack.get(stack.size()-bomb.length()+j) != bomb.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }

                if(isSame){
                    for(int j=0; j<bomb.length(); j++)
                        stack.pop();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        isBomb(str, bomb);

        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty())
            sb.append("FRULA");
        else {
            for(int i=0; i<stack.size(); i++)
                sb.append(stack.get(i));
        }

        System.out.println(sb);


// 메모리초과 --> 이렇게 쉽게 풀릴리가 없지...
//        while(str.contains(bomb)) {
//
//            str = str.replace(bomb, "");
//            if(str.length()==0) {
//                System.out.println("FRULA");
//                break;
//            }
//        }
//
//        System.out.println(str);

    }
}
