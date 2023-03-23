package Java_Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OX퀴즈 {

    /*"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다.
    O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
    문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다.
    예를들어 "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
    OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
    입력 : 첫째 줄에 테스트 케이스의 개수가 주어진다.
    각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다.
    문자열은 O와 X만으로 이루어져 있다.
    출력 : 각 테스트 케이스마다 점수를 출력한다.*/


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); //케이스의 갯수
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<num; i++) {

            String str = br.readLine();
            int score = 1;
            int sum = 0;

            if(str.charAt(0)=='O')
                sum = 1;


            for(int j = 1; j<str.length(); j++) {

                if(str.charAt(j-1)=='O'&&str.charAt(j)=='O'){
                    score +=1;
                    sum += score;
                } else if (str.charAt(j)=='O') {
                    sum += 1;
                } else score = 1;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
        //OOXXOXXOOO => 10
        //OOXXOOXXOO => 9
        //OXOXOXOXOXOXOX => 7
        //OOOOOOOOOO => 55
        //OOOOXOOOOXOOOOX => 30

        
    }
}
