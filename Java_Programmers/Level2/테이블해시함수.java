package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 테이블해시함수 {

    public static int solution(int[][] data, int col, int row_begin, int row_end) {

        //테이블의 튜플을 col번째 컬럼의 값을 기준으로 오름차순 정렬하되
        //값이 동일하면 기본키인 첫번째 컬럼의 값을 기준으로 내림차순 정렬
        Arrays.sort(data,
                (o1, o2) -> o1[col-1] != o2[col-1] ?
                        o1[col-1] - o2[col-1] : o2[0] - o1[0]);

        //S_i = i번째 행의 튜플에 대해 각 컬럼의 값을 i로 나눈 나머지의 합
        List<Integer> result = new ArrayList<>();
        for(int i=row_begin-1; i<=row_end-1; i++) {
            int sum = 0;
            for(int j=0; j<data[0].length; j++)
                sum += (data[i][j] % (i+1));
            result.add(sum);
        }

        //XOR 누적
        int answer = 0;
        for(int i : result)
            answer ^= i;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int [][] {{2,2,6},{1,5,10},{4,2,9},{3,8,3}}, 2, 2, 3)); //4
    }
}
