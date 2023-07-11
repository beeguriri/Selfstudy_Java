package Java_Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class 순열과조합 {

    public static void permutation (int [] input, int [] output, boolean [] visitied, int depth, int n, int r) {

        //dfs 종료조건
        if(depth==r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visitied[i]) {
                visitied[i] = true;
                output[depth] = input[i];
                permutation(input, output, visitied, depth+1, n, r);
                visitied[i] = false;
            }
        }
    }

    public static void permutation_char (char [] input, char [] output, boolean [] visitied, int depth, int n, int r) {

        //dfs 종료조건
        if(depth==r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visitied[i]) {
                visitied[i] = true;
                output[depth] = input[i];
                permutation_char(input, output, visitied, depth+1, n, r);
                visitied[i] = false;
            }
        }
    }

    public static void dupPermutation (int [] input, int [] output, int depth, int n, int r) {

        //dfs 종료조건
        if(depth==r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i=0; i<n; i++) {
                output[depth] = input[i];
                dupPermutation(input, output, depth+1, n, r);
        }

    }

    static void combination(int [] input, int [] output, int depth, int start, int n, int r) {

        //dfs 종료조건
        if(depth == r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i=start; i<n; i++) {
            output[depth] = input[i];
            combination(input, output, depth+1, i+1, n, r);
        }
    }

    static void charCombination(char [] input, char [] output, int depth, int start, int n, int r) {

        //dfs 종료조건
        if(depth == r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i=start; i<n; i++) {
            output[depth] = input[i];
            charCombination(input, output, depth+1, i+1, n, r);
        }
    }

    static void dupCombination(int [] input, int [] output, int depth, int start, int n, int r) {

        //dfs 종료조건
        if(depth == r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i=start; i<n; i++) {
            output[depth] = input[i];
            dupCombination(input, output, depth+1, i, n, r);
        }
    }

    public static void main(String[] args) {

        int [] input = {1, 2, 3, 4, 5};
        char [] input_char = {'a', 'b', 'c', 'd', 'e'};
        int n = 5; int r = 3;
//        permutation(input, new int [r], new boolean[n], 0, n, r);
//        permutation_char(input_char, new char[r], new boolean[n], 0, n, r);
        System.out.println("=".repeat(30));
//        dupPermutation(input, new int [r], 0, n, r);
//        combination(input, new int[r], 0, 0, n, r);
        charCombination(input_char, new char[r], 0, 0, n, r);
//        dupCombination(input, new int[r], 0, 0, n, r);

    }
}
