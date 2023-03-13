package Java_Programmers.Level1;

public class 최소직사각형 {

    /*모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
    모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때,
    지갑의 크기를 return 하도록 solution 함수를 완성해주세요.*/

    public int solution(int[][] sizes) {
        int w =0; int h=0;

        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0]<=sizes[i][1]){
                int temp = 0;
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            if(w < sizes[i][0])     w = sizes[i][0];
            if(h < sizes[i][1])     h = sizes[i][1];
        }
        return w*h;
    }

    public static void main(String[] args) {

        최소직사각형 a = new 최소직사각형();

        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(a.solution(sizes1)); //4000

        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println(a.solution(sizes2)); //120

        int[][] sizes3 = {{3,4}, {2,1}};
        System.out.println(a.solution(sizes3));
        //[[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
    }
}
