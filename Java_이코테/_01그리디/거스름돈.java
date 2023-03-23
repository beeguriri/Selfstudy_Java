package Java_이코테._01그리디;

public class 거스름돈 {

    /* 거슬러줘야할 동전의 최소 개수*/

    public static void main(String[] args) {

        int n = 1260;
        int [] coins = {500, 100, 50, 10};
        int answer = 0;

        for(int c : coins) {
            answer += n / c;
            n = n%c;
        }
        System.out.println(answer);
    }

}
