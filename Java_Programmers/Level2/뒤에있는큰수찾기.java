package Java_Programmers.Level2;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에있는큰수찾기 {

    public static int[] solution(int[] numbers) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int [numbers.length];

        for(int i=0; i<numbers.length; i++){

            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i])
                answer[stack.pop()] = numbers[i];

            stack.push(i);
        }

        while(!stack.isEmpty())
            answer[stack.pop()] = -1;

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int [] {2, 3, 3, 5})));
        //[3, 5, 5, -1]
        System.out.println(Arrays.toString(solution(new int [] {9, 1, 5, 3, 6, 2})));
        //[-1, 5, 6, 6, -1, -1]
    }
}
