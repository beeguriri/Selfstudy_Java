package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 혼자놀기의달인 {

    public static boolean [] visited;
    public static List<Integer> result = new ArrayList<>();

    public static int solution(int[] cards) {

        visited = new boolean[cards.length];

        for(int i=0; i<cards.length; i++) {
            if(visited[i])
                continue;
            //재귀
            dfs(cards, i, 0);
        }

        //최대값 반환을 위하여 정렬
        result.sort(Collections.reverseOrder());

        return result.size()==1 ? 0 : result.get(0)*result.get(1);
    }

    public static void dfs(int [] cards, int index, int count) {

        //dfs 종료조건
        if(visited[index]) {
            result.add(count);
            return;
        }

        visited[index] = true;
        //card는 1~8, index는 0~7
        dfs(cards, cards[index]-1, count+1);

    }

    public static void main(String[] args) {
        System.out.println(solution(new int [] {8,6,3,7,2,5,1,4})); //12
    }
}
