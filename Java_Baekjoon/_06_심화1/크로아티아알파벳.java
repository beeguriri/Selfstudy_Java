package Java_Baekjoon._06_심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 크로아티아알파벳 {

    public static void main(String[] args) throws IOException {

        String [] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;

        for(String c : cro){
            if(str.contains(c)){
                int len = str.length();
                str = str.replace(c," ");
                if(c.equals("dz="))
                    cnt += (len - str.length())/2;
                else
                    cnt += len - str.length();
            }
        }

        str = str.replace(" ", "");
        cnt += str.length();
        System.out.println(cnt);

    }
}
