package Java_Programmers.Level2;

public class 두원사이의정수쌍 {

    public static long solution(int r1, int r2) {

        long answer = 0;
        long side = 0;

        for(int i=0; i<=r2; i++) {

            double y1 = Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));
            double y2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));

            if(y1%1==0)
                side++;

            answer += ((long)y2 - (long)y1)*4;

        };

        answer += (side*4 -4);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 3));
    }
}
