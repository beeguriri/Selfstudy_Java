package Java_Programmers.Level1;

import java.util.*;

public class 두개뽑아서더하기 {

    /*정수 배열 numbers가 주어집니다.
    numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를
    배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
     */

    public int[] solution(int[] numbers) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0 ; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().sorted().mapToInt(i -> i).toArray();

//        ArrayList<Integer> list = new ArrayList<Integer>(set);
//        Collections.sort(list);
//        int [] answer = new int [list.size()];
//        for (int i = 0; i<answer.length; i++)
//            answer[i] = list.get(i);
//
//        return answer;
    }
    public static void main(String[] args) {

        두개뽑아서더하기 a = new 두개뽑아서더하기();
        int [] num1 = {2,1,3,4,1};
        System.out.println(Arrays.toString(a.solution(num1))); //[2,3,4,5,6,7]

        //[5,0,2,7]	[2,5,7,9,12]
    }
}
