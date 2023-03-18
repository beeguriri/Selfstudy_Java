package Java_Programmers.Level1;

import java.util.Stack;

public class 키패드누르기 {

    /*왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
    오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
    가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는
    두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
    만약 두 엄지손가락의 거리가 같다면,
    오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.*/

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int [][] nums = {{0,0}, {0,1}, {0,2},
                            {1,0}, {1,1}, {1,2},
                            {2,0}, {2,1}, {2,2},
                            {3,0}, {3,1}, {3,2}};
        Stack<int[]> leftS = new Stack<>();
        Stack<int[]> rightS = new Stack<>();
        leftS.push(nums[9]);
        rightS.push(nums[11]);

        for(int n : numbers) {
            switch (n) {
                case 1, 4, 7 :
                    answer.append("L");
                    leftS.push(nums[n-1]);
                    break;
                case 3, 6, 9 :
                    answer.append("R");
                    rightS.push(nums[n-1]);
                    break;
                case 2, 5, 8, 0 :
                    if (n==0) n=11;

                    int [] left = leftS.pop();
                    int [] right = rightS.pop();

                    int distL = Math.abs(left[0] - nums[n-1][0]) + Math.abs(left[1] - nums[n-1][1]);
                    int distR = Math.abs(right[0] - nums[n-1][0]) + Math.abs(right[1] - nums[n-1][1]);

                    if(distL<distR) {
                        answer.append("L");
                        leftS.push(nums[n-1]);
                        rightS.push(right);
                    }
                    else if (distL>distR) {
                        answer.append("R");
                        rightS.push(nums[n-1]);
                        leftS.push(left);
                    }
                    else {
                        if(hand.equals("left")) {
                            answer.append("L");
                            leftS.push(nums[n-1]);
                            rightS.push(right);
                        }
                        else {
                            answer.append("R");
                            rightS.push(nums[n-1]);
                            leftS.push(left);
                        }
                    }
                    break;
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        키패드누르기 a = new 키패드누르기();

        System.out.println(a.solution(new int [] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right")); //"LRLLLRLLRRL"
        System.out.println(a.solution(new int [] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left")); //"LRLLRRLLLRR"
    }
}
