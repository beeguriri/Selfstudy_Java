package Java_Programmers.Level1.재도전;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 비밀지도 {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String [n];

        String [] arr1B = new String [n];
        String [] arr2B = new String [n];

        for (int i = 0; i < n; i++) {
            arr1B[i] = Integer.toString(arr1[i], 2);
            arr2B[i] = Integer.toString(arr2[i], 2);
        }

        for (int i = 0; i < n; i++) {
            List<String> arr1L = new ArrayList<>(Arrays.asList(arr1B[i].split("")));
            List<String> arr2L = new ArrayList<>(Arrays.asList(arr2B[i].split("")));

            int idx1 = 0;
            while(arr1L.size()<n){
                arr1L.add(idx1++, "0");
                if(arr1L.size()==n)
                    break;
            }

            int idx2 = 0;
            while(arr2L.size()<n){
                arr2L.add(idx2++, "0");
                if(arr2L.size()==n)
                    break;
            }

//            System.out.println(arr1L);
//            System.out.println(arr2L);

            StringBuilder temp = new StringBuilder();
            for (int j = 0; j <n; j++) {
                if(arr1L.get(j).contains("0") && arr2L.get(j).contains("0"))
                    temp.append(" ");
                else
                    temp.append("#");
            }
            answer[i] = String.valueOf(temp);
//            System.out.println("answer[i]: " + answer[i]);
        }

        return answer;
    }

    public static void main(String[] args) {

        비밀지도 a = new 비밀지도();

        int [] arr1 = {46, 33, 33 ,22, 31, 50};
        int [] arr2 = {27 ,56, 19, 14, 14, 10};

        System.out.println(Arrays.toString(a.solution(6, arr1, arr2)));
    }
}
