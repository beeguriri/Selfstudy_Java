package Java_Programmers.Level0;

public class 개미군단 {
	
	/* 개미 군단이 사냥을 나가려고 합니다. 
	 * 개미군단은 사냥감의 체력에 딱 맞는 병력을 데리고 나가려고 합니다. 
	 * 장군개미는 5의 공격력을, 병정개미는 3의 공격력을 일개미는 1의 공격력을 가지고 있습니다. 
	 * 예를 들어 체력 23의 여치를 사냥하려고 할 때, 일개미 23마리를 데리고 가도 되지만, 
	 * 장군개미 네 마리와 병정개미 한 마리를 데리고 간다면 더 적은 병력으로 사냥할 수 있습니다. 
	 * 사냥감의 체력 hp가 매개변수로 주어질 때, 
	 * 사냥감의 체력에 딱 맞게 최소한의 병력을 구성하려면 
	 * 몇 마리의 개미가 필요한지를 return하도록 solution 함수를 완성해주세요.
	 * */
	
	static int solution(int hp) {
		
		int jang = 0;
		int byung = 0;
		int ill = 0;
		
		jang = hp/5;
		hp = hp%5;
		byung = hp/3;
		hp = hp%3;
		ill = hp/1;
		
        int answer = jang + byung + ill;
        return answer;
    }
	
	static int solution1 (int hp) {
		
		int answer = 0;
		
		answer = hp/5 + (hp%5/3) + (hp%5%3);
		
		return answer;
	}

	public static void main(String[] args) {

		System.out.println("ans1 " + solution(23)); //5
		System.out.println("ans2 " + solution(24)); //6
		System.out.println("ans3 " + solution(999)); //201
		
		System.out.println("ans1 " + solution1(23));
		System.out.println("ans2 " + solution1(24));
		System.out.println("ans3 " + solution1(999));


		
	}

}
