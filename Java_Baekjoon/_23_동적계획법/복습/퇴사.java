package Java_Baekjoon._23_동적계획법.복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퇴사 {

    public static int n;
    public static int [] t;
    public static int [] p;
    public static int [] d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        t = new int [n+1];
        p = new int [n+1];
        d = new int [n+2];

        StringTokenizer st;
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++) {

            //오늘부터 상담기간을 합쳐서 퇴사일 이내일때만 상담 가능
            //퇴사일 : 오늘부터 N+1일째 되는 날
            if(i+t[i] <= n+1){
                d[i+t[i]] = Math.max(d[i+t[i]], d[i] + p[i]);
            }
            //상담 할 수 없을때는 다음날로 넘어가기
            d[i+1] = Math.max(d[i], d[i+1]);
        }

        System.out.println(Arrays.toString(d));
        System.out.println(d[n+1]);
    }
}
