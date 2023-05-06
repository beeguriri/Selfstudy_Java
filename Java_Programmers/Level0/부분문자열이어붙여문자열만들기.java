package Java_Programmers.Level0;

public class 부분문자열이어붙여문자열만들기 {

    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<my_strings.length; i++){

            String temp = my_strings[i].substring(parts[i][0], parts[i][1]+1);
            // System.out.println(temp);
            sb.append(temp);

        }

        return sb.toString();
    }
}
