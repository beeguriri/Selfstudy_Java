package Java_Programmers.Level2;

import java.util.*;

public class 구명보트 {

    public int solution(int[] people, int limit) {

        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;
        int count = 0;
        int sum = 0;

        while(start<=end){

            sum = people[start] + people[end];

            if(sum<=limit) {
                count++;
                start++;
                end--;

            } else {
                count++;
                end--;

            }
        }


        return count;
    }
}
