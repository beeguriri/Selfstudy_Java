package practice;

import java.util.Scanner;

public class BinaryTest {
	
	//임의의 수를 입력 받아 2진수로 변환
	//2진수 : 숫자/2 의 나머지를 역순으로 출력
	
	static void binaryChange(int num) {
		
		int [] remainder = new int [10]; //나머지
		int i = 0 ;
		
		while (num > 0) {
			
			remainder [i] = num % 2;
			num = num / 2;
			i++;

		}
		
		System.out.print("2진수 출력 : ");

		for (i = remainder.length; i>0; i--) {
			
				System.out.print(remainder[i-1] + "  ");
		}
		
		//입력 : 13
		//출력 : 0 0 0 0 0 0 1 1 0 1 
		//     (배열은 비어있는 칸 0으로 초기화 되어있으므로..)
		
		System.out.println();

	}
	
	
	static void binaryChange1(int num) {
		
		String remainder = ""; //나머지를 string type으로 선언
		
		while (num > 0) {
			
			remainder = (num % 2) + remainder;
				//제일 최근 저장한 값 위로 이전 값 저장하기!
				//+= 연산자의 반대 (remainder = remainder + (num % 2))
			num = num / 2;

		}
		
		System.out.print("2진수 출력 : " + remainder );

	}
	

	public static void main(String[] args) {
		
		System.out.println("숫자를 입력하세요 : ");
		try (Scanner sc = new Scanner(System.in)) {
			int num = sc.nextInt();	
			
			binaryChange(num);
			binaryChange1(num);
		}
		
	}

}
