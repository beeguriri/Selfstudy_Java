package Java_Baekjoon._17_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 암호만들기 {

    /*암호는 서로 다른 L개의 알파벳 소문자들로 구성되며
    최소 한 개의 모음(a, e, i, o, u)과
    최소 두 개의 자음으로 구성되어 있다고 알려져 있다. */

    public static List<String> list = new ArrayList<>();
    public static String [] arr;
    public static int n, r;
    public static StringBuilder sb = new StringBuilder();


    public static void combination(int idx, int m) {

        if(m==0) {

            StringBuilder temp = new StringBuilder();
            int vowelCount = 0;

            for(String s : list) {
                temp.append(s);
                if(s.equals("a")||s.equals("e")||s.equals("i")||s.equals("o")||s.equals("u"))
                    vowelCount++;
            }
            int len = r-vowelCount;
            if(vowelCount >=1 && len >=2)
                sb.append(temp).append("\n");
        }

        for(int i=idx; i<n; i++){
            list.add(arr[i]);
            combination(i+1, m-1);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new String [n];
        for(int i=0; i<n; i++)
            arr[i] = st.nextToken();

        Arrays.sort(arr);
        combination(0,r);
        System.out.print(sb);

    }
}
