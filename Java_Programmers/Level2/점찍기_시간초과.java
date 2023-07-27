package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class 점찍기_시간초과 {

    public static long answer;

    public static long solution(int k, int d) {

        List<Integer> input = new ArrayList<>();
        for(int i=0; i<=d; i+=k)
            input.add(i);

        permutation(input, new int [2], 0, input.size(), 2, d);

        return answer;
    }

    public static boolean calcDist(int x, int y, int d) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= d;
    }

    public static void permutation(List<Integer> input, int [] output, int depth, int n, int r, int d) {

        if(r==depth) {
            if(calcDist(output[0], output[1], d))
                answer++;
            return;
        }

        for(int i=0; i<n; i++) {
            output[depth] = input.get(i);
            permutation(input, output, depth+1, n, r, d);
        }
    }

    public static void main(String[] args) {
//        System.out.println(solution(2, 4));
        System.out.println(solution(1, 5));

    }
}
