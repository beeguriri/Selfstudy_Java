package Java_이코테._02구현;

import java.util.Scanner;

public class 왕실의나이트 {

    /* 8X8 좌표 평면에서 나이트는 L자 형태로만 이동할 수 있으며 정원 밖으로는 나갈수 없다
    * 수평으로 두칸 이동한 뒤에 수직으로 한칸 이동하기
    * 수직으로 두칸 이동한 뒤에 수평으로 한칸 이동하기
    * 입력 : (열행, a1) 초기위치 행은 1~8로 표현, 열은 a~h로 표현
    * 출력 : 나이트가 이동할 수 있는 경우의 수 출력* */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int colI = (int)(s.charAt(0)) - 96;
        System.out.println("col: " + colI);
        int rowI = Integer.parseInt(s.split("")[1]);
        System.out.println("row: " + rowI);

        int answer = 0;

        if(colI-2 >=1) {
            if(rowI-1>=1) answer++;
            if(rowI+1<=8) answer++;
        }

        if(colI+2<=8) {
            if(rowI-1>=1) answer++;
            if(rowI+1<=8) answer++;
        }

        if(rowI-2>=1) {
            if(colI-1>=1) answer++;
            if(colI+1<=8) answer++;
        }

        if(rowI+2<=8) {
            if(colI-1>=1) answer++;
            if(colI+1<=8) answer++;
        }

        System.out.println(answer);

    }
}
 class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 현재 나이트의 위치 입력받기
        String inputData = sc.nextLine();
        int row = inputData.charAt(1) - '0';
        int column = inputData.charAt(0) - 'a' + 1;

        // 나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int result = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
        }

        System.out.println(result);
    }

}
