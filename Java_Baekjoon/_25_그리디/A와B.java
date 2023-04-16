package Java_Baekjoon._25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class A와B {

    /* 두 문자열 S와 T가 주어졌을 때, S를 T로 바꾸는 게임이다.
    문자열의 뒤에 A를 추가한다.
    문자열을 뒤집고 뒤에 B를 추가한다.
    S를 T로 바꿀 수 있으면 1을 없으면 0을 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        Deque<Character> q = new LinkedList<>();
        for(char c: t.toCharArray())
            q.offer(c);

        boolean dir = true;
        while(q.size()>s.length()) {
            if(dir) {
                if (q.peekLast() == 'A')
                    q.pollLast();
                else {
                    q.pollLast();
                    dir = !dir;
                }
            } else {
                if (q.peekFirst() == 'A')
                    q.pollFirst();
                else {
                    q.pollFirst();
                    dir = !dir;
                }
            }
        }

        String temp = "";
        if(dir) {
            while(!q.isEmpty())
                temp += q.pollFirst();
        } else {
            while(!q.isEmpty())
                temp += q.pollLast();
        }

        if(temp.equals(s))
            System.out.println(1);
        else
            System.out.println(0);

    }

}
