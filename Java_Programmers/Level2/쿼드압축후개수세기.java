package Java_Programmers.Level2;

import java.util.Arrays;

public class 쿼드압축후개수세기 {

    public static int [] answer = new int [2];
    public static int[] solution(int[][] arr) {

        quad(0,0,arr.length,arr);

        return answer;
    }

    public static void quad(int x, int y, int size, int [][] arr){

        if(isSameNumber(x, y, size, arr)){
            answer[arr[x][y]]++;
            return;
        }

        //4분할
        quad(x, y, size/2, arr);
        quad(x, y+size/2, size/2, arr);
        quad(x+size/2, y, size/2, arr);
        quad(x+size/2, y+size/2, size/2, arr);

    }

    public static boolean isSameNumber(int x, int y, int size, int [][] arr) {

        for(int i=x; i<x+size; i++)
            for(int j=y; j<y+size; j++)
                if(arr[x][y] != arr[i][j])
                    return false;

        return true;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int [][] {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}}))); // [4, 9]

    }
}
