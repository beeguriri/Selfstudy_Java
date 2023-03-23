package Java_이코테._01그리디;

public class 곱하기혹은더하기 {

    /*각 자리가 숫자(0~9)로 이루어진 문자열 S가 주어졌을 때
    * 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하여
    * 숫자 사이에 'x' 혹은 '+' 연산자를 넣어
    * 결과적으로 만들어질 수 있는 가장  큰 수를 구하는 프로그램*/

    public static void main(String[] args) {

        String s = "02984";
        int result = Integer.parseInt(s.substring(0,1));
        for(int i = 1; i<s.length(); i++) {
            int x = Integer.parseInt(s.substring(i,i+1));
            if(s.charAt(i-1)=='0' || s.charAt(i-1)=='1')
                result += x;
            else
                result *= x;
        }
        System.out.println(result);

    }
}
