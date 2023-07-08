package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 연속된부분수열의합 {

    public static int[] solution(int[] sequence, int k) {

        List<int[]> list = new ArrayList<>();

        int start = 0;
        int next = 0;
        int sum = sequence[start];

        while(start<=next && next<sequence.length) {

             if(sum==k) {
                 list.add(new int[]{start, next});
                 sum -= sequence[start++];
             }
             else if(sum>k) {
                 sum -= sequence[start++];
             } else {
                 next++;
                 if(next<sequence.length)
                    sum += sequence[next];
             }
        }

        list.sort((o1, o2) -> o1[1] - o1[0] == o2[1] - o2[0] ?
                                o1[0] - o2[0] :
                                (o1[1] - o1[0]) - (o2[1] - o2[0]));

        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int [] {1, 2, 3, 4, 5}, 7))); //[2, 3]
        System.out.println(Arrays.toString(solution(new int [] {1, 1, 1, 2, 3, 4, 5}, 5))); //[6, 6]
        System.out.println(Arrays.toString(solution(new int [] {2, 2, 2, 2, 2}, 6))); //[0, 2]
        System.out.println(Arrays.toString(solution(new int [] {2, 2, 2, 2, 2}, 2))); //[0, 0]
    }
}

