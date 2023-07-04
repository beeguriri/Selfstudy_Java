package Java_Programmers.Level2;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {

    public static int[] solution(int[] prices) {

        int[] answer = new int [prices.length];
        Stack<Integer[]> stack = new Stack<>();

        for(int i=0; i<prices.length; i++) {

            //가격 하락 확인
            while(!stack.isEmpty() && prices[i] < stack.peek()[0]){
                Integer [] temp = stack.pop();
                answer[temp[1]] = i - temp[1];
            }

            stack.push(new Integer[]{prices[i], i});

        }

        //하락이 없었던 index 시간 계산
        while(!stack.isEmpty()) {
            Integer [] temp = stack.pop();
            answer[temp[1]] = prices.length - temp[1] - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new int [] {1, 2, 3, 2, 3})));
        System.out.println(Arrays.toString(solution(new int [] {2, 2, 3, 1, 5})));

    }
}
