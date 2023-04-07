package Java_Baekjoon._13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.max;
import static java.util.Collections.min;

public class 통계학 {

    /*첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
    단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다.
    입력되는 정수의 절댓값은 4,000을 넘지 않는다.
    첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
    둘째 줄에는 중앙값을 출력한다.
    셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
    넷째 줄에는 범위를 출력한다.(N개의 수들 중 최댓값과 최솟값의 차이) */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++)
            list.add(Integer.parseInt(br.readLine()));

        StringBuilder sb = new StringBuilder();

        float sum = 0;
        float avg = 0;
        for(int i : list)
            sum += i;

        if(sum>0)
            avg = Math.round(sum/n);
        else
            avg = Math.round(Math.abs(sum)/n) * -1;

        sb.append((int)avg).append("\n");

        Collections.sort(list);
        sb.append(list.get(n/2)).append("\n");


        //최빈값 구하기
        int cntMax = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            if (!map.containsKey(list.get(i)))
                map.put(list.get(i), 1);
            else
                map.put(list.get(i), map.get(list.get(i)) + 1);
        }

        for(int i=0; i<n; i++)
            cntMax = Math.max(cntMax,map.get(list.get(i)));

        List<Integer> list2 = new ArrayList<>();
        for(int i : map.keySet())
            if(map.get(i)==cntMax)
                list2.add(i);

        Collections.sort(list2);

        if(list2.size()>=2)
            sb.append(list2.get(1)).append("\n");
        else
            sb.append(list2.get(0)).append("\n");

        sb.append(max(list)-min(list));
        System.out.println(sb);

    }

}
