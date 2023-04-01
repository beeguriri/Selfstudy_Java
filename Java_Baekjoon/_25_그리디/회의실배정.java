package Java_Baekjoon._25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정 {

    /*첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
    둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데
    이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
    첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다. */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] times = new int [n][2];

        for(int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //종료시간 기준 오름차순
                //종료시간이 같으면 시작시간 기준 오름차순
                return o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0];
            }
        });

        //System.out.println(Arrays.deepToString(times));

        int endT = times[0][1];
        int cnt = 1;

        for(int i = 1; i < n; i++) {

            if(times[i][0] >= endT) {
                endT = times[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }

}
