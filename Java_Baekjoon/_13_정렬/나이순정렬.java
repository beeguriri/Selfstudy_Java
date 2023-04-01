package Java_Baekjoon._13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나이순정렬 {

    /* 회원들을 나이가 증가하는 순으로,
    나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
    첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
    둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String[]> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String [] s = br.readLine().split(" ");
            list.add(s);
        }
//        for(int i=0; i<n; i++)
//            System.out.print(Arrays.toString(list.get(i)) + " ");

        Collections.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int a = Integer.parseInt(o1[0]);
                int b = Integer.parseInt(o2[0]);

                if(a>b) return 1;
                else if (a<b) return -1;
                else return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++)
            sb.append(list.get(i)[0]).append(" ").append(list.get(i)[1]).append("\n");

        System.out.println(sb);
    }
}
