package Java_이코테._02구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 상하좌우 {

    /*여행가 A는 N x N 크기의 정사각형 공간 위에 서있습니다
    * 이 공간은 1 x 1 크기의 정사각형으로 나누어져 있습니다.
    * 가장 왼쪽 위 좌표는 (1,1)이며
    * 가장 오른쪽 아래 좌표는 (N,N)에 해당합니다.
    * 여행가 A는 상,하,좌,우 방향으로만 이동할 수 있으며 시작 좌표는 항상 (1,1)입니다.
    * 계획서에는 하나의 줄에 띄어쓰기를 기준으로 L, R, U, D 문자가 반복적으로 적혀있습니다.
    * 공간을 벗어나는 움직임은 무시됩니다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); //행렬의 크기
        String [] str = br.readLine().split(" "); //좌표배열
        int posX = 1;
        int posY = 1;

        for(int i = 0; i<str.length; i++) {
            if(str[i].equals("U") && posX > 1)
                posX -= 1;

            if(str[i].equals("D") && posX < n)
                posX += 1;

            if(str[i].equals("L") && posY > 1)
                posY -= 1;

            if(str[i].equals("R") && posY < n)
                posY += 1;
        }

        sb.append(posX).append(" ").append(posY);
        System.out.println(sb);

        //5, R R R U D D => 3 4
    }
}
