package Java_Programmers.Level1;

import java.util.Arrays;

public class 예산 {

    /*S사에서는 각 부서에 필요한 물품을 지원해 주기 위해 부서별로 물품을 구매하는데 필요한 금액을 조사했습니다.
    그러나, 전체 예산이 정해져 있기 때문에 모든 부서의 물품을 구매해 줄 수는 없습니다.
    그래서 최대한 많은 부서의 물품을 구매해 줄 수 있도록 하려고 합니다.
    물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해 줘야 합니다.
    예를 들어 1,000원을 신청한 부서에는 정확히 1,000원을 지원해야 하며, 1,000원보다 적은 금액을 지원해 줄 수는 없습니다.
    부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때,
    최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하도록 solution 함수를 완성해주세요.*/

    public int solution(int[] d, int budget) {
        int answer = 0;
        int i = 0;
        Arrays.sort(d);
        while(budget>0) {
            budget -= d[i++];
            if(budget >= 0) answer++;
            //부서가 하나만 있는 경우 처리
            if(d.length==answer) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        예산 a = new 예산();

        int [] d1 = {1,3,2,5,4};
//        System.out.println(a.solution(d1,9)); //3

        int [] d2 = {2,2,3,3};
  //      System.out.println(a.solution(d2,10)); //4

        int [] d3 = {100};
        System.out.println(a.solution(d3, 101));    //1
    }
}
