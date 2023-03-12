package Java_Programmers.Level1;

public class 서울에서김서방찾기 {

    /* String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아,
    "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요.
    seoul에 "Kim"은 오직 한 번만 나타나며
    잘못된 값이 입력되는 경우는 없습니다.
     * */
    public String solution(String[] seoul) {
        String answer = "";
        int idx = 0;

        for (int i = 0; i< seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                idx = i;
                break;
            }
        }

        answer = "김서방은 "+String.valueOf(idx)+"에 있다";

        return answer;
    }

    public static void main(String[] args) {
        서울에서김서방찾기 a = new 서울에서김서방찾기();

        String [] s = {"Jane", "Kim"};
        System.out.println(a.solution(s));
    }
}
