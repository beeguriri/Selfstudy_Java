package Java_Baekjoon._11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 날짜계산 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int countE = 1;
        int countS = 1;
        int countM = 1;
        int answer = 1;

        // (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
        while(true){

            if(countE>15)
                countE=1;

            if(countS>28)
                countS=1;

            if(countM>19)
                countM=1;

            if(countE==E && countS==S && countM==M)
                break;

            countE++;
            countS++;
            countM++;
            answer++;
        }

        System.out.println(answer);
    }
}
