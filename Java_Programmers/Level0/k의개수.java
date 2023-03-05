package Java_Programmers.Level0;

public class k의개수 {
	
	/* 1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다. 
	 * 정수 i, j, k가 매개변수로 주어질 때, 
	 * i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.
	 * 제한사항 : 0 ≤ k ≤ 9
	 * */

    public int solution(int i, int j, int k) {
        int answer = 0;
        String num_str = "";
        String k1 = String.valueOf(k);
        
        for (int a =i ; a <= j; a++) 
        	num_str += a;
        
        String [] temp = num_str.split("");
        
        for(int a = 0; a < temp.length; a++) 
        	if(temp[a].equals(k1))	answer++;
        
        return answer;
    }
	
	public static void main(String[] args) {
		k의개수 a = new k의개수();
			
		System.out.println(a.solution(1, 13, 1));	//6
		System.out.println(a.solution(10, 50, 5));	//5
		System.out.println(a.solution(3, 10, 2));	//0

	}

}
