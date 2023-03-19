package Java_Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 바탕화면정리 {

    /* 바탕화면의 격자점들은 바탕화면의 가장 왼쪽 위를 (0, 0)으로 시작해 (세로, 가로)로 표현합니다.
    빈칸은 ".", 파일이 있는 칸은 "#"의 값을 가집니다.
    점 S(lux, luy)에서 점 E(rdx, rdy)로 드래그를 할 때, "드래그 한 거리"는 |rdx - lux| + |rdy - luy|로 정의합니다.
    머쓱이의 컴퓨터 바탕화면의 상태를 나타내는 문자열 배열 wallpaper가 매개변수로 주어질 때
    바탕화면의 파일들을 한 번에 삭제하기 위해 최소한의 이동거리를 갖는
    드래그의 시작점과 끝점을 담은 정수 배열을 return하는 solution 함수를 작성해 주세요.
    드래그의 시작점이 (lux, luy), 끝점이 (rdx, rdy)라면 정수 배열 [lux, luy, rdx, rdy]를 return하면 됩니다.
     * */
    public int[] solution(String[] wallpaper) {
        int[] answer = new int [4];
        int minX = 100;
        int minY = 100;
        int maxX = 0;
        int maxY = 0;

        for(int i=0; i<wallpaper.length; i++){
            if (wallpaper[i].contains("#")) {
                minX = Math.min(i, minX);
                maxX = Math.max(i, maxX);
                minY = Math.min(wallpaper[i].indexOf("#"), minY);
                maxY = Math.max(wallpaper[i].lastIndexOf("#"), maxY);
            }
        }

        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX + 1;
        answer[3] = maxY + 1;

        return answer;
    }

    public static void main(String[] args) {
        바탕화면정리 a = new 바탕화면정리();

        String [] wall1 = {".#...", "..#..", "...#."};
        System.out.println(Arrays.toString(a.solution(wall1))); //[0, 1, 3, 4]

        String [] wall2 = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        System.out.println(Arrays.toString(a.solution(wall2))); //[1, 3, 5, 8]

        String [] wall3 = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        System.out.println(Arrays.toString(a.solution(wall3))); //[0, 0, 7, 9]

        String [] wall4 = {"..", "#."};
        System.out.println(Arrays.toString(a.solution(wall4))); //[1, 0, 2, 1]

    }
}
