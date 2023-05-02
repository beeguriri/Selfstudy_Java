package Java_Programmers.Level2;

public class 예상대진표 {

    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(true) {

            a = a%2==0? a/2 : (a/2)+1;
            b = b%2==0? b/2 : (b/2)+1;

            answer++;

            if(a==b)
                break;

        }

        return answer;
    }
}
