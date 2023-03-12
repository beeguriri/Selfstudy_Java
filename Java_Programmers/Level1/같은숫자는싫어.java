package Java_Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 같은숫자는싫어 {
    /*배열 arr가 주어집니다.
    배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
    이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
    단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.
    배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.*/

    public int[] solution(int []arr) {

        ArrayList<Integer> temp = new ArrayList<>();

        for(int i = 0; i<arr.length-1; i++) {
            int j = i+1;
            if(arr[i]!=arr[j])  temp.add(arr[i]);
        }
        temp.add(arr[arr.length-1]);

        int[] answer = new int [temp.size()];
        for(int i=0; i<temp.size(); i++)
            answer[i] = temp.get(i);

        return answer;
    }

    public static void main(String[] args) {
        같은숫자는싫어 a = new 같은숫자는싫어();

        System.out.println(Arrays.toString(a.solution(new int [] {1,1,3,3,0,1,1}))); //[1,3,0,1]
        System.out.println(Arrays.toString(a.solution(new int [] {4,4,4,3,3})));
    }

}
