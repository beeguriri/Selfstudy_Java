package practice;

public class MatrixMulti {

	//배열 곱하기 A[][] * B[]*[] = C [][]
	
	public static void main(String[] args) {

		int a[][] = new int [5][4];
		int b[][] = new int [4][3];
		int c[][] = new int [a.length][b[0].length];
		
		//랜덤배열 A,B 생성
		System.out.println("=====  배열 A  =====");
		for(int i=0; i < a.length; i++) {   		//행만큼 반복
			for(int j=0; j < a[0].length; j++) {	//열만큼 반복  
				
				double rnum = Math.random();		//0~1사이의 랜덤수 생성
				int num = (int) (rnum * 10);		//0.x *10해서 한자리수로 만들어주기
				a[i][j] = num++;
				System.out.print(a[i][j] + "\t");
			}
			
			System.out.println();
		}
		
		System.out.println("\n=====  배열 B  =====");
		for(int i=0; i < b.length; i++) {   		
			for(int j=0; j < b[0].length; j++) {	
				
				double rnum = Math.random();		
				int num = (int) (rnum * 10);		
				b[i][j] = num++;
				System.out.print(b[i][j] + "\t");
			}
			
			System.out.println();
		}
		
		//배열 곱하기
		System.out.println("\n=====  배열 C = A * B  =====");
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<b[0].length; j++) {
				for(int k=0; k<b.length; k++) {
					
					c[i][j] += a[i][k] * b[k][j];
				}
				
				System.out.print(c[i][j] + "\t");
			}
			
			System.out.println();

		}

	}

}
