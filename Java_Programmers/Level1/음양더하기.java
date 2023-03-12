package Java_Programmers.Level1;

public class 음양더하기 {

    /*어떤 정수들이 있습니다.
    이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와
    이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다.
    실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.
    signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미합니다.
     */
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i<absolutes.length; i++)
            answer+=(signs[i]?1:-1)*absolutes[i];

        return answer;
    }

    public static void main(String[] args) {

        음양더하기 a = new 음양더하기();

        int [] abs1 = {4,7,12};
        boolean [] boo1 = {true,false,true};
        System.out.println(a.solution(abs1, boo1)); //9

        int [] abs2 = {1,2,3};
        boolean [] boo2 = {false,false,true};
        System.out.println(a.solution(abs2, boo2)); //0

    }
}
