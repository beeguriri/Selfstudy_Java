package Java_Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 택배상자 {

    public static int solution(int[] order) {
        int answer = 0;

        Queue<Integer> main = new LinkedList<>();
        Stack<Integer> sub = new Stack<>();
        for(int i=1; i<= order.length; i++)
            main.offer(i);

        for(int i: order) {
            while(!main.isEmpty() || !sub.isEmpty()) {
                if(!main.isEmpty() && main.peek()==i) {
                    main.poll();
                    answer++;
                    break;
                } else if (!sub.isEmpty() && sub.peek() ==i) {
                    sub.pop();
                    answer++;
                    break;
                } else
                    if(!main.isEmpty())
                        sub.push(main.poll());
                    else
                        return answer;
                }
            }
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int [] {4, 3, 1, 2, 5}));
        System.out.println(solution(new int [] {5, 4, 3, 2, 1}));
    }
}
