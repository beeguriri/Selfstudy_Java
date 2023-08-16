package Java_Programmers.Level3;

public class 정수삼각형 {

    public static int solution(int[][] triangle) {

        int answer = 0;
        int size = triangle[triangle.length-1].length;
        int [][] result = new int [size][size];

        result[0][0] = triangle[0][0];
        for(int i=1; i<size; i++) {
            for(int j=0; j<triangle[i].length; j++){
                if(j==0)
                    result[i][j] = result[i-1][j] + triangle[i][j];
                else if (j==triangle[i].length-1)
                    result[i][j] = result[i-1][j-1] + triangle[i][j];
                else
                    result[i][j] = Math.max(result[i-1][j-1], result[i-1][j]) + triangle[i][j];
            }
        }

        for(int i : result[size-1])
            answer = Math.max(i, answer);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int [][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
