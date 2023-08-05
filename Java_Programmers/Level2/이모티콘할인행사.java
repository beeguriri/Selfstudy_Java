package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 이모티콘할인행사 {

    public static int [] discountRates = {10, 20, 30, 40};
    public static int [] rate;
    public static int n;
    public static List<int []> list = new ArrayList<>();

    public static void dfs(int[][] users, int[] emoticons, int depth) {
        if(depth==n){
            //계산하고 값 리턴
            calcPrice(users, emoticons, rate);
            return;
        }

        //중복을 허용하는 순열
        for(int r : discountRates){
            rate[depth] = r;
            dfs(users, emoticons, depth+1);
        }
    }

    public static void calcPrice(int [][] users, int[] emoticons, int [] rates){

        int count = 0;
        int totalPrice = 0;

        for(int [] user : users){
            int price = 0;
            for(int i=0; i<emoticons.length; i++){
                //기준보다 할인율이 커야 구매
                if(user[0]>rates[i])
                    continue;

                price += (100-rates[i]) * emoticons[i] / 100;
            }

            if(user[1]<=price)
                count++;
            else
                totalPrice += price;
        }

        list.add(new int [] {count, totalPrice});
//        System.out.println(Arrays.toString(list.get(list.size()-1)));
    }

    public static int[] solution(int[][] users, int[] emoticons) {

        n = emoticons.length;
        rate = new int [n];

        dfs(users, emoticons, 0);

        Collections.sort(list, (o1, o2) -> o1[0]==o2[0] ? o2[1]-o1[1] : o2[0]-o1[0]);

        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new int [][] {{40, 10000}, {25, 10000}}, new int [] {7000, 9000})));
    }
}
