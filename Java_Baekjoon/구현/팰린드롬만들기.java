package Java_Baekjoon.구현;

import java.util.Scanner;

public class 팰린드롬만들기 {

    //팰린드롬의 구성
    //글자수가 홀수인 알파뱃이 0개
    // => 알파뱃 순회하면서 개수/2 만큼 붙여줌
    // => 붙여준거 역순으로 더해주기
    //글자수가 홀수인 알파뱃이 1개
    // => 알파뱃 순회하면서 개수/2 만큼 붙여줌
    // => 홀수인 알파뱃 붙이기
    // => 붙여준거 역순으로 더해주기
    //글자수가 홀수인 알파뱃이 2개이상 => 팰린드롬 불가

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char [] charArray = s.toCharArray();
        int [] countChar = new int [26];

        //(int)'A' == 65
        for(char c : charArray)
            countChar[c - 'A']++;

        //홀수개 글자수 체크
        int count = 0;
        for(int i : countChar)
            if(i%2!=0)
                count++;

        String answer = "I'm Sorry Hansoo";
        StringBuilder sb = new StringBuilder();
        if(count==0){
            //첨부터 붙여주고 거꾸로 다시 붙여주기
            for(int i=0; i<countChar.length; i++) {
                if(countChar[i]!=0) {
                    for (int j=0; j<countChar[i]/2; j++)
                        sb.append((char) (i+'A'));
                }
            }
            for(int i=countChar.length-1; i>=0; i--) {
                if(countChar[i]!=0) {
                    for (int j=0; j<countChar[i]/2; j++)
                        sb.append((char) (i+'A'));
                }
            }
            answer = sb.toString();

        } else if(count==1){
            //첨부터 붙여주고 홀수개 1개 글자 붙인 후 거꾸로 붙이기
            char mid = 'A';
            for(int i=0; i<countChar.length; i++) {
                if(countChar[i]!=0) {
                    for (int j=0; j<countChar[i]/2; j++)
                        sb.append((char) (i+'A'));
                }
                if(countChar[i]%2!=0)
                    mid = (char)(i+'A');
            }

            sb.append(mid);

            for(int i=countChar.length-1; i>=0; i--) {
                if(countChar[i]!=0) {
                    for (int j=0; j<countChar[i]/2; j++)
                        sb.append((char) (i+'A'));
                }
            }
            answer = sb.toString();
        }

        System.out.println(answer);
    }
}
