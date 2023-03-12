package Java_Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 제일작은수제거하기 {

    /*정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수,
     solution을 완성해주세요.
     단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
     예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고,
     [10]면 [-1]을 리턴 합니다.*/

    public int[] solution(int[] arr) {

        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<arr.length; i++) temp.add(arr[i]);

        int[] answer = new int [arr.length==1?1:arr.length-1];
        int min = arr[0];

        if(arr.length==1) answer[0] = -1;
        else {
            //최소값 찾기
            for(int i = 0; i<arr.length; i++)
                min = Math.min(arr[i],min);

            //최소값 제거
            temp.remove(temp.indexOf(min));

            //배열로 반환
            for(int i = 0; i<answer.length; i++)
                answer[i] = temp.get(i);

        }
        return answer;
    }

    public static void main(String[] args) {
        제일작은수제거하기 a = new 제일작은수제거하기();

        //int [] arr1 = {4,3,2,1};
        int [] arr1 = {4,-1, 3, 0, 2,1};
        System.out.println(Arrays.toString(a.solution(arr1))); //[4,3,2]

        int [] arr2 = {10};
        System.out.println(Arrays.toString(a.solution(arr2)));  //[-1]
    }
}
