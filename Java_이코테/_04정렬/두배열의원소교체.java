package Java_이코테._04정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 두배열의원소교체 {

    /*최대 k번의 바꿔치기 연산을 수행해 만들 수 있는 배열 A의 모든 원소의 합의 최댓값 출력*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int sum = 0;

        Integer[] arrA = new Integer [n];
        Integer[] arrB = new Integer [n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arrA[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arrB[i] = Integer.parseInt(st.nextToken());

        //A의 최소값들과
        //B의 최대값들을 교환한다
        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        for(int i=0; i<k; i++) {
            if (arrA[i] < arrB[i])
                arrA[i] = arrB[i];
            else
                break;
        }

        for(int i : arrA)
            sum += i;

        System.out.println(sum);



    }
}
