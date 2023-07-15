package Java_Programmers.Level2;

public class _124나라의숫자 {


    public static String solution(int n) {

        StringBuilder sb = new StringBuilder();
        while(n>0) {

            if(n%3==0) {
                sb.insert(0, "4");
                n = n/3 - 1;
            }
            else if (n%3==1) {
                sb.insert(0, "1");
                n /= 3;
            }
            else {
                sb.insert(0, "2");
                n /= 3;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        for(int i=1; i<=10; i++)
            System.out.println(solution(i));

        System.out.println(solution(50000000));

    }
}

