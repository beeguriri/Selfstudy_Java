package Java_Baekjoon._05_문자열;

import java.io.*;

public class 그대로출력하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str="";
        while((str=br.readLine())!=null) {
            System.out.println(str);
        }
    }
}
