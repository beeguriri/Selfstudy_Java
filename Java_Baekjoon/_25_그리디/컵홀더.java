package Java_Baekjoon._25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 컵홀더 {

    /*입력 : 첫째 줄에 좌석의 수 N이 주어진다. (1 ≤ N ≤ 50)
    둘째 줄에는 좌석의 정보가 주어진다.
    S는 일반 좌석, L은 커플석을 의미하며, L은 항상 두개씩 쌍으로 주어진다.
    출력 : 컵을 컵홀더에 놓을 수 있는 최대 사람의 수를 출력한다.
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine()); //좌석의 갯수
        //System.out.println("num : " + num);
        String sit = br.readLine(); //좌석배열을 나타내는 문자열
        //System.out.println("sit : " + sit);
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        for(int i = 0; i<num; i++) {
            if(sit.charAt(i)=='S') cnt++;
            else if(sit.charAt(i)=='L') {
                cnt++;
                i++;
            }
        }

        sb.append(Math.min(num,cnt));

        System.out.println(sb);

        //3, SSS => 3
        //4, SLLS => 4
        //9, SLLLLSSLL => 7
    }
}
