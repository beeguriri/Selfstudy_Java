package Java_Baekjoon._20_큐와덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 큐2 {

    /*push X: 정수 X를 큐에 넣는 연산이다.
    pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다.
    만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 큐에 들어있는 정수의 개수를 출력한다.
    empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
    front: 큐의 가장 앞에 있는 정수를 출력한다.
    만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 큐의 가장 뒤에 있는 정수를 출력한다.
    만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.*/


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++){
            String s = br.readLine();
            String sel;
            int num=0;

            if(s.length()>=6) {
                sel = s.split(" ")[0];
                num = Integer.parseInt(s.split(" ")[1]);
            } else
                sel = s;

            switch (sel) {

                case "push":
                    q.offer(num);
                    break;

                case "pop":
                    if(!q.isEmpty())
                        sb.append(q.poll()).append("\n");
                    else
                        sb.append("-1\n");
                    break;

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "empty":
                    if(q.isEmpty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;

                case "front":
                    if(!q.isEmpty())
                        sb.append(q.peekFirst()).append("\n");
                    else
                        sb.append("-1\n");
                    break;

                case "back":
                    if(!q.isEmpty()) {
                        sb.append(q.peekLast()).append("\n");
                    }
                    else
                        sb.append("-1\n");
                    break;
            }

        }

        System.out.println(sb);
    }


}
