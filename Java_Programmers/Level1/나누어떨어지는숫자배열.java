package Java_Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 나누어떨어지는숫자배열 {
    /*array의 각 element 중 divisor로 나누어 떨어지는 값을
    오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
    divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.*/

    public int[] solution(int[] arr, int divisor) {

        ArrayList<Integer> temp = new ArrayList<>();
        Arrays.sort(arr);

        for (int i : arr) {
            if(i%divisor==0)
                temp.add(i);
        }

        int[] answer = new int [temp.size()==0?1:temp.size()];

        if(temp.size()==0) {
            answer[0] = -1;
            return answer;
        }

        for (int i = 0; i<temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        나누어떨어지는숫자배열 a = new 나누어떨어지는숫자배열();

        int [] arr1 = {5, 9, 7, 10};
        System.out.println(Arrays.toString(a.solution(arr1,5))); //[5, 10]

        int[] arr2 = {2, 36, 1, 3};
        System.out.println(Arrays.toString(a.solution(arr2,1))); //[1, 2, 3, 36]

        int[] arr3 = {3,2,6};
        System.out.println(Arrays.toString(a.solution(arr3,10))); //[-1]
    }

}
