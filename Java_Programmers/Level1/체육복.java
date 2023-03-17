package Java_Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.reverseOrder;

public class 체육복 {

    /*전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
    여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
    체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.*/

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        ArrayList<Integer> temp = new ArrayList<>();
        for (int x : reserve)
            temp.add(x);

        Arrays.sort(lost);
        temp.sort(reverseOrder());

        answer = n - lost.length;

        //중복 먼저 제거
        for (int i = 0; i<lost.length; i++) {
            for (int j = temp.size()-1; j>=0; j--) {
                if(temp.contains(lost[i])){
                    answer += 1;
                    temp.remove(temp.indexOf(lost[i]));
                    lost[i]= -1;
                    break;
                }
            }
        }

        for (int i=0; i<lost.length; i++) {
            for (int j=temp.size()-1; j>=0; j--) {
                if (temp.get(j)==lost[i]-1 || temp.get(j)==lost[i]+1) {
                    answer += 1;
                    temp.remove(j);
                    break;
                }
            }
        }

            return answer;
    }

    public static void main(String[] args) {
        체육복 a = new 체육복();

        System.out.println(a.solution(5, new int [] {2, 4}, new int [] {1, 3, 5})); //5
        System.out.println(a.solution(5, new int [] {2, 4}, new int [] {3})); //4
        System.out.println(a.solution(3, new int [] {3}, new int [] {1}));  //2
        System.out.println(a.solution(8, new int [] {5, 6, 7}, new int [] {4, 5}));//6

    }
}
