package Java_Programmers.Level0;

public class 종이자르기 {
	
	/* 머쓱이는 큰 종이를 1 x 1 크기로 자르려고 합니다. 
	 * 예를 들어 2 x 2 크기의 종이를 1 x 1 크기로 자르려면 최소 가위질 세 번이 필요합니다.
	 * 정수 M, N이 매개변수로 주어질 때, 
	 * M x N 크기의 종이를 최소로 가위질 해야하는 횟수를 return 하도록 solution 함수를 완성해보세요.
	 * */
	
	//2	2	3
	//=> 가로 자르기 1(2-1)번 + 세로자르기 2번 =3
	//2	5	9
	//=> 가로자르기 1(2-1)번 + 세로자르기 8번(2*4) =9
	//1	1	0
	//=> 가로자르기 0 (1-1)번 + 세로자르기 (1* (1-1)) = 0번
	
    public int solution(int M, int N) {

        
        return (M-1) + (M * (N-1));
    }

	public static void main(String[] args) {

		종이자르기 a = new 종이자르기();
		
		System.out.println(a.solution(2, 2)); //3
		
		System.out.println(a.solution(2, 5)); //9
		
		System.out.println(a.solution(1, 1));	//0
		
	}

}
