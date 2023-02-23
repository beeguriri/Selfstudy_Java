package Java_Programmers.Level0;

/* 문제
 * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 
 * 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 
 * 최빈값이 여러 개면 -1을 return 합니다. 
 * 0 < array의 길이 < 100
 * 0 ≤ array의 원소 < 1000
*/

public class 최빈값구하기 {
	
	static int solution(int[] array) {
		
        int answer = array[0]; //최빈값
        int max = 0; 					//최빈값의 횟수
        int frequent[] = new int[1000]; //최빈값의 횟수 확인용 배열, 
        								//array의 값을 index로 쓰므로(조건 : array의 원소 < 1000)
        
        for(int i = 0; i < array.length; i++) {
        	
        	//array에 든 값을 index로 주고 index의 value를 증가
        	//i=2에서 a[2] = 3이면 frequent[3] =1
        	//i=3에서 a[3] = 3이므로 frequent[3] =2
            frequent[array[i]]++;
            
            if(max < frequent[array[i]]) {
                max = frequent[array[i]];	//횟수
                answer = array[i];			//최빈값
            }
        }
        
        // 최빈값이 여러개인지 확인, 여러개이면 -1
        int temp = 0; 
        
        for(int i = 0; i < 1000; i++) {
        	
        	//최빈값이 여러개있으면 temp값 증가
            if(max == frequent[i]) temp++;
            
            if(temp > 1) answer = -1;
        }
        
        return answer;
	}

	public static void main(String[] args) {

		int [] arr1 = {1, 2, 3, 3, 3, 4};
		int ans1 = solution(arr1);
		System.out.println("ans1 : " + ans1);
		
		int [] arr2 = {1, 1, 2, 2};
		int ans2 = solution(arr2);
		System.out.println("ans2 : " + ans2);
		
		int [] arr3 = {1};
		int ans3 = solution(arr3);
		System.out.println("ans3 : " + ans3);
	}

}
