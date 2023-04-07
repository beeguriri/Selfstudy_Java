package Java_이코테._04정렬;

public class 계수정렬 {

    public static void main(String[] args) {

        int [] arr = {7, 5, 9, 0, 3, 6, 2, 9, 4, 8, 0, 5, 2};
        int max = Integer.MIN_VALUE;

        for(int i : arr)
            max = Math.max(max, i);

        int [] cnt = new int [max+1];

        for(int i : arr)
            cnt[i] += 1;

        for (int i=0; i<cnt.length; i++)
            for (int j = 0; j < cnt[i]; j++)
                System.out.print(i+ " ");
    }
}
