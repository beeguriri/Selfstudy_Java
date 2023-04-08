package Java_이코테._05이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품찾기 {

    /*첫번째줄에 가지고있는 부품 개수 n
    * 두번째 줄에 n개의 부품목록
    * 세번째 줄에 손님이 찾는 부품 개수 m
    * 네번째 줄에 m개의 부품목록
    * 있으면 "yes" 없으면 "no" 출력 */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] parts = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            parts[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int [] buy = new int [m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
            buy[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(parts);

        for(int i: buy){
            int result = Arrays.binarySearch(parts, i);
            if(result>0)
                System.out.print("yes ");
            else
                System.out.print("no ");
        }
    }
}
