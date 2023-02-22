package Java_Practice;

import java.util.Scanner;

public class MultipleTable {

	//입력받은 column수 만큼 나란히 구구단을 출력하는 메서드
	public static void multiple(int col) {		
				
		for (int i=2; i<=9; i+=col) {
			for(int j=1; j<=9; j++) {
				for(int k=0; k<col; k++) {	//column수만큼 나란히 출력
					
					if ((i+k)>9) {	//i+k값이 9보다 크면 루프중단
						break;
					}
					System.out.printf("%d * %d = %2d\t",(i+k),j,(i+k)*j);
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int col=0;
		
		//scanner : column값 입력 받음
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Column : ");
			col = scanner.nextInt();
			} catch (Exception e) {
		}
		
		System.out.println("====================");
		
		//구구단 메서드 호출
		multiple(col);		
				
	}
}
