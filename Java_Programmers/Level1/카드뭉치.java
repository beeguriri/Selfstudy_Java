package Java_Programmers.Level1;

import java.util.Arrays;
import java.util.LinkedList;

public class 카드뭉치 {

    /*문자열로 이루어진 배열 cards1, cards2와 원하는 단어 배열 goal이 매개변수로 주어질 때,
    cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를,
    만들 수 없다면 "No"를 return하는 solution 함수를 완성해주세요.*/

    public String solution(String[] cards1, String[] cards2, String[] goal) {

        LinkedList<String> c1 = new LinkedList<>(Arrays.asList(cards1));
        LinkedList<String> c2 = new LinkedList<>(Arrays.asList(cards2));

        for (String s : goal) {

            if (!c1.isEmpty() && c1.getFirst().equals(s)) {
                    c1.removeFirst();
                    continue;
            }
            if (!c2.isEmpty() && c2.getFirst().equals(s)) {
                    c2.removeFirst();
                    continue;
            }
            return "No";
        }

        return "Yes";
    }

    public static void main(String[] args) {

        카드뭉치 a = new 카드뭉치();

        String [] cards1 = {"i", "drink", "water"};
        String [] cards2 = {"want", "to"};
        String [] goal1 = {"i", "want", "to", "drink", "water"};
        System.out.println(a.solution(cards1, cards2, goal1)); //"Yes"

        String [] cards3 = {"i", "water", "drink"};
        System.out.println(a.solution(cards3, cards2, goal1)); //"No"

        String [] cards4 = {"i", "want"};
        String [] cards5 = {"to", "drink"};
        System.out.println(a.solution(cards4, cards5, goal1)); //"No"


    }
}

