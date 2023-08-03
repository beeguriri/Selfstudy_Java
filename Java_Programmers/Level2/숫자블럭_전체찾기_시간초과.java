package Java_Programmers.Level2;

import java.util.Arrays;

public class 숫자블럭_전체찾기_시간초과 {

    //testcase 13번 시간초과
    //효율성테스트 메모리 초과
    public static int[] solution(long begin, long end) {

        int[] result = new int [(int)end+1];

        for(int i=1; i<=end/2; i++) {
            for(int j=i*2; j<=end; j+=i){
                result[j] = i;
            }
        }

        int [] answer = new int [(int)end - (int)begin + 1];
        for(int i=0; i<answer.length; i++) {
            answer[i] = result[(int)begin++];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(1, 10)));
    }
}
