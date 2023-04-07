package Java_Baekjoon._13_정렬;

import javax.security.auth.Subject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 수찾기 {

    /*N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,
    이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
    첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
    다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
    다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
    다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
    모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
    M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        int [] arrA = new int [n];
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            set.add(Integer.parseInt(st.nextToken()));
//            arr[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int [] arrB = new int [m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
            arrB[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++){
            if(set.contains(arrB[i]))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
