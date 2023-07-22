package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 줄서는방법_메모리초과 {

    public static List<int []> result = new ArrayList<>();

    //사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때,
    // k번째 방법을 return하는 solution 함수를 완성해주세요.
    public static int[] solution(int n, long k) {

        int [] input = new int [n];
        for(int i=0; i<input.length; i++)
            input[i] = i+1;

        //permutation (순서 보장)
        permutation(input, new int [n], new boolean[n], 0, n, n);

        for(int [] i : result)
            System.out.println(Arrays.toString(i));

        return result.get((int)k-1);
    }


    public static void permutation(int [] input, int [] output, boolean [] visited, int depth, int n, int r) {

        //여기가 뭔가 잘못되었다...
        if(depth==r) {
            result.add(output.clone());
//            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = input[i];
                permutation(input, output, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 5)));
    }
}
