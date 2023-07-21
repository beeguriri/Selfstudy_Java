package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 전력망을둘로나누기 {

    public static int [] parents;
    public static List<ArrayList<Integer>> list = new ArrayList<>();

    public static int findParents(int x) {
        if(parents[x]==x)
            return x;

        return parents[x] = findParents(parents[x]);
    }

    public static void unionParents(int a, int b) {
        a = findParents(a);
        b = findParents(b);

        if(a<b)
            parents[b] = a;
        else
            parents[a] = b;
    }

    public static int solution(int n, int[][] wires) {

        int minCount = Integer.MAX_VALUE;

        //전력망 입력
        for(int i=0; i<=n; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            list.get(a).add(b);
            list.get(b).add(a);
        }

        // 하나씩 끊어보면서 묶음 개수 확인
        for(int i=0; i<wires.length; i++) {

            //부모배열 초기화
            parents = new int [n+1];
            for(int p=1; p<=n; p++)
                parents[p] = p;

            for(int j=0; j<wires.length; j++) {
                if(i==j) continue;

                unionParents(wires[j][0], wires[j][1]);
            }

            //간선 정보 다 입력하고 하나씩 지워가며 찾아도 정답 통과!
//            Integer a = wires[i][0];
//            Integer b = wires[i][1];
//
//            list.get(a).remove(b);
//            list.get(b).remove(a);

            //입력받은 간선 정보에 대해 확인
//            for(int j=1; j<=n; j++) {
//                for(int k=0; k<list.get(j).size(); k++) {
//                    int x = list.get(j).get(k);
//                    if(findParents(x)!=findParents(j))
//                        unionParents(x, j);
//                }
//            }

            // 부모가 같은 개수 확인
            // 1번 노드의 부모는 무조건 1 (작은 노드를 부모로 가지므로..)

            System.out.println(Arrays.toString(parents));
            int count = 0;
            for(int p=1; p<=n; p++)
                if(findParents(p)==1)
                    count++;
            System.out.println("count = " + count);
            minCount = Math.min(minCount, Math.abs((n-count)-count));
            System.out.println("minCount = " + minCount);

//            list.get(a).add(b);
//            list.get(b).add(a);
        }

        return minCount;
    }

    public static void main(String[] args) {

        System.out.println(solution(9, new int [][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}})); //3
    }
}
