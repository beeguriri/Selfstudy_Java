package Java_Baekjoon._20_큐와덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 덱 {

    /*push_front X: 정수 X를 덱의 앞에 넣는다.
    push_back X: 정수 X를 덱의 뒤에 넣는다.
    pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다.
    만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다.
    만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 덱에 들어있는 정수의 개수를 출력한다.
    empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
    front: 덱의 가장 앞에 있는 정수를 출력한다.
    만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 덱의 가장 뒤에 있는 정수를 출력한다.
    만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){

            String s = br.readLine();
            String sel;
            int x=0;

            if(s.length()>=11) {
                sel = s.split(" ")[0];
                x = Integer.parseInt(s.split(" ")[1]);
            } else
                sel = s;

            switch (sel){

                case "push_front":
                    q.offerFirst(x);
                    break;

                case "push_back":
                    q.offerLast(x);
                    break;

                case "pop_front":
                    if(q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(q.pollFirst()).append("\n");
                    break;

                case "pop_back":
                    if(q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(q.pollLast()).append("\n");
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
                    if(q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(q.peekFirst()).append("\n");
                    break;

                case "back":
                    if(q.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(q.peekLast()).append("\n");
                    break;

            }
        }
        System.out.println(sb);
    }
}
