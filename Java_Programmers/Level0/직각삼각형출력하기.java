package Java_Programmers.Level0;

import java.util.Scanner;

public class 직각삼각형출력하기 {
	
	/*"*"의 높이와 너비를 1이라고 했을 때, "*"을 이용해 직각 이등변 삼각형을 그리려고합니다. 
	 * 정수 n 이 주어지면 높이와 너비가 n 인 직각 이등변 삼각형을 출력하도록 코드를 작성해보세요.
	 * 1 ≤ n ≤ 10
	 * */

	public static void main(String[] args) {
		
		System.out.println("반복횟수 입력: ");
        try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			
			String a = "*";
			
			for(int i =1; i<=n; i++) {
				System.out.println(a.repeat(i));
			}
		}
	}

}
