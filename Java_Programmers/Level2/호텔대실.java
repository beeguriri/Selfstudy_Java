package Java_Programmers.Level2;

public class 호텔대실 {

    public static final int maxTime = 24*60+10;
    public static int [] booking = new int [maxTime];

    public static int solution(String[][] book_time) {
        int answer = 0;
        for(String [] time : book_time) {
            int start = calcTime(time[0]);
            int end = calcTime(time[1]) + 10;

            booking[start] += 1;
            booking[end] -= 1;
        }

        for(int i=1; i<maxTime; i++) {
            booking[i] += booking[i-1];
            answer = Math.max(answer, booking[i]);
        }

        return answer;
    }

    public static int calcTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        return hour*60 + min;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String [][] {{"15:00", "17:00"}, {"16:40", "18:20"},
                {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
    }
}
