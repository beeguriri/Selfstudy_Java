package Java_이코테.ch03그리디;

import java.util.*;

public class 모험가길드 {
    /* 모험가 N명
    * 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹
    * 그룹수의 최댓값*/
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("모험가 구성원수 N을 입력하세요 : ");
        int n = sc.nextInt();

        System.out.println("공포도가 X인 모험가 그룹을 입력하세요 : ");
        for(int i=0; i<n; i++)
            list.add(sc.nextInt());

        //int [] x = {2, 3, 1, 2, 2};
        //int n = 5;
        int answer = 0;
        int cnt = 0; //그룹이 결성될때마다 0으로 리셋

        // 공포도가 낮은 순서로 그룹 만들기
        Collections.sort(list);

        for(int i = 0; i<n; i++) {
            cnt++;  //현재 그룹에 모험가 포함
            if (cnt >= list.get(i)) {
                answer++;
                cnt = 0;
            }
        }

        System.out.println(answer);
    }
}
