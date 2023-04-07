package Java_이코테._04정렬;

import java.util.Arrays;

public class 퀵정렬 {

    public static void quickSort(int[] arr, int start, int end){

        if(start >= end)
            return;

        //index
        int pivot = start;
        int left = start +1;
        int right = end;

        while(left<=right){

            while(left<=end && arr[left]<=arr[pivot])
                left++;

            while(right>start && arr[right]>=arr[pivot])
                right--;

            //left와 right가 엇갈렸다
            // => 작은 데이터와 피벗을 교체
            if(left > right){
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }
            //엇갈리지 않았다
            // => 큰 데이터와 작은 데이터를 교체
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }

            System.out.println(Arrays.toString(arr));
        }

        //start와 end가 엇갈리면 재귀호출
        quickSort(arr, start, right-1);
        quickSort(arr, right+1, end);
    }

    public static void main(String[] args) {

        int [] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
