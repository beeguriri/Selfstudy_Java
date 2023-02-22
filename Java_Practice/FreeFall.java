package Java_Practice;

public class FreeFall {
	
	static double distance;		
	static double acc = 9.81;	
	
	// 위치 계산용 메서드
	// 파라미터로 받을 값 : 초기위치, 초기속도, 시간
	double cal(double int_dist, double int_vel, int t) {
								
		distance = int_dist - 0.5*acc*t*t - int_vel*t;
		return distance;								// 위치 계산결과 반환
	}

	// 메인 메서드
	public static void main(String[] args) {
		
		double int_dist = 1000;
		double int_vel = 0;
		int int_time = 0;		
		int t[] = new int [100];
		
		FreeFall result = new FreeFall();		//참조변수로 메서드 인스턴스 생성준비(?)

		for (int i = 0; i < t.length; i++) {	//매 초 배열
			t[i] = (int_time + i);
		}
		
		for (int k : t) {							//매 초 마다
			result.cal(int_dist, int_vel, k);		//위치계산 메서드 호출
			if(distance<0)	break;					//위치가 0미만일때 계산(호출) 중지
			
			System.out.printf("%d초 후의 위치 : %.2f m\n", k, distance);
		}
	}
}
