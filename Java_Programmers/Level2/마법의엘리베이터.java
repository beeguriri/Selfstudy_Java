package Java_Programmers.Level2;

public class 마법의엘리베이터 {

    // 6 -> 10을 만든 후 (+4) -10 (+1) 하면 총 5회
    // 5 -> -5하면 총 5회
    // 4 -> -4하면 총 4회
    //45 => -5 후 (+5), -40(+4) 하면 총 9회
    //45 => +5 하면 (+5), +50(+5) 총 10회가 됨.
    //55 => -5 후 -50 하면 10번
    //55 => +5 후, -60 하면 11번
    //2550 => 255 => 250(+5, 내림) => *25 (+5)*
    //2550 => 255 => 260(+5, 올림) => *26 (+4)*
    public static int solution(int storey) {
        int answer = 0;

        while(storey > 0) {

            int remain = storey % 10;

            //올림
            if(remain>5) {
                answer += 10 - remain;
                storey += 10 - remain;
            }
            //올림, 내림 여부 판단
            else if(remain==5) {
                int temp = storey % 100;
                //올림
                if(temp>=50)
                    storey += 5;

                answer += 5;
            }
            //내림
            else {
                answer += remain;
            }

            storey /= 10;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(16)); //6
        System.out.println(solution(2554)); //16
        System.out.println(solution(45)); //9
        System.out.println(solution(55)); //9
    }
}
