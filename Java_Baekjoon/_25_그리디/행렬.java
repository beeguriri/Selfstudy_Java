package Java_Baekjoon._25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행렬 {

    /* 0과 1로만 이루어진 행렬 A와 행렬 B가 있다.
    이때, 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값을 구하는 프로그램을 작성하시오.
    행렬을 변환하는 연산은 어떤 3×3크기의 부분 행렬에 있는 모든 원소를 뒤집는 것이다. (0→1, 1→0)
    첫째 줄에 행렬의 크기 N M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다.
    둘째 줄부터 N개의 줄에는 행렬 A가 주어지고, 그 다음줄부터 N개의 줄에는 행렬 B가 주어진다.
    첫째 줄에 문제의 정답을 출력한다. 만약 A를 B로 바꿀 수 없다면 -1을 출력한다. */


    public static int [][] arrA;
    public static int [][] arrB;

    public static int countArr(int n, int m, int[][] arrA, int[][] arrB) {

        int cnt = 0;

        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=m-3; j++) {
                if(arrA[i][j]==arrB[i][j])
                    continue;

                for(int ik=i; ik<i+3; ik++){
                    for(int jk=j; jk<j+3; jk++) {
                        arrA[ik][jk] = arrA[ik][jk]==1 ? 0 : 1;
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean checkArr(int n, int m, int[][] arrA, int[][] arrB){

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(arrA[i][j]!=arrB[i][j]){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arrA = new int [n][m];
        arrB = new int [n][m];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++)
                arrA[i][j] = Integer.parseInt(s.substring(j, j+1));
        }

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++)
                arrB[i][j] = Integer.parseInt(s.substring(j, j+1));
        }

        int cnt = countArr(n, m, arrA, arrB);

        if(checkArr(n, m, arrA, arrB))
            System.out.println(cnt);
        else
            System.out.println(-1);

    }
}
