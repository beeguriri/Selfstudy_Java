package Java_이코테._01그리디;

import java.util.*;

public class 큰수의법칙 {

    /*배열의 크기 N, 숫자가 더해지는 횟수 M, 최대 더해질수있는 횟수 K
    * 서로 다른 인덱스에 해당되는 같은 수는 서로 다른 것으로 간주한다.
    * 더해지는 최대값 구하기*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //n,m,k를 공백을 기준으로 구분하여 입력받기
        System.out.printf("n, m, k 입력 : " );
        int n = sc.nextInt();   //5; //입력받는 배열의 수
        int m = sc.nextInt();   //8; //전체 최대 더하는 횟수
        int k = sc.nextInt();   //3; //한 숫자당 최대 더하는 횟수

        System.out.printf("%d개 숫자 입력 : ", n);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++)
            list.add(sc.nextInt()); //2 4 5 4 6

        Collections.sort(list);

        int first = list.get(n-1); //가장 큰 수
        int second = list.get(n-2); //두번째로 큰 수

        //가장 큰 수가 더해지는 횟수
        //(6+6+6+5) + (6+6+6+5)
        int cnt = (m/(k+1)) * k; //6이 3번씩(k) 2번(m/k+1)
        cnt += m%(k+1); //나머지는 k보다 작으므로 전부 제일 큰수 더하는 횟수

        int answer = 0;
        answer += cnt * first;
        answer += (m-cnt) * second;

        System.out.println(answer);




    }
}
