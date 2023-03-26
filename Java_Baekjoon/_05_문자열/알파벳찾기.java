package Java_Baekjoon._05_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알파벳찾기 {

    /*알파벳 소문자로만 이루어진 단어 S가 주어진다.
    각각의 알파벳에 대해서,
    단어에 포함되어 있는 경우에는 처음 등장하는 위치를,
    포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int [] arr = new int [26];
        Arrays.fill(arr, -1);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<str.length(); i++) {
            int c = (int) str.charAt(i) - 'a';
            if(arr[c] != -1) continue;

            arr[c] = i;
        }

        for (int i : arr)
            sb.append(i).append(" ");

        sb.append("\n");
        System.out.println(sb);
    }
}
