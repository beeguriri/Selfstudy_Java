package Java_Practice.sort;

import java.util.Arrays;

public class QuickSort {

    static void quickSort(int [] arr, int left, int right) {

        int pl = left;
        int pr = right;
        int pivot = arr[(pl+pr)/2];

        while(pl<=pr){

            while(arr[pl]<pivot) pl++;

            while(arr[pr]>pivot) pr--;

            if(pl<=pr){
                int temp = arr[pl];
                arr[pl] = arr[pr];
                arr[pr] = temp;
                pl++;
                pr--;
            }

            if(left<pr) quickSort(arr, left, pr);
            if(pl<right) quickSort(arr, pl, right);

        }

    }

    public static void main(String[] args) {

        int [] arr = {1, 5, 3, 2, 7, 4};
        quickSort(arr, 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
