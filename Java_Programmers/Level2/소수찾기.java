package Java_Programmers.Level2;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    public static Set<Integer> set;

    public static int solution(String numbers) {

        set = new HashSet<>();
        makeNumber("", numbers);
        System.out.println(set);

        return set.size();
    }

    public static void makeNumber(String comb, String others) {

        if(!comb.equals(""))
            if(isPrime(Integer.parseInt(comb)))
                set.add(Integer.parseInt(comb));

        for(int i=0; i<others.length(); i++)
            makeNumber(comb+others.charAt(i), others.substring(0,i) + others.substring(i+1));
    }

    public static boolean isPrime(int n) {

        if(n<=1)
            return false;

        for(int i=2; i<=Math.sqrt(n); i++)
            if(n%i==0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
}
