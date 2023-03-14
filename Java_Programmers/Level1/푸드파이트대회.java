package Java_Programmers.Level1;

import java.util.ArrayList;

public class 푸드파이트대회 {

    /*food에는 칼로리가 적은 순서대로 음식의 양이 담겨 있습니다.
    food[i]는 i번 음식의 수입니다.
    food[0]은 수웅이가 준비한 물의 양이며, 항상 1입니다.
    정답의 길이가 3 이상인 경우만 입력으로 주어집니다.*/

    public String solution(int[] food) {
        String answer = "";
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=1; i<food.length; i++) {
            for(int j= 0; j<food[i]/2; j++)
                temp.add(i);
        }
        temp.add(0);
        for(int i = temp.size()-2 ; i>=0; i--)
            temp.add(temp.get(i));

        for(int i =0; i<temp.size(); i++)
            answer += temp.get(i);
        return answer;
    }

    public String solution2 (int [] food) {

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<food.length; i++)
            sb.append(String.valueOf(i).repeat(food[i]/2));

        String answer = sb + "0";
        return answer + sb.reverse();
    }

    public static void main(String[] args) {
        푸드파이트대회 a = new 푸드파이트대회();
        int [] food1 = {1, 3, 4, 6};
        System.out.println(a.solution(food1)); //1223330333221
        System.out.println(a.solution2(food1)); //1223330333221

        int [] food2 = {1, 7, 1, 2};
        System.out.println(a.solution(food2));  //"111303111"
        System.out.println(a.solution2(food2));  //"111303111"

    }
}
