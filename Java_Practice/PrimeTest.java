package Java_Practice;

import java.util.Scanner;

public class PrimeTest {
	
	// 소수판단 : 임의의 수를 입력받아 해당 수가 소수인지 확인
	// 소수 : 1과 자기자신으로만 나누어지는 수
	//	num % [2~자기자신보다 작은수]로 나누어지지않으면 : 소수
	//  num % [2~자기자신보다 작은 어떤수]로 나누어지면 : 소수아님
	

	public static void prime1(int num) {
		
		for (int i = 2; i < num;) {
			
			if(num % i == 0) {
				System.out.println("소수가 아닙니다."); break;
			} else {
				System.out.println("소수 입니다.");	 break;
			}
		}
	}
	
	public static boolean prime2(int num) {
		
		for (int i = 2; i < num; i++) {
			
			if(num % i == 0) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
			
		//임의의 수 입력
		//1 이하의 숫자 입력하면 프로그램 실행되지 않음
		//정수를 입력받으면 프로그램 실행
		
		/*try-with-resources 사용안하면 'sc' is never closed 경고문구 생김
		Scanner sc = new Scanner(System.in);	 */
				
		//try-with-resources : try-catch문이 완료되면 자원을 해제
		try(Scanner sc = new Scanner(System.in)) {		
			
			System.out.println("숫자를 입력하세요 : ");
			int num = sc.nextInt();
			
			while (num > 0) {
				
				prime1(num);

				if (prime2(num) == true) System.out.println("TRUE : 소수 입니다.");
				else 					System.out.println("FALSE : 소수가 아닙니다.");
				break;
			}
		}
	} 
}
