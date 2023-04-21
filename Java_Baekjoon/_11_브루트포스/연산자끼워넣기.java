package Java_Baekjoon._11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;
    public static int n;
    public static int [] numbers;
    public static int [] signs = new int[4];

    public static void dfs(int num, int idx){

        if(idx==n){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i=0; i<4; i++){

            if(signs[i]>0){

                signs[i]--;

                switch (i) {

                    case 0:
                        dfs(num + numbers[idx], idx+1);
                        break;
                    case 1:
                        dfs(num - numbers[idx], idx+1);
                        break;
                    case 2:
                        dfs(num * numbers[idx], idx+1);
                        break;
                    case 3:
                        dfs(num / numbers[idx], idx+1);
                        break;
                }

                signs[i]++;

            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        numbers = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)
            signs[i] = Integer.parseInt(st.nextToken());

        dfs(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);


    }
}
