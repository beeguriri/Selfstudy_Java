package Java_Programmers.Level1;

public class 나머지가1이되는수찾기 {
    /*자연수 n이 매개변수로 주어집니다.
    n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록
    solution 함수를 완성해주세요.
    답이 항상 존재함은 증명될 수 있습니다.*/
    //n	result
    //10	3
    //12	11
    public int solution(int n) {
        int answer = 0;

        for (int i=2; i<n; i++) {
            if(n%i==1)  {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        나머지가1이되는수찾기 a = new 나머지가1이되는수찾기();
        System.out.println(a.solution(10));
        System.out.println(a.solution(12));
    }
}
