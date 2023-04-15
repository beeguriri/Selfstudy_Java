package Java_Baekjoon._25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 신입사원 {

    /*첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다.
    각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다.
    둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다.
    두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tCase = Integer.parseInt(br.readLine());
        for(int t=0; t<tCase; t++){

            int n = Integer.parseInt(br.readLine());
            int [][] arr = new int [n][2];

            StringTokenizer st;
            for(int i=0; i<n; i++) {
                 st = new StringTokenizer(br.readLine());
                 arr[i][0] = Integer.parseInt(st.nextToken());
                 arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]<o2[0]?-1:1;
                }
            });

            System.out.println(Arrays.deepToString(arr));

            int cnt = 1; //제일 마지막행은 항상 답
            int pass = arr[0][1];

            for(int i=1; i<n; i++){
                if(arr[i][1] < pass) {
                    pass = arr[i][1];
                    cnt++;
                }
            }

            System.out.println(cnt);

        }
    }
}
