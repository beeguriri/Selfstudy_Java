package Java_Programmers.Level2;

import java.util.Arrays;

public class 양궁대회 {

    static int [] ryanScore;
    static int [] result;
    static int maxScore = -1;

    //k점을 여러 발 맞혀도 k점 보다 많은 점수를 가져가는 게 아니고
    //k점만 가져가는 것을 유의하세요.
    //최댓값이 같은 점수가 여러개일때 낮은점수를 더맞힌 경우가 정답
    public static int calScore(int [] info) {

        int apeach = 0;
        int ryan = 0;

        for(int i=0; i<11; i++) {

            if(info[i]==0 && ryanScore[i]==0)
                continue;

            if(info[i]>=ryanScore[i])
                apeach += (10-i);
            else
                ryan += (10-i);
        }

        return (ryan-apeach)>0 ? ryan-apeach : -1;
    }

    public static void dfs(int [] info, int depth, int n){
        //dfs 종료조건
        if(depth == n){

            int score = calScore(info);

            if(maxScore<=score){
                maxScore = score;
                result = ryanScore.clone();
            }

            return;
        }

        for(int i=0; i<11 && ryanScore[i]<=info[i]; i++) {
            ryanScore[i] += 1;
            dfs(info, depth+1, n);
            ryanScore[i] -= 1;
        }
    }

    public static int[] solution(int n, int[] info) {
        ryanScore = new int [11];
        result = new int [11];
        dfs(info, 0, n);

        return maxScore==-1 ? new int [] {-1} : result;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(5, new int [] {2,1,1,1,0,0,0,0,0,0,0})));
//        System.out.println(Arrays.toString(solution(1, new int [] {1,0,0,0,0,0,0,0,0,0,0})));
    }
}
