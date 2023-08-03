package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 숫자블럭 {

    public static final int MAX = 10_000_000;

    public static int[] solution(long begin, long end) {
        int[] answer = new int [(int)end - (int)begin +1];

        for(int i = (int)begin; i<=end; i++)
            answer[i-(int)begin] = calcNum(i);

        return answer;
    }

    public static int calcNum(int x) {

        List<Integer> list = new ArrayList<>();

        if(x==1)
            return 0;

        //제한조건 잘 보기
        for(int i=2; i<=Math.sqrt(x); i++) {
            if(x%i==0) {
                list.add(i);
                if(x/i<=MAX)
                    return x/i;
            }
        }

        //소수 일 경우는 1 리턴
        return list.size()==0 ? 1 : list.get(list.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(11, 20)));
        //[begin, end] = [100000014, 100000016] 를 테스트했을 때, [6, 5, 6250001]
        System.out.println(Arrays.toString(solution(100000014, 100000016)));
    }
}
