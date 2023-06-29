package Java_Baekjoon._23_동적계획법.복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴바이토닉부분수열 {

    public static int n;
    public static int [] ldp;
    public static int [] rdp;
    public static int [] arr;

    //왼쪽-> 오른쪽으로 증가
    public static void ldp() {
        for(int i=0; i<n; i++){
            ldp[i] = 1;
            for(int j=0; j<i; j++)
                if(arr[j]<arr[i])
                    ldp[i] = Math.max(ldp[i], ldp[j]+1);
        }
    }

    //오른쪽 -> 왼쪽으로 증가
    public static void rdp() {
        for(int i=n-1; i>=0; i--){
            rdp[i] = 1;
            for(int j=n-1; j>i; j--)
                if(arr[j]<arr[i])
                    rdp[i] = Math.max(rdp[i], rdp[j]+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ldp = new int [n];
        rdp = new int [n];
        arr = new int [n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        ldp();
        System.out.println(Arrays.toString(ldp));
        rdp();
        System.out.println(Arrays.toString(rdp));

        int max=0;
        for(int i=0; i<n; i++)
            max = Math.max(max, ldp[i]+rdp[i]);

        System.out.println(max-1);

    }

}
