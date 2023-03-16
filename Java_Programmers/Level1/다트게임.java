package Java_Programmers.Level1;

import com.sun.tools.javac.Main;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 다트게임 {
    /*점수|보너스|[옵션]"으로 이루어진 문자열 3세트
    *점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고
    * 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
    * 옵션으로 스타상(*) , 아차상(#)이 존재하며
    * 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
    *  아차상(#) 당첨 시 해당 점수는 마이너스된다.
    * */

    public int solution(String dartResult) {
        int answer = 0;
        int idx = 0;
        int[] dart = new int[3];
        String num = "";

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (c >= '0' && c <= '9') {
                num += String.valueOf(c);
            } else if (c == 'S' || c == 'D' || c == 'T') {
                if (c == 'S')
                    dart[idx++] = Integer.parseInt(num);
                else if (c == 'D')
                    dart[idx++] = (int) Math.pow(Integer.parseInt(num), 2);
                else
                    dart[idx++] = (int) Math.pow(Integer.parseInt(num), 3);
                num = "";
            } else {
                if (c == '*') {
                    dart[idx - 1] *= 2;
                    if (idx - 2 >= 0) dart[idx - 2] *= 2;
                } else {
                    dart[idx - 1] *= -1;
                }
            }
        }
        answer = dart[0] + dart[1] + dart[2];
        return answer;
    }

    public static void main(String[] args) {

        다트게임 a = new 다트게임();

        System.out.println(a.solution("1S2D*3T")); //37
        System.out.println(a.solution("1D2S#10S")); //9
        System.out.println(a.solution("1D2S0T"));   //3
        System.out.println(a.solution("1S*2T*3S")); //23
        System.out.println(a.solution("1D#2S*3S")); //5
        System.out.println(a.solution("1T2D3D#"));  //-4
        System.out.println(a.solution("1D2S3T*")); //59
    }
}
