package Java_Baekjoon._14_집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class 듣보잡 {

    /*첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
     이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.
    듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.
    듣보잡의 수와 그 명단을 사전순으로 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int m = Integer.parseInt(s.split(" ")[1]);

        Set<String> set1 = new TreeSet<>();
        Set<String> set2 = new TreeSet<>();
        for(int i=0; i<n; i++)
            set1.add(br.readLine());
        for(int i=0; i<m; i++)
            set2.add(br.readLine());

        set1.retainAll(set2);
        String [] setArr = set1.toArray(new String[0]);

        StringBuilder sb = new StringBuilder();
        sb.append(set1.size()).append("\n");
        for(String set : setArr)
            sb.append(set).append("\n");

        System.out.println(sb);

    }
}
