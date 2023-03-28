package Java_Baekjoon._07_2차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세로읽기 {

    /*총 다섯줄의 입력이 주어진다. 각 줄에는 최소 1개, 최대 15개의 글자들이 빈칸 없이 연속으로 주어진다.
    주어지는 글자는 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’ 중 하나이다.
    각 줄의 시작과 마지막에 빈칸은 없다.
    영석이가 세로로 읽은 순서대로 글자들을 출력한다. 이때, 글자들을 공백 없이 연속해서 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [][] arr = new String[5][15];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 5; i++) {
            String s = br.readLine();
            for(int j = 0; j<s.length(); j++)
                arr[i][j] = s.substring(j,j+1);
        }

        for(int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < 5; j++) {
                if(arr[j][i]==null)
                    continue;
                if(!arr[j][i].equals(""))
                    sb.append(arr[j][i]);
            }
        }
        System.out.println(sb);

    }
}
