package Java_Programmers.Level1;

import java.util.Arrays;

public class 당구연습 {

    /*당구대의 가로 길이 m, 세로 길이 n과
    머쓱이가 쳐야 하는 공이 놓인 위치 좌표를 나타내는 두 정수 startX, startY,
    공들의 위치 좌표를 나타내는 정수 쌍들이 들어있는 2차원 정수배열 balls가 주어집니다.
    "원쿠션" 연습을 위해 머쓱이가 공을 적어도 벽에 한 번은 맞춘 후 목표 공에 맞힌다고 할 때,
    각 회마다 머쓱이가 친 공이 굴러간 거리의 최솟값의 제곱을 배열에 담아 return 하도록
    solution 함수를 완성해 주세요.
    */

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int [balls.length];
        double res = 0;

        for(int i = 0; i< balls.length; i++) {
            answer[i] = Integer.MAX_VALUE;
            //x대칭
            if(balls[i][1] != startY) {
                int x1 = balls[i][0] + startX;
                int x2 = Math.abs(balls[i][0] - m) + Math.abs(startX - m);
                int x = Math.min(x1, x2);
                int y = Math.abs(balls[i][1] - startY);

                res = Math.pow(x, 2) + Math.pow(y, 2);

                answer[i] = Math.min(answer[i],(int)res);
            }
            //y대칭
            if(balls[i][0] != startX) {
                int x = Math.abs(balls[i][0] - startX);
                int y1 = balls[i][1] + startY;
                int y2 = Math.abs(balls[i][1] - n) + Math.abs(startY - n);
                int y = Math.min(y1,y2);
                res = Math.pow(x, 2) + Math.pow(y, 2);

                answer[i] = Math.min(answer[i],(int)res);
            }
            //y좌표가 같을때 일자로 벽면맞기
            if(balls[i][1] == startY) {
                int x = 0;
                if(balls[i][0] < startX ) {
                    x = Math.abs(m-startX) + Math.abs(m-balls[i][0]);
                    res = Math.pow(x, 2);
                    answer[i] = Math.min(answer[i], (int) res);
                } else {
                    x = startX + balls[i][0];
                    res = Math.pow(x, 2);
                    answer[i] = Math.min(answer[i], (int) res);
                }
            }
            //x좌표가 같을때 일자로 벽면맞기
            if(balls[i][0] == startX) {
                int y = 0;
                if(balls[i][1] < startY) {
                    y = Math.abs(n-startY) + Math.abs(n-balls[i][1]);
                    res = Math.pow(y,2);
                    answer[i] = Math.min(answer[i], (int) res);
                } else {
                    y = startY + balls[i][1];
                    res = Math.pow(y, 2);
                    answer[i] = Math.min(answer[i], (int) res);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        당구연습 a = new 당구연습();

        int [][] balls = {{7, 7}, {2, 7}, {7, 3}};
        System.out.println(Arrays.toString(a.solution(10, 10, 3, 7, balls))); //[52, 37, 116]

        System.out.println(Arrays.toString(a.solution(10, 10, 5, 9, new int [][] {{5,8}}))); //[9]


    }
}
