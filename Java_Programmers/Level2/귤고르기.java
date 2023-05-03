package Java_Programmers.Level2;

import java.util.*;

public class 귤고르기 {

    public int solution(int k, int[] tangerine) {

        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : tangerine) {

            if(map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i,1);

        }

        int [] arr = map.values().stream().mapToInt(i->i).toArray();
        Arrays.sort(arr);

        int sum = 0;

        for(int i=arr.length-1; i>=0; i--) {

            sum += arr[i];

            if(sum >= k) {
                answer = arr.length - i;
                break;
            }
        }

        return answer;
    }
}
