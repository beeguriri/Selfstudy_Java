package Java_이코테._05이진탐색;

public class 이진탐색 {

    //반복문으로 이진탐색
    public static int binarySearch(int[] arr, int target, int start, int end){

        while(start <= end) {

            int mid = (start+end)/2;

            if(target==arr[mid])
                return mid+1;

            //target이 중간값보다 작으면 왼쪽 확인
            else if(target<arr[mid])
                end = mid-1;

            //target이 중간값보다 크면 오른쪽 확인
            else
                start = mid+1;
        }
        return -1;
    }

    //재귀적으로 이진 탐색
    public static int binarySearchRecur(int[] arr, int target, int start, int end){

        if(start > end)
            return -1;

        int mid = (start+end)/2;

        if(target==arr[mid])
            return mid+1;

        //target이 중간값보다 작으면 왼쪽 확인
        else if (target<arr[mid])
            return binarySearchRecur(arr, target, start, mid-1);

        //target이 중간값보다 크면 오른쪽 확인
        else
            return binarySearchRecur(arr, target, mid+1, end);
    }

    public static void main(String[] args) {

        int [] arr1 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int [] arr2 = {1, 3, 5, 6, 9, 11, 13, 15, 17, 19};

        int target = 7;

        int result1 = binarySearch(arr1, target, 0, arr1.length-1);
        int result2 = binarySearch(arr2, target, 0, arr2.length-1);
        int result3 = binarySearchRecur(arr1, target, 0, arr1.length-1);
        int result4 = binarySearchRecur(arr2, target, 0, arr2.length-1);

        System.out.println(result1==-1? "원소가 존재하지 않습니다.": result1);
        System.out.println(result2==-1? "원소가 존재하지 않습니다.": result2);
        System.out.println(result3==-1? "원소가 존재하지 않습니다.": result3);
        System.out.println(result4==-1? "원소가 존재하지 않습니다.": result4);
    }
}
