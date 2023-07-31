package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이의탑 {

    public static List<int []> list = new ArrayList<>();

    //n=3일때,
    //start -> to
    //start -> mid
    //start -> mid
    //startd -> to (제일 큰 원판)
    //mid -> start (제일 작은 원판)
    //mid -> to (두번째 큰 원판)
    //start -> to (제일 작은 원판)

    public static int[][] solution(int n) {

        hanoi(n,1,2,3);

        int[][] answer = new int [list.size()][2];

        int idx =0;
        for(int [] i : list)
            answer[idx++] = i;

        return answer;
    }

    //start = 1, mid = 2, to = 3
    public static void hanoi(int n, int start, int mid, int to) {

        if(n==0)
            return;

        //n-1개를 1-> 2번 기둥으로 이동
        hanoi(n-1, start, to, mid);

        //제일 큰 원반을 1번 기둥으로 이동
        list.add(new int [] {start, to});

        //n-1개를 2 -> 3번 기둥으로 이동
        hanoi(n-1, mid, start, to);

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(2)));
    }
}
