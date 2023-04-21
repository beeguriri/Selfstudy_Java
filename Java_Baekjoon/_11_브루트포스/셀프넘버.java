package Java_Baekjoon._11_브루트포스;

public class 셀프넘버 {

    public static void main(String[] args) {

        boolean [] check = new boolean [10001];

        for(int i=1; i<=10000; i++) {

            int sum = i;
            int x = i;

            while(x>0){
                sum += x%10;
                x /= 10;
            }

            if(sum<=10000)
                check[sum] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10000; i++)
            if (!check[i])
                sb.append(i).append("\n");

        System.out.println(sb);
    }
}
