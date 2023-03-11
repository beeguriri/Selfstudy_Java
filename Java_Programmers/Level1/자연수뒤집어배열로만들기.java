package Java_Programmers.Level1;

import java.util.Arrays;

public class 자연수뒤집어배열로만들기 {
    /*자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
    예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
     */

    public int[] solution(long n) {
        String [] s = String.valueOf(n).split("");
        int[] answer = new int [s.length];
        for(int i = 0; i<s.length; i++)
            answer[i] = Integer.parseInt(s[s.length-1-i]);
        return answer;
    }

    public static void main(String[] args) {
        자연수뒤집어배열로만들기 a = new 자연수뒤집어배열로만들기();

        System.out.println(Arrays.toString(a.solution(12345)));
    }
}
