package Java_Programmers.Level1;

public class 숫자짝꿍 {

    /*두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여
    만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
    (단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).
    X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다.
    X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.*/

    public String solution(String X, String Y) {

        StringBuilder answer = new StringBuilder();

        int [] strx = {0,0,0,0,0,0,0,0,0,0}; //0~9까지의 정수
        int [] stry = {0,0,0,0,0,0,0,0,0,0};

        //각 정수 count
        for (String x : X.split(""))
            strx[Integer.parseInt(x)]++;

        for (String y : Y.split(""))
            stry[Integer.parseInt(y)]++;

        //내림차순 정렬할거라 마지막인덱스부터 확인
        for (int i = strx.length-1; i>=0; i--) {
            while(strx[i] > 0 && stry[i] > 0) {
                answer.append(i);
                strx[i]--;
                stry[i]--;
            }
        }

        if("".equals(answer.toString())) return "-1";
        else if(answer.substring(0,1).equals("0")) return "0";
        else return answer.toString();

        //런타임에러 -> 반복횟수때문인듯..
//        //length 작은길이를 X에, 긴 길이를 Y에
//        if (X.length()>Y.length()) {
//            String temp = Y;
//            Y = X;
//            X = temp;
//        }
//
//        //짧은 길이 만큼만 반복문 돌아주면 됨
//        for (int i = 0; i<X.length(); i++) {
//            char c = X.charAt(i);
//            if (Y.contains(String.valueOf(c))) {
//                cnt++;
//                answer.append(c);
//                Y = Y.replaceFirst(String.valueOf(c), "");
//            }
//        }
//
//        if (cnt==0) return "-1";
//
//        if (Integer.parseInt(answer.toString())==0) return "0";
//
//        String [] temp = answer.toString().split("");
//        Arrays.sort(temp, Collections.reverseOrder());
//        String result = "";
//        for(String s : temp)
//            result += s;

    }
    public static void main(String[] args) {
        숫자짝꿍 a = new 숫자짝꿍();

        System.out.println(a.solution("100", "2345")); //-1
        System.out.println(a.solution("100","203045")); //0
        System.out.println(a.solution("100","123450")); //10
        System.out.println(a.solution("12321","42531")); //321
        System.out.println(a.solution("5525", "1255")); //552
    }
}
