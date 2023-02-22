package practice;

import java.util.Scanner;

public class GODTest {

//	최대공약수, 최소공배수 구하기 (유클리드 호제법)
//	1.입력 받은 두 개의 정수 중 큰 정수를 max, 작은 정수를 min
//	2.rem = max%min
//	3.rem이 0이면 → 최대공약수 = 작은 정수, 최소공배수 = 두 정수의 곱 / 최대공약수
//	4.rem이 0이 아니면 → max = min, min = rem 반복
	
	static void godTest(int num1, int num2) {
		
		int min = 0;
		int max = 0;
		
		//min, max 정하기
		if (num1>num2) {			
			max = num1;
			min = num2;
		} else {
			max = num2;
			min = num1;
		}
		
		int rem = max % min;
		
		//rem=0이면, 최대공약수는 min, 최소공배수는 max
		//rem!=0이면, while문 반복
		
		while (rem != 0) {
			max = min;
			min = rem;
			rem = max % min;
		} System.out.printf("최대공약수는 %d, 최소공배수는 %d 입니다. \n", 
								min, (num1 * num2 / min));
		
	}
	
	
	public static void main(String[] args) {

		System.out.println("숫자 두개를 입력하세요 : ");
		try (Scanner sc = new Scanner(System.in)) {
			
			int num1 = sc.nextInt();     //입력받은 숫자 1
			int num2 = sc.nextInt();     //입력받은 숫자 2
			
			System.out.printf("입력한 숫자는 %d, %d입니다.\n", num1, num2);
			
			godTest(num1, num2);
		}		
		
	}

}
