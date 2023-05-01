package Java_Programmers.Level2;

import java.util.*;

public class 최솟값만들기 {

    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        // System.out.println(A.length);


        for(int i=0, j=B.length-1; i<A.length && j>=0; i++, j--) {

            answer += A[i] * B[j];

        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println(Arrays.toString(A));
        // System.out.println(Arrays.toString(B));

        return answer;
    }
}
