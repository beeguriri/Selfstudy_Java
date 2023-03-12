package Java_Programmers.Level1;

public class 없는숫자더하기 {

    /*0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
    numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록
    solution 함수를 완성해주세요.
    제한사항 :
    1 ≤ numbers의 길이 ≤ 9
    0 ≤ numbers의 모든 원소 ≤ 9
    numbers의 모든 원소는 서로 다릅니다.
     */

    public int solution(int[] numbers) {
        int answer = 0;
        String test = "0123456789";

        for(int i = 0; i<numbers.length; i++)
            test = test.replace(String.valueOf(numbers[i]),"");

        for(int i=0; i<test.length(); i++)
            answer += Integer.parseInt(test.split("")[i]);

        return answer;
    }

    public static void main(String[] args) {
        없는숫자더하기 a = new 없는숫자더하기();

        int [] num1 = {1,2,3,4,6,7,8,0};
        System.out.println(a.solution(num1));   //14

        int [] num2 = {5,8,4,0,6,7,9};
        System.out.println(a.solution(num2));   //6
    }
}
