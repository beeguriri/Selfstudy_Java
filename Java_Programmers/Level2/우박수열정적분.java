package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 우박수열정적분 {

    //단, 우박수열 그래프의 가로축 길이를 미리 알 수 없기 때문에
    // 구간의 시작은 음이 아닌 정수,
    // 구간의 끝은 양이 아닌 정수로 표현합니다.
    // 이는 각각 꺾은선 그래프가 시작하는 점과
    // 끝나는 점의 x좌표에 대한 상대적인 오프셋을 의미합니다.
    public static double[] solution(int k, int[][] ranges) {

        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();

        list.add(k);

        //좌표 만들기
        while(k>1) {

            if(k%2==0)
                k /= 2;
            else
                k = (k*3)+1;

            list.add(k);
        }

        System.out.println(list);

        //모든 적분값 계산해놓기
        double [] area = new double[list.size()];
        for(int i=1; i<list.size(); i++)
            area[i] = (double) (list.get(i-1) + list.get(i))/2;

        System.out.println(Arrays.toString(area));
        int range = list.lastIndexOf(1);
        for(int i=0; i<ranges.length; i++) {
            int x1 = ranges[i][0];
            int x2 = range + ranges[i][1];

            if(x1>x2)
                answer[i] = -1;
            else if(x1==x2)
                answer[i] = 0;
            else {
                double sum = 0;
                for(int j=x1+1; j<=x2; j++) {
                    sum += area[j];
                }
                answer[i] = sum;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int [][] {{0,0},{0,-1},{2,-3},{3,-3}})));
    }
}
