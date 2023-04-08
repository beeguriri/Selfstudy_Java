package Java_이코테._05이진탐색;

public class 정렬된배열에서특정수의개수구하기 {

    /*일반적인 선형탐색으로 문제풀 경우 시간초과판정
    * 이진탐색을 통해 첫번째 값을 찾고
    * 이진탐색을 통해 마지막 값을 찾은 후 각각의 인덱스를 빼주면 중복개수*/
    public static int lowerBound(Integer[] arr, int target, int start, int end){

        while(start < end){

            int mid = (start+end)/2;

            if(target<=arr[mid])
                end = mid;

            else
                start = mid + 1;
        }
        return end;
    }

    public static int upperBound(Integer[] arr, int target, int start, int end){

        while(start < end){

            int mid = (start+end)/2;

            if(target<=arr[mid])
                start = mid+1;

            else
                end = mid;
        }
        return end-1;
    }

    public static void main(String[] args) {

        Integer [] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;

        int start = lowerBound(arr, target, 0, arr.length-1);
        int end = upperBound(arr, target, 0, arr.length-1);

        System.out.println("start: " + start);
        System.out.println("end: " + end);
        System.out.println(end-start+1);
    }
}
