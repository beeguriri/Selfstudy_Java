package Java_Baekjoon.구현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요새푸스문제 {

    //N명의 사람이 있을 때
    //순서대로 K번째 사람 제거
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!queue.isEmpty()) {
            for(int i=1; i<k; i++){
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }

        String answer = sb.substring(0, sb.length()-2);
        answer += ">";

        System.out.println(answer);
    }
}
