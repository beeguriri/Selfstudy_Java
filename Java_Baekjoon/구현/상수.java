package Java_Baekjoon.구현;

import java.util.Scanner;

public class 상수 {

    /*상수는 수를 다른 사람과 다르게 거꾸로 읽는다.
    예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다.
    따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
    입력 : 첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다.
    두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.
    출력 : 첫째 줄에 상수의 대답을 출력한다.
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String n1 = s.split(" ")[0]; //743
        String n2 = s.split(" ")[1]; //893


        for(int i = n1.length()-1; i>=0; i--) {
            n1 += n1.split("")[i];
            n2 += n2.split("")[i];
        }

        n1 = n1.substring(3);
        n2 = n2.substring(3);
        if(Integer.parseInt(n1)>Integer.parseInt(n2))
            System.out.println(n1);
        else
            System.out.println(n2);

        //734 893 => 437
        //221 231 => 132
        //839 237 => 938
    }
}
