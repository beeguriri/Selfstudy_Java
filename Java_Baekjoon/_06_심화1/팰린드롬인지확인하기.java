package Java_Baekjoon._06_심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬인지확인하기 {

    /*알파벳 소문자로만 이루어진 단어가 주어진다.
    이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.
    팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String rev = "";

        for(char c : str.toCharArray())
            rev = c + rev;

        if(str.equals(rev))
            System.out.println("1");
        else
            System.out.println("0");
    }
}
