package Java_Programmers.Level1;

public class 숫자문자열과영단어 {

    /* 1478 → "one4seveneight"
    234567 → "23four5six7"
    10203 → "1zerotwozero3"
    * */

    public int solution(String s) {
        int answer = 0;
        String [][] arr = {{"zero", "0"}, {"one", "1"}, {"two", "2"}, {"three", "3"}, {"four", "4"}, {"five", "5"},
                            {"six","6"}, {"seven","7"},{"eight","8"},{"nine", "9"}};

        for(int i = 0; i< arr.length; i++) {
            s = s.replaceAll(arr[i][0], arr[i][1]);
        }
        answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {

        숫자문자열과영단어 a = new 숫자문자열과영단어();

        System.out.println(a.solution("one4seveneight")); //1478
        //System.out.println(a.solution("23four5six7")); //234567
        //System.out.println(a.solution("2three45sixseven")); //234567
        //System.out.println(a.solution("123")); //123
    }
}
