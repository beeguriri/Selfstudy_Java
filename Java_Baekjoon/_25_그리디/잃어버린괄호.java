package Java_Baekjoon._25_그리디;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 잃어버린괄호 {

    /*첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고,
    가장 처음과 마지막 문자는 숫자이다.
    그리고 연속해서 두 개 이상의 연산자가 나타나지 않고,
    5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.
    입력으로 주어지는 식의 길이는 50보다 작거나 같다.
    첫째 줄에 정답을 출력한다. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        //마이너스를 기준으로 1차 분리
        String str = sc.nextLine();
        String [] equ = str.split("-");

        for(int i = 0; i < equ.length; i++) {

            //분리된 것 중에 더하기가 있으면 전부 더하기
            String [] add = equ[i].split("\\+");
            int temp = 0;
            for(int j = 0; j < add.length; j++)
                temp += Integer.parseInt(add[j]);

            list.add(temp);
        }

        int sum = list.get(0);
        for(int i = 1; i < list.size(); i++)
            sum-= list.get(i);

        System.out.println(sum);
    }
}
