package Java_Programmers.Level2;

public class 멀쩡한사각형 {

    public static long solution(int w, int h) {

        long answer = (long) w * h;

        if(w==h)
            return answer - w;

        long length = gcd(w, h);
        long tempW = w/length;
        long tempH = h/length;
        long cut = tempW*tempH - (tempW-1)*(tempH-1);

        return answer - cut*length;
    }

    public static long gcd(int x, int y) {
        if(y==0)
            return x;
        return gcd(y, x%y);
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }
}
