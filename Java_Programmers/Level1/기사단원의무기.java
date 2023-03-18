package Java_Programmers.Level1;

import java.util.HashSet;

public class 기사단원의무기 {

    /* 각 기사는 자신의 기사 번호의 약수 개수에 해당하는 공격력을 가진 무기를 구매하려 합니다.
    기사단원의 수를 나타내는 정수 number와
    이웃나라와 협약으로 정해진 공격력의 제한수치를 나타내는 정수 limit와
    제한수치를 초과한 기사가 사용할 무기의 공격력을 나타내는 정수 power가 주어졌을 때,
    무기점의 주인이 무기를 모두 만들기 위해 필요한 철의 무게를 return 하는 solution 함수를 완성하시오.
     */

    public int solution(int number, int limit, int power) {
        int answer = 0;
        int [] cnt = new int [number];
        for(int num = 1; num<= number; num++) {
            HashSet<Integer> temp = new HashSet<>();
            for (int i = 1; i<=Math.sqrt(num); i++) {
                if(num%i==0) {
                    temp.add(i);
                    temp.add(num / i);
                }
            }
            cnt[num-1] = temp.size();
        }

        for(int i : cnt) {
            if(i<=limit) answer += i;
            else answer += power;
        }

        return answer;
    }
    public static void main(String[] args) {
        기사단원의무기 a = new 기사단원의무기();

        System.out.println(a.solution(5, 3, 2)); //10
        System.out.println(a.solution(10, 3, 2));   //21

    }
}
