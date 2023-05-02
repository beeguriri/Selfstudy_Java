package Java_Programmers.Level2;

public class 카펫 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];

        int x = 0;
        int y = 0;
        int count = 0;

        for(int i=1; i<=yellow; i++) {

            if(yellow % i == 0) {
                x = yellow / i;
                y = i;
                count = x*2 + y*2 + 4;

                if(count == brown) {

                    answer[0] = x+2;
                    answer[1] = y+2;
                    break;
                }
            }
        }

        return answer;
    }
}
