package Java_Programmers.Level2;

import java.util.*;

public class k진수에서소수개수구하기 {

    //코드개선
    public static int solution2(int n, int k) {

        String [] strings = Integer.toString(n, k)
                                    .replaceAll("0+", "0")
                                    .split("0");

        int answer = 0;
        for(String s : strings){
            long x = Long.parseLong(s);
            if(isPrime(x))
                answer += 1;
        }

        System.out.println(Arrays.toString(strings));

        return answer;

    }

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

        for(int i=2; i<=(long) Math.sqrt(x); i++){
            if(x%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

//        System.out.println(solution(437674, 3)); //	3
        System.out.println(solution2(437674, 3));
//        System.out.println(solution(110011, 10)); // 2
        System.out.println(solution(110011, 10));
    }
}
