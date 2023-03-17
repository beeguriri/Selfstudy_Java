package Java_Programmers.Level1;

import java.util.Arrays;
import java.util.Collections;

public class 숫자짝꿍 {

    /*두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여
    만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
    (단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).
    X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다.
    X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.*/

    public String solution(String X, String Y) {
        String answer ="";
        int cnt = 0;

        String [] xarr = X.split("");
        String [] yarr = Y.split("");

        Arrays.sort(xarr);
        Arrays.sort(yarr);

        //런타임에러(6.7.8.9.10), 시간초과
        for(int i = 0; i< xarr.length; i++){
            for(int j = 0; j<yarr.length; j++) {
                if(xarr[i].equals(yarr[j])) {
                    cnt++;
                    yarr[j] = "";
                    answer += xarr[i];
                    break;
                }
            }
        }

        if (cnt==0) return "-1";

        if (Integer.parseInt(answer)==0) return "0";

        String [] temp = answer.split("");
        Arrays.sort(temp, Collections.reverseOrder());
        String result = "";
        for(String s : temp)
            result += s;

        return result;
    }
    public static void main(String[] args) {
        숫자짝꿍 a = new 숫자짝꿍();

        System.out.println(a.solution("100", "2345")); //-1
        System.out.println(a.solution("100","203045")); //0
        System.out.println(a.solution("100","123450")); //10
        System.out.println(a.solution("12321","42531")); //321
        System.out.println(a.solution("5525", "1255")); //552
    }
}
