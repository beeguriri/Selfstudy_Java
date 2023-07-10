package Java_Programmers.Level2;

import java.util.Arrays;

public class _2개이하로다른비트 {

    public static long[] solution(long[] numbers) {

        long[] answer = new long [numbers.length];

        for(int i=0; i<numbers.length; i++) {

            //짝수이면 1을 더해줌
            if(numbers[i]%2==0)
                answer[i] = numbers[i]+1;

            //홀수이면
            //제일 처음 나오는 0을 1로, 그다음 자리의 1을 0으로 바꿔줌
            //0이 없으면 제일 처음 자리를 10으로, 나머지는 원래 숫자로 채워줌
            else {
                String now = Long.toString(numbers[i], 2);
                if(!now.contains("0"))
                    now = now.replaceFirst("1", "10");
                else {
                    int idx = now.lastIndexOf("0");
                    now = now.substring(0, idx) + "10" + now.substring(idx + 2);
                }
                answer[i] = Long.parseLong(now, 2);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long [] {2, 7}))); // 3, 11
        System.out.println(Arrays.toString(solution(new long [] {1001,337,0,1,333,673,343,221,898,997,121,1015,665,779,891,421,222,256,512,128,100})));
        //[1002, 338, 1, 2, 334, 674, 347, 222, 899, 998, 122, 1019, 666, 781, 893, 422, 223, 257, 513, 129, 101]

    }
}
