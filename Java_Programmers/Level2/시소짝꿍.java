package Java_Programmers.Level2;

import java.util.Arrays;

public class 시소짝꿍 {

    //이 시소는 중심으로부터 2(m), 3(m), 4(m) 거리의 지점에 좌석이 하나씩 있습니다.
    //2*x = 2*y;
    //2*x = 3*y;
    //2*x = 4*y;
    //3*x = 4*y;
    public static long solution(int[] weights) {

        long answer = 0;

        Arrays.sort(weights);

        //x 보다 y가 더 크도록 정렬 후 찾기
        int [][] ratio = {{2, 2}, {3, 2}, {4, 2}, {4, 3}};

        for(int [] r : ratio) {
            for(int i=0; i<weights.length-1; i++) {
                int x = weights[i];

                if(x * r[0] % r[1] != 0)
                    continue;

                int y = x * r[0] / r[1];

                int upper = upperBound(weights, i+1, weights.length-1, y);
                int lower = lowerBound(weights, i+1, upper-1, y);

                answer += (upper - lower);
            }
        }

        return answer;
    }

    public static int lowerBound(int [] arr, int low, int high, int target) {

        while(low<=high) {
            int mid = (low + high) / 2;
            if(arr[mid]<target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return  low;
    }

    //제일 마지막 다음 중복값
    public static int upperBound(int [] arr, int low, int high, int target) {

        while(low<=high) {
            int mid = (low + high) / 2;
            if(arr[mid]<=target)
                low = mid + 1;
            else
                high = mid -1;
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int [] {100,180,360,100,270})); //4
    }
}
