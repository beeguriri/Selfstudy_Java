package Java_Programmers.Level2;

import java.util.*;

public class 연속부분수열합의개수 {

    public static int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> set = new HashSet<>();

        for (int c=1; c<=n; c++) {
            for (int i=0; i<n; i++) {
                int sum = 0;
                for(int j=i; j<i+c; j++)
                    sum += elements[j%n];
                set.add(sum);
            }
        }

        System.out.println(set);

        return set.size();
    }

    public static void main(String[] args) {

        System.out.println(solution(new int [] {7,9,1,1,4}));
    }


}
