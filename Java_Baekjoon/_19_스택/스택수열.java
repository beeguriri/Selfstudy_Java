package Java_Baekjoon._19_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 스택수열 {

    /*첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.
    둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다.
    물론 같은 정수가 두 번 나오는 일은 없다.
    입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.
    push연산은 +로, pop 연산은 -로 표현하도록 한다.
    불가능한 경우 NO를 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        int [] arr = new int [n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int [] arr_copy = Arrays.copyOf(arr, n);

        Arrays.sort(arr_copy);
        StringBuilder sb = new StringBuilder();

        int j = 0;
        for(int i=0; i<n; i++) {

            stack.push(arr_copy[i]);
            sb.append("+\n");

            if (!stack.isEmpty() && stack.peek() == arr[j] && j<n) {
                while(!stack.isEmpty() && stack.peek() == arr[j]) {
                    sb.append("-\n");
                    stack.pop();
                    j++;
                }
            }
        }


        if(!stack.isEmpty())
            System.out.println("NO");
        else
            System.out.println(sb);
    }
}
