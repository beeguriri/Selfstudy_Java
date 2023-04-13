package Java_Baekjoon._20_큐와덱;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 카드2 {
    /*N장의 카드가 있다.
    각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며,
    1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
    N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오. */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++)
            q.add(i);

        while(q.size()>=2) {
            q.pop();
            q.add(q.pop());
        }

        System.out.println(q.pop());

    }
}
