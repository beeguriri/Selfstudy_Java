package Java_Programmers.Level1;

public class 수박수박수박수박수박수 {
    /*길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수,
    solution을 완성하세요.
    예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.*/

    public String solution(int n) {
        String answer = "";

        for(int i = 1; i<=(n+1)/2; i++)
            answer += "수박";

        if(n%2!=0) answer = answer.substring(0,answer.length()-1);

        return answer;
    }

    public static void main(String[] args) {
        수박수박수박수박수박수 a = new 수박수박수박수박수박수();

        System.out.println(a.solution(8));
        System.out.println(a.solution(3));
    }

}
