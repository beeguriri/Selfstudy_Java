package Java_Baekjoon._13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 좌표정렬하기2 {

    /*첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
    둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
    (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
    좌표를 y좌표가 증가하는 순으로,
    y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
    첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [][] arr = new int [n][2];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            arr[i][0] = Integer.parseInt(str.split(" ")[0]);
            arr[i][1] = Integer.parseInt(str.split(" ")[1]);
        }

        Arrays.sort(arr, (o1,o2) -> (o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0]));

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <n; i++)
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");

        System.out.println(sb);

    }
}
