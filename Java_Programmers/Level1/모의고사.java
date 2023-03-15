package Java_Programmers.Level1;

import java.util.*;

public class 모의고사 {

    /*1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
    가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
    제한 조건
    시험은 최대 10,000 문제로 구성되어있습니다.
    문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.*/

    public int[] solution(int[] answers) {
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;

        for(int i = 0; i<answers.length; i++) {
            if(answers[i]==a[i%5]) cntA++;
            if(answers[i]==b[i%8]) cntB++;
            if(answers[i]==c[i%10]) cntC++;
        }

        int maxScore = Math.max(cntA, Math.max(cntB, cntC));
        List<Integer> temp = new ArrayList<>();
        if(maxScore==cntA) temp.add(1);
        if(maxScore==cntB) temp.add(2);
        if(maxScore==cntC) temp.add(3);

//        Set<Integer> temp = new HashSet<>();
//        if(cntA>=cntB && cntA>=cntC) {
//            temp.add(1);
//            if(cntA==cntB) temp.add(2);
//            if(cntA==cntC) temp.add(3);
//        } else if (cntB>=cntA && cntB >= cntC) {
//            temp.add(2);
//            if(cntB==cntA) temp.add(1);
//            if(cntB==cntC) temp.add(3);
//        } else if(cntC>=cntA && cntC>=cntB){
//            temp.add(3);
//            if(cntC==cntA) temp.add(1);
//            if(cntC==cntB) temp.add(2);
//        } else {
//            temp.add(1);
//            temp.add(2);
//            temp.add(3);
//        }

        return temp.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        모의고사 a = new 모의고사();

        int []ans1 = {1,2,3,4,5};
        System.out.println(Arrays.toString(a.solution(ans1))); //[1]
        int []ans2 = {1,3,2,4,2};
        System.out.println(Arrays.toString(a.solution(ans2))); //[1,2,3]

    }
}
