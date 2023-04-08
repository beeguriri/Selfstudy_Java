package Java_이코테._05이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Collections.max;

public class 떡볶이떡만들기 {

    /*첫째줄에 떡의 개수 n과 절단한 떡의 길이의 합 m
    * 둘째 줄에 각 떡의 길이
    * 적어도 m 만큼의 떡을 가져가기위한 절단기의 최대 높이 구하기 */

    public static int binarySearch(int [] arr, int target, int start, int end){

        int result = 0;

        while(start <= end){

            int mid = (start + end) /2;
            long sum = 0;

            for(int i : arr)
                if(i > mid)
                    sum += (i - mid);

            //떡의 합이 target보다 작으면 왼쪽 탐색
            if(sum<target)
                end = mid - 1;
            //떡의 합이 target보다 크면 오른쪽 탐색
            else {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            list.add(Integer.parseInt(st.nextToken()));

        //4, 6
        //19, 15, 10, 17
        System.out.println(binarySearch(list.stream().mapToInt(i->i).toArray(), m, 0, max(list)));
        //15
    }

}
