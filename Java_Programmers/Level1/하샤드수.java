package Java_Programmers.Level1;

public class 하샤드수 {

    /* 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
    예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
    자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
     * */

    public boolean solution(int x) {

        String [] s = String.valueOf(x).split("");
        int temp = 0;

        for (String i : s)
            temp += Integer.parseInt(i);

        if(x%temp==0)   return true;
        else return false;

    }

    public static void main(String[] args) {
        하샤드수 a = new 하샤드수();

        System.out.println(a.solution(10)); //true
        System.out.println(a.solution(12)); //true
        System.out.println(a.solution(11)); //false
        System.out.println(a.solution(13)); //false
    }
}
