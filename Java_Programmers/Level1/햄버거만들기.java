package Java_Programmers.Level1;

public class 햄버거만들기 {
    /* ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.
    (아래서부터, 빵 – 야채 – 고기 - 빵)
    상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때,
    상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
    * */

    //시간초과 해결 -> if문에 문자열 확인 범위 추가
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder temp = new StringBuilder();
        for (int x : ingredient) {
            temp.append(String.valueOf(x));

            if(temp.length()>=4 && temp.substring(temp.length()-4, temp.length()).equals("1231")) {
                answer++;
                temp.delete(temp.length()-4, temp.length());
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        햄버거만들기 a = new 햄버거만들기();

        System.out.println(a.solution(new int [] {2, 1, 1, 2, 3, 1, 2, 3, 1})); //2
        System.out.println(a.solution(new int [] {1, 3, 2, 1, 2, 1, 3, 1, 2})); //0

    }
}
