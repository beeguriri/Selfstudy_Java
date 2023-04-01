package Java_Baekjoon._13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좌표압축_v2 {

    /*수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다.
    Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
    첫째 줄에 N이 주어진다.
    둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
    첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] input = new int [n];
        int [] sortInput = new int [n]; //key : value(순위)

        for(int i=0; i<n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            sortInput[i] = input[i];
        }
        Arrays.sort(sortInput);

        Map<Integer, Integer> map = new HashMap<>();

        int v = 0;
        for(int i=0; i<n; i++){
            if(!map.containsKey(sortInput[i]))
                map.put(sortInput[i], v++);
        }
        System.out.println(map);

        StringBuilder sb = new StringBuilder();
        for(int i : input)
            sb.append(map.get(i)).append(" ");

        System.out.println(sb);


    }
}
