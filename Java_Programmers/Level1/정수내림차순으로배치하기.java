package Java_Programmers.Level1;

import java.util.Arrays;
import java.util.Collections;

public class 정수내림차순으로배치하기 {
    /* 함수 solution은 정수 n을 매개변수로 입력받습니다.
    n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
    예를들어 n이 118372면 873211을 리턴하면 됩니다.
    * */
    public long solution(long n) {
        String[] sArr = String.valueOf(n).split("");
        Arrays.sort(sArr, Collections.reverseOrder());

        String temp ="";

        for(String s : sArr)
            temp += s;

        return Long.parseLong(temp);
    }

    public static void main(String[] args) {
        정수내림차순으로배치하기 a = new 정수내림차순으로배치하기();

        System.out.println(a.solution(118372));
    }
}
