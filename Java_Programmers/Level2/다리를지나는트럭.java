package Java_Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

    // bridge_length대 올라갈 수 있으며, => 걸리는 시간에도 관여?
    // 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
    // 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0;
        int time = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int truck : truck_weights) {

            while(true) {
                // 큐가 비어있으면, 트럭을 넣음
                if (queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                    //큐의 크기와 다리길이가 같으면 앞의 트럭 뺌
                } else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                } else {
                    // 다음트럭이 올라갈수 있으면 추가
                    if (sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                    // 아니면 0을 추가
                    else {
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        return time + bridge_length;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int [] {7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int [] {10}));
        System.out.println(solution(100, 100, new int [] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}
