package Java_Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 비밀지도 {

    /*지도는 한 변의 길이가 n인 정사각형 배열 형태로,
    각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
    전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
    지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
    지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
    "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
    암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는
    이진수에 해당하는 값의 배열이다.
    1 ≦ n ≦ 16
    arr1, arr2는 길이 n인 정수 배열로 주어진다.
    */

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        String [] s1T = new String [n];
        String [] s2T = new String [n];

        //2진수 배열로 만들고,
        for(int i = 0; i<arr1.length; i++) {
            answer[i] = "";
            s1T =  Integer.toString(arr1[i], 2).split("");
            s2T = Integer.toString(arr2[i],2).split("");
            s1.addAll(Arrays.asList(s1T));
            s2.addAll(Arrays.asList(s2T));

            //2진수 배열의 길이가 n보다 작으면 앞에서부터 0 채워줌
            int x = 0; int y=0;
            while(s1.size()<n) {
                s1.add(x++, "0");
                if(s1.size()==n) break;
            }
            while(s2.size()<n) {
                s2.add(y++, "0");
                if(s2.size()==n) break;
            }

            for(int j = 0; j<n; j++) {
                if(s1.get(j).contains("0") && s2.get(j).contains("0")) {
                    answer[i] += " ";
                }
                else answer[i] += "#";
            }

            s1.clear();
            s2.clear();

        }
        return answer;
    }

    public static void main(String[] args) {

        비밀지도 a = new 비밀지도();

        int [] arr1 = {9, 20, 28, 18, 11};
        int [] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(a.solution(5, arr1, arr2)));
        //출력	["#####","# # #", "### #", "# ##", "#####"]

        int [] arr3 = {46, 33, 33 ,22, 31, 50};
        int [] arr4 = {27 ,56, 19, 14, 14, 10};
        System.out.println(Arrays.toString(a.solution(6, arr3, arr4)));
        //출력	["######", "### #", "## ##", " #### ", " #####", "### # "]

        int n = 5;
        String[] ans = new String[n];
        String temp;

        for(int i = 0 ; i < n ; i++){
            temp = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
            temp = temp.substring(temp.length() - n);
            temp = temp.replaceAll("1", "#");
            temp = temp.replaceAll("0", " ");
            ans[i] = temp;
        }

        System.out.println(Arrays.toString(ans));
    }
}
