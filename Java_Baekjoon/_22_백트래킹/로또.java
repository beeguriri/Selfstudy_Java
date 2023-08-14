package Java_Baekjoon._22_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 로또 {

    // 첫 번째 수는 k (6 < k < 13)이고,
    // 다음 k개 수는 집합 S에 포함되는 수이다.
    // S의 원소는 오름차순으로 주어진다.
    // 입력의 마지막 줄에는 0이 하나 주어진다.
    // k개 에서 "6개 고르는 경우"의 수 모두 출력

    static StringBuilder sb = new StringBuilder();
    static int k;
    static int [] numbers;
    static boolean [] check;

    public static void dfs(int depth, int start){

        //dfs 종료조건
        if(depth==6){
            for(int i=0; i<k; i++)
                if(check[i])
                    sb.append(numbers[i]).append(" ");

            sb.append("\n");
            return;
        }

        //앞에서부터 차례대로 구해야되므로 조합으로 접근
        for(int i=start; i<k; i++){
            check[i] = true;
            dfs(depth+1, i+1);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            String s = br.readLine();
            if(s.equals("0"))
                break;

            String [] temp = s.split(" ");
            k = Integer.parseInt(temp[0]);
            check = new boolean[k];
            numbers = new int [k];

            for(int i=0; i<k; i++)
                numbers[i] = Integer.parseInt(temp[i+1]);

            dfs(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
