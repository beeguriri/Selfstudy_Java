package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 할인행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        List<String> list = new ArrayList<>();
        for (int i = 0; i < want.length; i++)
            for(int j=1; j<=number[i]; j++)
                list.add(want[i]);

        Collections.sort(list);
//        System.out.println(list);

        for(int i=0; i<=discount.length-10; i++) {
            String [] temp = Arrays.copyOfRange(discount, i, i+10);
            Arrays.sort(temp);
//            System.out.println(Arrays.toString(temp));

            int cnt = 0;
            for (int j = 0; j < list.size(); j++) {
                if(!list.get(j).equals(temp[j]))
                    break;
                else
                    cnt += 1;
            }
            if(cnt==10)
                answer += 1;
        }

        return answer;
    }

    public static void main(String[] args) {

        할인행사 a = new 할인행사();

        String [] want = {"banana", "apple", "rice", "pork", "pot"};
        int [] number = {3, 2, 2, 2, 1};
        String [] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(a.solution(want, number, discount));

    }

}
