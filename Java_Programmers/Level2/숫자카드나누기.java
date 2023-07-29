package Java_Programmers.Level2;

public class 숫자카드나누기 {


    public static int solution(int[] arrayA, int[] arrayB) {

        int answer = 0;

        //최대공약수 구하기
        int maxA = arrayA[0];
        int maxB = arrayB[0];
        for(int i=1; i<arrayA.length; i++) {
            maxA = gcd(maxA, arrayA[i]);
            maxB = gcd(maxB, arrayB[i]);
        }

        System.out.println("maxA = " + maxA);
        System.out.println("maxB = " + maxB);

        //각 배열 나누기
        if(isNotDivide(maxA, arrayB))
            answer = Math.max(answer, maxA);

        if(isNotDivide(maxB, arrayA))
            answer = Math.max(answer, maxB);

        return answer;
    }

    public static int gcd(int x, int y) {
        if(y==0)
            return x;

        return gcd(y, x%y);
    }

    public static boolean isNotDivide(int x, int [] array) {
        for(int y : array)
            if(y%x==0)
                return false;

        return true;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int [] {10, 17}, new int [] {5, 20}));
        System.out.println(solution(new int [] {10, 20}, new int [] {5, 17}));
        System.out.println(solution(new int [] {35, 119, 14}, new int [] {18, 30, 102}));

    }
}
