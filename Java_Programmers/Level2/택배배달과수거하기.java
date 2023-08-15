package Java_Programmers.Level2;

public class 택배배달과수거하기 {

    //cap개의 택배차 용량
    //n개의 집
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {

        long answer = 0;
        int delivery = 0;
        int pickup = 0;

        //마지막 집에서부터 내려오기
        for(int i=n-1; i>=0; i--) {

            int cnt = 0;

            while(delivery<deliveries[i] || pickup<pickups[i]){
                cnt++;
                delivery += cap;
                pickup += cap;
            }
            delivery -= deliveries[i];
            pickup -= pickups[i];
            answer += (i+1)*2L*cnt;
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(4, 5, new int[] {1, 0, 3, 1, 2}, new int []{0, 3, 0, 4, 0}));
//        System.out.println(solution(2, 7, new int[] {1, 0, 2, 0, 1, 0, 2}, new int []{0, 2, 0, 1, 0, 2, 0}));

    }
}
