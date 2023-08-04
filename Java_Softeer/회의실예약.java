package Java_Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실예약 {

    public static int N, M;
    public static String [] rooms;
    public static Map<String, List<int []>> map = new HashMap<>(); //룸, [시작시간, 종료시간]
    public static StringBuilder sb;
    public static StringBuilder print = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rooms = new String [N];
        for(int i=0; i<N; i++) {
            rooms[i] = br.readLine();
            map.put(rooms[i], new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String room = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int [] time = {start, end};
            List<int[]> temp = map.get(room);
            temp.add(time);
            map.put(room, temp);
        }

        Arrays.sort(rooms);

        for(String room : rooms) {
            List<int[]> list = map.get(room);
//            Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);
//
//            System.out.println(room);
//            for(int [] i : list)
//                System.out.println(Arrays.toString(i));

            int [] time = new int [19]; //9-18까지 쓸래
            for(int [] i : list) {
                //시간배열 채우기
                for(int j=i[0]; j<=i[1]; j++){
                    time[j] = j;
                }
            }
//            System.out.println(Arrays.toString(time));
            List<String> result = new ArrayList<>();
            int start = 0; int end = 0;
            for(int i=9; i<=18; i++) {
                if(time[i]==0){
                    start = i-1;
                    int idx = start+1;
                    while(idx<18){
                        if(time[idx]!=0) {
                            end = idx;
                            break;
                        }
                        idx++;
                    }
                    i = idx;

                    sb = new StringBuilder();
                    sb.append(start == 8 ? "09" : start).append("-").append(idx==18?"18":end);
                    result.add(sb.toString());
                }
            }
            System.out.println(result);

            //방에 대한 정보 출력
            print.append("Room ").append(room).append(":").append("\n");
            if(result.size()==0)
                print.append("Not available\n");
            else
                print.append(result.size()).append(" available:").append("\n");
            for(String s : result)
                print.append(s).append("\n");
            if(!room.equals(rooms[rooms.length-1]))
                print.append("-----\n");

        }

        System.out.print(print);
    }
}

