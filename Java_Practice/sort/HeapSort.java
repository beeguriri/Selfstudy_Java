package Java_Practice.sort;

import java.util.Arrays;

//오름차순 -> 최대힙 정렬
public class HeapSort {

    static void heapSort(int [] arr) {

        //힙 생성
        heapify(arr, arr.length-1);
        System.out.println("힙 생성: " + Arrays.toString(arr));

        //최대값 추출 후
        //다시 힙 생성
        int count = 1;
        for(int i=arr.length-1; i>0; i--){
            swap(arr, 0, i);
            heapify(arr, i-1);
            System.out.println(count++ +"번째: " + Arrays.toString(arr));
        }

    }

    static void heapify(int [] arr, int lastIdx){
        for(int i=1; i<=lastIdx; i++){

            int child = i;

            while(child>0){

                int parent = (child-1)/2;

                if(arr[child]>arr[parent]){
                    swap(arr, child, parent);
                }
                child = parent;
            }
        }
    }

    static void swap(int [] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {

//        int [] arr = {1, 5, 3, 2, 7, 4};
        int [] arr = new int [10];
        for(int i=0; i<10; i++)
            arr[i] = (int) (Math.random() * 30);

        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
