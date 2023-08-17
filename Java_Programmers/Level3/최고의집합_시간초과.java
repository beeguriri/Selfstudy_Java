package Java_Programmers.Level3;

import java.util.Arrays;

public class 최고의집합_시간초과 {

    public static int [] numbers;
    public static int [] result;
    public static int [] answer;
    public static int max = 0;
    public static int target;

    public static void comb(int depth, int start, int n, int sum) {

        //종료조건 1
        if(sum>target)
            return;

        //종료조건 2
        if(depth==n){
            //계산
            int total = 1;

            if(Arrays.stream(result).sum()!=target)
                return;

            for(int i : result)
                total *= i;

            max = Math.max(max, total);

            if(max==total)
                answer = result.clone();

            return;
        }

        for(int i=start; i<=numbers.length/2; i++){
            result[depth] = numbers[i];
            comb(depth+1, start, n, sum+numbers[i]);
        }
    }

    public static int[] solution(int n, int s) {

        answer = new int [n];
        result = new int [n];
        numbers = new int [s];
        target = s;

        for(int i=0; i<numbers.length; i++)
            numbers[i] = i+1;

        max = 0;
        comb(0, 0, n, 0);

        if(max==0)
            return new int [] {-1};

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));
        System.out.println(Arrays.toString(solution(2, 1)));
        System.out.println(Arrays.toString(solution(2, 8)));
    }
}
