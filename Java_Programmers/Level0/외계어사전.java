package Java_Programmers.Level0;

import java.util.Arrays;
import java.util.HashSet;

public class 외계어사전 {

	/* PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다. 
	 * 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다. 
	 * spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 
	 * 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.
	 * */
	
	public int solution(String[] spell, String[] dic) {
        int answer = 0;
        int cnt = 0;
        
        // spell을 한번만 사용해야되므로 중복제거 
        HashSet<String> hashSet = 
                new HashSet<>(Arrays.asList(dic));
 
        // HashSet을 배열로 변환
        dic = hashSet.toArray(new String[0]);
        
        for(int i =0; i<dic.length; i++) {
        	
        	for(int j = 0; j<spell.length; j++) {
        		if(dic[i].contains(spell[j])) {
        			cnt++;
        		}
        	}
            if (cnt == spell.length) {
            	answer = 1;
            	break;
            } else {
            	answer = 2;
            	cnt=0;
            }
        }

        
        return answer;
    }
	
	public static void main(String[] args) {
		외계어사전 a = new 외계어사전();
		
		String[] spell1 = {"p", "o", "s"};
		String[] dic1 = {"sod", "eocd", "qixm", "adio", "soo"};
		System.out.println(a.solution(spell1, dic1));
		
		String[] spell2 = {"z", "d", "x"};
		String[] dic2 = {"def", "dww", "dzx", "loveaw"};
		System.out.println(a.solution(spell2, dic2));
		
		String[] spell3 = {"s", "o", "m", "d"};
		String[] dic3 = {"moos", "dzx", "smm", "sunmmo", "som"};
		System.out.println(a.solution(spell3, dic3));
		
		
		
	}

}
