package Java_Baekjoon.구현;

import java.util.Scanner;

public class 분수찾기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int line = 0;
        int count = 0;
        int top = 0;
        int bottom = 0;

        while(count<n){
            line++;
            count = line*(line+1) / 2; //등차수열
            System.out.println("line = " + line);
            System.out.println("count = " + count);
        }

        //라인수가 짝수이면
        if(line%2==0) {
            top = line + n - count;
            bottom = 1 + count - n;
        }
        //라인수가 홀수이면
        else {
            top = 1 + count - n;
            bottom = line + n - count;
        }

        System.out.println(top + "/" + bottom);

    }

}
