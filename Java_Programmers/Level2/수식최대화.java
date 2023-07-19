package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class 수식최대화 {

    public static long solution(String expression) {

        List<String> number = new ArrayList<>();
        String [][] permutations = {{"*", "+", "-"},{"*", "-", "+"},
                {"+", "*", "-"}, {"+", "-", "*"}, {"-", "*", "+"}, {"-", "+", "*"}};

        // 숫자 추가하기
        int idx=0;
        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i)=='+' ||
                    expression.charAt(i)=='-' ||
                    expression.charAt(i)=='*') {
                number.add(expression.substring(idx, i));
                number.add(expression.substring(i, i+1));
                idx = i+1;
            }
        }
        // 마지막 숫자 추가
        number.add(expression.substring(idx));

        // 계산
        long answer = 0;
        for(int i=0; i<permutations.length; i++) {
            List<String> result = new ArrayList<>(number);
            for(int j=0; j<3; j++) {
                for(int k=0; k<result.size(); k++) {
                    if(permutations[i][j].equals(result.get(k))){
                        long temp = calc(Long.parseLong(result.get(k-1)), Long.parseLong(result.get(k+1)), result.get(k));
                        result.add(k-1, String.valueOf(temp));
                        result.remove(k);
                        result.remove(k);
                        result.remove(k);
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(result.get(0))));
        }

        return answer;
    }

    public static long calc(long a, long b, String x) {
        if(x.equals("*"))
            return a*b;
        else if (x.equals("+"))
            return a+b;
        else
            return a-b;
    }

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
        System.out.println(solution("50*6-3*2"));
    }
}
