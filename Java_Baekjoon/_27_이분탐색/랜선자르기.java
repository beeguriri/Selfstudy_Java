package Java_Baekjoon._27_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Collections.max;


public class 랜선자르기 {

    /*첫째 줄에는 가지고 있는 랜선의 개수 K, 그리고 필요한 랜선의 개수 N이 입력된다.
    K는 1이상 10,000이하의 정수이고, N은 1이상 1,000,000이하의 정수이다.
    그 후 K줄에 걸쳐 이미 가지고 있는 각 랜선의 길이가 센티미터 단위의 정수로 입력된다.
    랜선의 길이는 231-1보다 작거나 같은 자연수이다.
    첫째 줄에 N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력한다. */

    public static int binarySearch(int[] arr, int target, long start, long end){

        while(start<end){

            long mid = (start+end)/2;
            long cnt = 0;

            for(int i: arr)
                cnt += (i / mid);

            //개수가 중복일때 최대의 길이를 찾아야함
            // => upperbound
            if(cnt<target)
                end = mid;
            else
                start = mid + 1;
        }

        return (int) (start-1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Integer> lines = new ArrayList<>();

        for(int i=0; i<k; i++)
            lines.add(Integer.parseInt(br.readLine()));

        long lineMax = max(lines);

        System.out.println(binarySearch(lines.stream().mapToInt(i->i).toArray(), n, 0, lineMax+1));
    }
}
