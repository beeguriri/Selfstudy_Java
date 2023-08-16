package Java_Programmers.Level3;

import java.util.*;

public class 이중우선순위큐 {

    public static int[] solution(String[] operations) {
        int[] answer = new int [2];
        Queue<Integer> qMin = new PriorityQueue<>();
        Queue<Integer> qMax = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(String op : operations){

            String [] temp = op.split(" ");
            int num = Integer.parseInt(temp[1]);

            if(temp[0].equals("I")){
                qMin.offer(num);
                qMax.offer(num);
            } else if(temp[0].equals("D") && num==-1) {
                qMax.remove(qMin.poll());
            }
            else if(temp[0].equals("D") && num==1)
                qMin.remove(qMax.poll());
        }

        if(qMax.isEmpty() || qMin.isEmpty() || qMax.peek()==qMin.peek())
            return answer;
        else
            return new int [] {qMax.poll(), qMin.poll()};
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new String [] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        System.out.println(Arrays.toString(solution(new String [] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
        System.out.println(Arrays.toString(solution(new String [] {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"})));//[6,5]


    }

}
