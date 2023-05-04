package Java_Programmers.Level2;

import java.util.*;

public class 튜플 {

    public int[] solution(String s) {

        String [] str = s.split("\\},\\{");
        str[0] = str[0].replaceAll("\\{", "");
        str[str.length-1] = str[str.length-1].replaceAll("\\}", "");

//        System.out.println(Arrays.toString(str));

        Arrays.sort(str, (o1, o2) -> o1.length() - o2.length());
//        System.out.println(Arrays.toString(str));

        List<Integer> list = new ArrayList<>();
        StringTokenizer st;
        for(String ss : str){
            st = new StringTokenizer(ss, ",");
            int n = st.countTokens();
            for(int i=0; i<n; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (!list.contains(x))
                    list.add(x);
            };
        };

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

        튜플 a = new 튜플();

        System.out.println(Arrays.toString(a.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));

        double x = Math.ceil(2.4);
        System.out.println((int)x);

    }
}
