package Java_Programmers.Level2;

import java.util.*;

public class 과제진행하기 {

    public static String[] solution(String[][] plans) {

        List<String> list = new ArrayList<>();

        //{과목, 시작시간, 남은시간} => 시작시간으로 정렬
        PriorityQueue<String []> pq = new PriorityQueue<>(
                (o1, o2) -> calcTime(o1[1]) - calcTime(o2[1]));

        //중단된 과제 넣어줄거
        //제일 최근에 중단한 순으로 꺼낸다고 했으니까 스택
        Stack<String []> stack = new Stack<>();

        for(String [] plan : plans)
            pq.offer(plan);

        while(!pq.isEmpty()) {

            String [] now = pq.poll();
            int currentTime = calcTime(now[1]);
            int takeTime = Integer.parseInt(now[2]);

            //새로운 과제가 남아있는 경우
            if(!pq.isEmpty()) {

                int nextTime = calcTime(pq.peek()[1]);

                //다음시간 전에 끝내고 시간이 남을 때
                if (currentTime + takeTime < nextTime) {
                    list.add(now[0]);
                    currentTime += takeTime;

                    //멈춘 과제중에 할수있는거 하기
                    while (!stack.isEmpty()) {
                        String[] stopTask = stack.pop();

                        //멈춘 과제를 다음 시작전까지 할수 있는 경우
                        if (currentTime + Integer.parseInt(stopTask[2]) <= nextTime) {
                            list.add(stopTask[0]);
                            currentTime += Integer.parseInt(stopTask[2]);
                        }
                        //멈춘 과제를 다음 시작전까지 할수 없으면
                        // 할수있는 만큼 하고 다시 스택에 넣기
                        else {
                            stopTask[2] = String.valueOf(Integer.parseInt(stopTask[2]) - (nextTime - currentTime));
                            stack.push(stopTask);
                            break;
                        }
                    }
                }
                //다음 시간 전에 끝내고 시간이 안남을 때
                else if (currentTime + takeTime == nextTime) {
                    list.add(now[0]);
                }
                //다음시간 전에 끝낼수 없으면 스택에 넣기
                else {
                    now[2] = String.valueOf(Integer.parseInt(now[2]) - (nextTime - currentTime));
                    stack.push(now);
                }
            }
            //새로운 과제가 없는 경우, 남은과제 다 꺼내기
            else {
                list.add(now[0]);

                while(!stack.isEmpty())
                    list.add(stack.pop()[0]);
            }
        }

        return list.toArray(new String [plans.length]);
    }

    public static int calcTime(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(
                solution(new String [][] {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}})));

        System.out.println(Arrays.toString(
                solution(new String [][] {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}})));
    }
}
