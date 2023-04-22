package Java_Baekjoon._19_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {

    /*크기가 N인 수열 A = A1, A2, ..., AN이 있다.
    수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다.
    Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
    그러한 수가 없는 경우에 오큰수는 -1이다.*/

    public static Stack<Integer> stack = new Stack<>();

    public static String nge(int [] arr){

        for(int i=0; i<arr.length; i++){

            while(!stack.isEmpty() && arr[stack.peek()]<arr[i])
                arr[stack.pop()] = arr[i];

            stack.push(i);
        }

        while(!stack.isEmpty())
            arr[stack.pop()] = -1;

        StringBuilder sb = new StringBuilder();
        for(int i: arr)
            sb.append(i).append(" ");

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(nge(arr));


        // 시간초과
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i<n-1; i++){
//            for(int j=i+1; j<n; j++) {
//
//                if (arr[i] < arr[j]) {
//                    sb.append(arr[j]).append(" ");
//                    break;
//                }
//
//                if(j==(n-1))
//                    sb.append(-1).append(" ");
//            }
//        }
//        sb.append(-1).append(" ");
//        System.out.println(sb);
    }
}
