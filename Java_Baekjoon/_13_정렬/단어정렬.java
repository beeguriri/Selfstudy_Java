package Java_Baekjoon._13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 단어정렬 {

    /*길이가 짧은 것부터 길이가 같으면 사전 순으로
    * 단, 중복된 단어는 하나만 남기고 제거해야 한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++)
            set.add(br.readLine());

        String [] arr = set.toArray(String[]::new);

        Arrays.sort(arr, (o1, o2) -> {

            if (o1.length() > o2.length())
                return 1;
            else if (o1.length() < o2.length())
                return -1;
            else
                return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for(String s : arr)
            sb.append(s).append("\n");

        System.out.println(sb);



    }
}
