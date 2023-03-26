package Java_Baekjoon._06_심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룹단어체커 {

    /*그룹 단어란 단어에 존재하는 모든 문자에 대해서,
    각 문자가 연속해서 나타나는 경우만을 말한다.
    첫째 줄에 단어의 개수 N이 들어온다.
    N은 100보다 작거나 같은 자연수이다.
    둘째 줄부터 N개의 줄에 단어가 들어온다.
    단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
    첫째 줄에 그룹 단어의 개수를 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 0; i < n; i++){
            String str = br.readLine();

            if(str.length()==1 || str.length()==2) {
                answer++;
                continue;
            }

            boolean [] check = new boolean[26];
            check[str.charAt(0)-'a'] = true;
            int cnt = 1;

            for(int j = 1; j<str.length(); j++) {
                char c = str.charAt(j);

                if(c!=str.charAt(j-1) && check[c-'a'])
                    break;
                else
                    check[c-'a'] = true;

                cnt++;
            }
            if(cnt == str.length()) answer++;
        }
        System.out.println(answer);
    }
}
