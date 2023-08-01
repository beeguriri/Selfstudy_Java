package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 후보키 {

    public static List<HashSet<Integer>> keys = new ArrayList<>();
    public static int answer = 0;

    public static int solution(String[][] relation) {

        for(int i=1; i<=relation[0].length; i++)
            comb(relation, new HashSet<>(), 0, 0, relation[0].length, i);

        return answer;
    }

    //모든 조합 만들기
    public static void comb(String [][] input, HashSet<Integer> output, int depth, int start, int n, int r) {

        //dfs  종료조건
        if(depth == r) {
            //유일성 검사
            if(!isUnique(input, output))
                return;

            //최소성 검사
            for(HashSet<Integer> key : keys)
                if(output.containsAll(key))
                    return;

            //조합추가하고 answer 증가
            keys.add(output);
            answer++;
            return;
        }

        //조합 만들기
        for(int i=start; i<n; i++) {
            HashSet<Integer> set = new HashSet<>(output);
            set.add(i);
            comb(input, set, depth+1, i+1, n, r);
        }
    }

    //유일성 체크
    public static boolean isUnique(String [][] input, HashSet<Integer> set) {

        HashSet<String> result = new HashSet<>();

        for(int i=0; i<input.length; i++) {

            //set의 인덱스로 실제 키 만듦
            StringBuilder sb = new StringBuilder();
            for(int idx : set)
                sb.append(input[i][idx]);

            result.add(sb.toString());
        }

        return result.size() == input.length;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new String[][] {{"100","ryan","music","2"},{"200","apeach","math","2"},
                        {"300","tube","computer","3"},{"400","con","computer","4"},
                        {"500","muzi","music","3"},{"600","apeach","music","2"}}
        ));
    }
}
