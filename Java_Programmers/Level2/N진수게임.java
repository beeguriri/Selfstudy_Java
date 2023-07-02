package Java_Programmers.Level2;

public class N진수게임 {

    //진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
    public static String solution(int n, int t, int m, int p) {

        StringBuilder answer = new StringBuilder();
        int num = 0;
        int idx = 0;

        while(answer.length()<t) {

            //n진수로 변환
            String s = Integer.toUnsignedString(num, n);
            for(int i=0; i<s.length(); i++) {
                if(idx%m == p-1)
                    answer.append(String.valueOf(s.charAt(i)).toUpperCase());
                idx++;
                if(answer.length()==t)
                    break;
            }
            num++;
        }
        return answer.toString();
    }

    public static void main(String[] args) {

        System.out.println(solution(2, 4, 2, 1)); //"0111"
        System.out.println(solution(16, 16, 2, 1)); //"02468ACE11111111"
        System.out.println(solution(16, 16, 2, 2)); //"13579BDF01234567"
    }
}
