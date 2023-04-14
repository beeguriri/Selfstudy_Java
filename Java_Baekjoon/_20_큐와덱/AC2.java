package Java_Baekjoon._20_큐와덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AC2 {

    public static String ac(Deque<Integer> q, String p) {

        StringBuilder sb = new StringBuilder();
        boolean dir = true; //true : first, false : last

        for(char c : p.toCharArray()) {

            if(c == 'R')
                dir = !dir;
            else {
                if(q.isEmpty()) {
                    return "error";
                } else {
                    if(dir)
                        q.pollFirst();
                    else
                        q.pollLast();
                }
            }
        }

        sb.append("[");

        while(q.size()>1){
            if(dir)
                sb.append(q.pollFirst()).append(",");
            else
                sb.append(q.pollLast()).append(",");
        }

        if(!q.isEmpty())
            sb.append(q.poll());

        sb.append("]");
        return sb.toString();

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t_case = Integer.parseInt(br.readLine());

        for(int t=0; t<t_case; t++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            Deque<Integer> q = new LinkedList<>();

            for(int i=0; i<n; i++)
                q.offer(Integer.parseInt(st.nextToken()));

            //System.out.println(q);

            System.out.println(ac(q, p));

            //System.out.println(q);
        }
    }
}
