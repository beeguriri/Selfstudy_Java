package Java_Programmers.Level2;

public class 방금그곡 {

    //m 은 음 1개이상 1439개 이하
    //musicinfos : 음악 시작시간, 끝난 시간, 음악제목, 악보정보
    //음은 1분에 한개 재생, 조건이 일치하는 음악이 없을때에는 "(None)"반환
    //C,C#,D,D#,E,F,F#,G,G#,A,A#,B
    //C# => H
    //D# => I
    //F# => J
    //G# => K
    //A# => L
    public static String solution(String m, String [] musicinfos) {

        //여러개가 있을때는 제생된 시간이 제일 긴 음악제목
        int maxPlayTime = -1;
        String answer = "";

        //노트변경
        m = changeNote(m);

        for(String s : musicinfos) {
            String [] temp = s.split(",");
            String title = temp[2];
            String melodyInfo = changeNote(temp[3]);

            //재생시간
            String [] timeInfo = temp[0].split(":");
            int start = Integer.parseInt(timeInfo[0]) * 60 + Integer.parseInt(timeInfo[1]);
            timeInfo = temp[1].split(":");
            int end = Integer.parseInt(timeInfo[0])*60 + Integer.parseInt(timeInfo[1]);
            int play = end - start;
            System.out.println("play = " + play);

            if (melodyInfo.length() < play) {
                while(melodyInfo.length()<=play) {
                    melodyInfo += melodyInfo;
                }
            }
            melodyInfo = melodyInfo.substring(0, play);

            System.out.println("timeInfo_length = " + melodyInfo.length());
            System.out.println("melodyInfo: " + melodyInfo);

            if(melodyInfo.contains(m) && maxPlayTime < play) {
                answer = title;
                maxPlayTime = play;
            }
        }

            return maxPlayTime == -1 ? "(None)" : answer;
    }

    public static String changeNote(String m) {
        //C# => H
        //D# => I
        //F# => J
        //G# => K
        //A# => L

        m = m.replaceAll("C#", "H");
        m = m.replaceAll("D#", "I");
        m = m.replaceAll("F#", "J");
        m = m.replaceAll("G#", "K");
        m = m.replaceAll("A#", "L");

        return m;
    }

    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG",
                new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"})); //HELLO
        System.out.println(solution("CC#BCC#BCC#BCC#B",
                new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"})); //FOO
        System.out.println(solution("ABC",
                new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"})); //WORLD

        System.out.println(solution("ABC",
                new String[]{"12:00,12:06,HELLO,ABC#ABC#ABC"})); //"(None)"

        System.out.println(solution("ABC",
                new String[]{"12:04,13:00,HELLO,ABC#ABC#ABC"})); //"HELLO"

    }
}
