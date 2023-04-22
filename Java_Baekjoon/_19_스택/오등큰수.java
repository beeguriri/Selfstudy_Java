package Java_Baekjoon._19_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 오등큰수 {

    /*Ai가 수열 A에서 등장한 횟수를 F(Ai)라고 했을 때,
    Ai의 오등큰수는 오른쪽에 있으면서
    수열 A에서 등장한 횟수가 F(Ai)보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
    그러한 수가 없는 경우에 오등큰수는 -1이다. */

    public static Map<Integer, Integer> map;

    public static String ngf(int [] num, int n) {

        int [] count = new int [n];
        for(int i=0; i<n; i++)
            count[i] = map.get(num[i]);

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {

            while(!stack.isEmpty() && count[stack.peek()]<count[i])
                num[stack.pop()] = num[i];

            stack.push(i);
        }

        while(!stack.isEmpty())
            num[stack.pop()] = -1;

        StringBuilder sb = new StringBuilder();
        for (int i: num)
            sb.append(i).append(" ");


        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] num = new int [n];

        map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
            map.put(num[i], map.getOrDefault(num[i], 0)+1);
        }

        System.out.println(ngf(num, n));

    }

}
