package Java_Baekjoon._22_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기 {

    public static int L, C;
    public static String [] dict;
    public static boolean [] check;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int start, int depth) {

        //dfs 종료조건
        if(depth == L) {
            //조건에 맞으면 출력
            StringBuilder temp = new StringBuilder();
            int countV = 0;
            for(int i=0; i<check.length; i++) {
                if(check[i]) {
                    String s = dict[i];
                    if(isVowel(s))
                        countV++;

                    temp.append(s);
                }
            }

            int countC = L - countV;

            if(countV>=1 && countC>=2)
                sb.append(temp).append("\n");

            return;
        }

        for(int i=start; i<C; i++) {
            if(!check[i]) {
                check[i] = true;
                dfs(i+1, depth+1);
                check[i] = false;
            }
        }
    }

    public static boolean isVowel(String s) {
        return s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dict = new String[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++)
            dict[i] = st.nextToken();

        Arrays.sort(dict);
        check = new boolean[C];
        dfs(0, 0);

        System.out.print(sb);
    }
}
