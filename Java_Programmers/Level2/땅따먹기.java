package Java_Programmers.Level2;

public class 땅따먹기 {

    public static int solution(int[][] land) {
        int answer = 0;

        int [][] dp = new int [land.length][land[0].length];
        dp[0][0] = land[0][0];  dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];  dp[0][3] = land[0][3];

        for(int i=1; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                for(int k=0; k<land[0].length; k++){
                    if (j==k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                }
            }
        }

        for(int i=0; i<dp[0].length; i++)
            answer = Math.max(answer, dp[dp.length-1][i]);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int [][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }
}
