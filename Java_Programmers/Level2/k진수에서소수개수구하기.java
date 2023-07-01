package Java_Programmers.Level2;

import java.util.*;

public class k진수에서소수개수구하기 {

    public static int solution(int n, int k) {

        char [] chars = Integer.toString(n, k).toCharArray();
        Queue<Character> q = new LinkedList<>();
        List<Long> numbers = new ArrayList<>();

        for(char c : chars)
            q.offer(c);

        String temp = "";
        while(!q.isEmpty()){

            if(q.peek()=='0') {
                q.poll();
                if (temp.length()>0)
                    numbers.add(Long.parseLong(temp));
                temp = "";
            } else
                temp += q.poll();
        }
        if (temp.length()>0)
            numbers.add(Long.parseLong(temp));

        System.out.println(numbers);
        int answer = 0;
        for(long i : numbers)
            if(isPrime(i))
                answer += 1;

        return answer;
    }

    public static boolean isPrime(long x) {

        if(x<2)
            return false;

        long range = (long) Math.sqrt(x) + 1;
        for(int i=2; i<range; i++){
            if(x%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(solution(437674, 3)); //	3
        System.out.println(solution(110011, 10)); // 2

    }
}
