package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 줄서는방법 {

    public static int[] solution(int n, long k) {
        int[] answer = new int [n];
        long fact = 1;
        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=n; i++){
            fact *= i;
            list.add(i);
        }

        int idx = 0;
        k = k-1; //배열 인덱스는 0부터 시작

        while(n>0) {
            //단위개수 구하기
            fact /= n;

            //각 자리수 찾기
            answer[idx++] = list.get((int)(k/fact)); //list_idx = 4/2 = 2;
            list.remove((int)(k/fact));

            //다음순번
            k %= fact;
            n--;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 5))); //[3,1,2]
    }
}
