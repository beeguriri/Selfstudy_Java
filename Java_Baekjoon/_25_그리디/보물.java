package Java_Baekjoon._25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 보물 {

    /*S = A[0] × B[0] + ... + A[N-1] × B[N-1]
    * A에 있는 수를 재배열해서 S의 최솟값을 출력하는 프로그램
    * 첫째 줄에 N이 주어진다.
    * 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다.
    * N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> arrA = new ArrayList<>();
        for(int i = 0; i<n; i++)
            arrA.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        List<Integer> arrB = new ArrayList<>();
        for(int i = 0; i<n; i++)
            arrB.add(Integer.parseInt(st.nextToken()));

        Collections.sort(arrA);
//        System.out.println(arrA);

        arrB.sort(Collections.reverseOrder());
//        System.out.println(arrB);

        int answer = 0;
        for(int i =0; i<n; i++)
            answer += arrA.get(i) * arrB.get(i);

        System.out.println(answer);
    }
}
