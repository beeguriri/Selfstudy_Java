package Java_Programmers.Level1;

import java.util.*;
import static java.util.Collections.*;

public class 과일장수 {

    /*사과는 상태에 따라 1점부터 k점까지의 점수로 분류하며,
    k점이 최상품의 사과이고 1점이 최하품의 사과입니다.
    한 상자에 사과를 m개씩 담아 포장합니다.
    상자에 담긴 사과 중 가장 낮은 점수가 p (1 ≤ p ≤ k)점인 경우, 사과 한 상자의 가격은 p * m 입니다.
    과일 장수가 가능한 많은 사과를 팔았을 때, 얻을 수 있는 최대 이익을 계산하고자 합니다.
    (사과는 상자 단위로만 판매하며, 남는 사과는 버립니다)
    사과의 최대 점수 k, 한 상자에 들어가는 사과의 수 m, 사과들의 점수 score가 주어졌을 때,
    과일 장수가 얻을 수 있는 최대 이익을 return하는 solution 함수를 완성해주세요.
    이익이 발생하지 않는 경우에는 0을 return 해주세요.
    */
    //k가 의미 있는 변수인가?

    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int box = score.length/m;

        List<Integer> temp = new ArrayList<>();
        for (int x : score) {
            temp.add(x);
        }
        temp.sort(reverseOrder());

        for(int i =m-1; i<box*m; i+=m)
            answer += m * temp.get(i);

        return answer;
    }

    public static void main(String[] args) {
        과일장수 a = new 과일장수();

        int [] scores1 = {1, 2, 3, 1, 2, 3, 1};
        System.out.println(a.solution(3, 4, scores1)); //8

        int [] scores2 = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println(a.solution(4, 3, scores2));  //33

    }
}
