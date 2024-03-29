package Java_Baekjoon._14_집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 문자열집합 {

    /*첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다.
    다음 N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.
    다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.
    입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다.
    집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.
    첫째 줄에 M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력한다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int m = Integer.parseInt(s.split(" ")[1]);

        Set<String> set = new HashSet<>();
        for(int i=0; i<n; i++)
            set.add(br.readLine());

        int cnt = 0;
        for(int i=0; i<m; i++){
            s = br.readLine();
            if(set.contains(s))
                cnt++;
        }

        System.out.println(cnt);
    }
}
