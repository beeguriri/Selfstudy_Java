package Java_Programmers.Level2;

import java.util.*;

public class 프로세스 {


    public static int solution(int[] priorities, int location) {

        LinkedList<int []> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        // {index, priority}
        for (int i=0; i<priorities.length; i++) {
            q.offer(new int [] {i, priorities[i]});
        }

        while(!q.isEmpty()) {

            int maxPriority = 0;
            for(int i=0; i<q.size(); i++)
                maxPriority = Math.max(maxPriority, q.get(i)[1]);

            if(q.peek()[1] < maxPriority)
                q.offer(q.poll());
            else
                list.add(q.poll()[0]);

        }

        return list.indexOf(location) + 1;
    }

    public static void main(String[] args) {

        int [] arr1 = {2, 1, 3, 2};
        System.out.println(solution(arr1, 2)); //1

        int [] arr2 = {1, 1, 9, 1, 1, 1};
        System.out.println(solution(arr2, 0)); //5


    }

}
