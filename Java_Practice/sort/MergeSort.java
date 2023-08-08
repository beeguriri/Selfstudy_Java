package Java_Practice.sort;

import java.util.Arrays;

//오름차순 -> 최대힙 정렬
public class MergeSort {

    public static int [] sorted;

    static void mergeSort(int [] arr){
        sorted = new int [arr.length];
        mergeSort(arr, 0, arr.length-1);
        sorted = null;
    }

    static void mergeSort(int [] arr, int left, int right){

        if(left==right)
            return;

        int mid = (left+right)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        merge(arr, left, mid, right);
    }

    static void merge(int [] arr, int left, int mid, int right) {

        int pl = left;
        int pr = mid+1;
        int idx = left;

        while(pl<=mid && pr<=right){

            if(arr[pl]<=arr[pr])
                sorted[idx++] = arr[pl++];
            else
                sorted[idx++] = arr[pr++];
        }

        if(pl>mid)
            while(pr<=right)
                sorted[idx++] = arr[pr++];
        else
            while (pl<=mid)
                sorted[idx++] = arr[pl++];

        for(int i=left; i<=right; i++)
            arr[i] = sorted[i];

    }

    public static void main(String[] args) {

        int [] arr = new int [10];
        for(int i=0; i<10; i++)
            arr[i] = (int) (Math.random() * 30);

        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
