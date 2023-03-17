package Java_Programmers.Level1;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {

    /*순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정됩니다.
    알아볼 수 없는 두 개의 번호를 각각 10, 6이라고 가정하면 3등에 당첨될 수 있습니다.
    3등을 만드는 다른 방법들도 존재합니다. 하지만, 2등 이상으로 만드는 것은 불가능합니다.
    알아볼 수 없는 두 개의 번호를 각각 11, 7이라고 가정하면 5등에 당첨될 수 있습니다.
    5등을 만드는 다른 방법들도 존재합니다. 하지만, 6등(낙첨)으로 만드는 것은 불가능합니다.
    민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다.
    이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.*/

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int [2];
        int x = 0;
        int zero = 0;
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        for(int i : lottos) {
            for(int j : win_nums) {
                if(i==0) {
                    zero++;
                    break;
                }
                if(i==j) {
                    x++;
                    break;
                }
            }
        }
        answer[0] = getGrade(x+zero);
        answer[1] = getGrade(x);

        return answer;
    }

    public int getGrade(int n) {

        return switch (n) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
    public static void main(String[] args) {
        로또의최고순위와최저순위 a = new 로또의최고순위와최저순위();

        int [] lottos1 = {44, 1, 0, 0, 31, 25};
        int [] win_nums1 = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(a.solution(lottos1, win_nums1))); //[3, 5]

        int [] lottos2 = {0, 0, 0, 0, 0, 0};
        int [] win_nums2 = {38, 19, 20, 40, 15, 25};
        System.out.println(Arrays.toString(a.solution(lottos2, win_nums2))); //[1, 6]

        int [] lottos3 = {45, 4, 35, 20, 3, 9};
        int [] win_nums3 = {20, 9, 3, 45, 4, 35};
        System.out.println(Arrays.toString(a.solution(lottos3, win_nums3))); //[1, 1]

        int [] lottos4 = {1,2,3,4,5,6};
        int [] win_nums4 = {7,8,9,10,11,12};
        System.out.println(Arrays.toString(a.solution(lottos4, win_nums4))); //[6, 6]

    }
}
