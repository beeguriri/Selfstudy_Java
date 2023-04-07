package Java_이코테._04정렬;

public class 선택정렬 {

    public static void main(String[] args) {

        int [] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i=0; i<arr.length; i++){
            int min_index = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[min_index] > arr[j])
                    min_index = j;
            }

            //스와핑
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        for(int i : arr)
            System.out.print(i + " ");

    }
}
