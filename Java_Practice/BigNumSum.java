package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BigNumSum {

	//long에도 담을수없는 긴(큰)~~~~~숫자 더하기
	//input.txt 파일로 숫자를 문자로 입력받아아서 
	//배열로 바꾼 값을 뒤에서 부터 정렬하고 숫자 타입으로 바꿔줌
	//각 인자 더해주고 (짧은자리수만큼 반복)
	//각 인자의 합이 10이 넘어가면 앞자리에 1을 넘겨줌
	//출력은 다시 반대로 정렬
	
	//ArrayList에서 자주 사용하는 메서드
	//add(Object) : 만들어진 ArrayList에 값을 넣음
	//get(int) : 해당 인덱스의 값을 가져옴
	//size() : ArrayList의 크기
	
	//읽어온 문자열(숫자)을 ArrayList<int type>의 ArrayList 선언, 참조변수 "numArr"
	// numArr은 Integer type의 배열을 여러개 가진 배열 : numArr(i) = Integer type의 배열
	public static ArrayList<ArrayList<Integer>> numArr = new ArrayList <> ();

	//txt 파일 읽어서 숫자 역순배열로 바꿔주는 메서드
	public static boolean readNumber() {
		

		//BufferedReader로 input.txt 읽어오기
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));) {
			
			for (int i=0; i<2; i++) {	//i<2 : 위에 두줄만 가져오겠다!
				
				//ArrayList<Integer>의 객체 생성
				numArr.add(new ArrayList<Integer>());

				String str = br.readLine();  		//line단위로 읽는 메서드, 읽어오는건 문자열임
				if (str == null)	return false;	//input파일이 비어있으면 false반환, 
													
				System.out.printf("%20s\n", str);	//출력포맷 맞추기
				
				String[] arr = str.split("");		//split : 배열로 받은 문자열을 한글자씩 나눈 후 arr배열에 저장
				
				//배열 reverse 정렬하기 위한 for문
				for (int j = arr.length - 1; 0<=j; j--) {			//j = arr.length-1 : 인덱스는 0부터 시작하므로
					numArr.get(i).add(Integer.parseInt(arr[j]));	//get(i)로 가져온 문자열을 
																	//add(Integer.parseInt) : 숫자(int)로 바꿔 값 저장
																	//input파일에 문자열 있으면 문자열 출력 후 에러메세지 출력
				}
			}					
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {

		//txt 파일 읽어오는 메서드 호출
		if(readNumber() == false) {			//읽어오는 파일에 문제가 있으면 프로그램실행X
			System.out.println("Error");
			return;
		}
		
		//자릿수가 큰 배열을 0번으로 설정 (자릿수 작은만큼 덧셈 반복 해야하므로)
		int dif = numArr.get(0).size() - numArr.get(1).size();
		if(dif < 0) {									//numArr(1)의 크기가 더 크면
			
			ArrayList<Integer> tArr = numArr.get(0);
			
			numArr.set(0, numArr.get(1));				//numArr(0)은 numArr(1)로 세팅
			numArr.set(1, tArr);						//numArr(1)은 tArr(=numArr(0))으로 세팅
//			dif = Math.abs(dif);			
			
		}
		
		//두 배열 더하기
		int olrim = 0;
		for (int i = 0; i < numArr.get(1).size() ; i++) {	//작은 자릿수만큼 반복, 위에서 numArr(1)에 작은수 세팅함
			
			int sum = numArr.get(0).get(i) + numArr.get(1).get(i) + olrim;
			numArr.get(0).set(i, sum % 10);					//numArr(0)에 계산결과 바로 저장
															//각 자리값을 10으로 나눈 나머지 저장하고 (0~9)
			if (sum>=10) olrim = 1;							//sum이 10 이상이면 앞자리 올려서 더해주기 위해 1
			else		 olrim = 0;							//sum이 10 미만이면 0으로
		}
		
		//덧셈을 작은자릿수만큼 반복하므로 제일 앞자리 올림 처리를 못해주는 문제가 발생함 
		//(ex: 12345 + 9876 = 12221로 출력함 - 정답은 22221)
		//olrim이 1인 경우 제일 앞자리 더해주는 코드 추가
		if(olrim==1) {
			if (numArr.get(0).size() == numArr.get(1).size()) { 	//numArr(0)과 numArr(1)의 길이가 같으면
				numArr.get(0).add(olrim);							//numArr(0)에 olrim=1을 넣음

			} else {												//numArr(0)이 더 길면 
																	//numArr(0)의 numArr(1).size() + 1에 더해줌 
				for(int i = numArr.get(1).size(); i<numArr.get(0).size(); i++) {
					int sum = numArr.get(0).get(i) + olrim;
					numArr.get(0).set(i, sum % 10);
					if (sum>=10) olrim = 1;									//olrim이 남아있으면 한번 더 처리필요
					else		 break;
				}
			}
		}
		
		//numArr(0)의 첫째자리가 9면 제일 앞자리 올림 처리를 못해주는 문제가 발생함
		//(ex: 992345 + 9876 = 002221로 출력함 - 정답은 1002221)
		//olrim이 1일때 제일 앞자리 한번 더 더해줌
		if(olrim==1) numArr.get(0).add(olrim);

		
		//결과 출력 : 저장된 값 reverse로 출력
		String result = "";
		for (int i = numArr.get(0).size()-1; 0 <= i; i--) {
			result += numArr.get(0).get(i);
		}
		System.out.println(" +                  ");
		System.out.println("  ==================");
		System.out.printf("%20s", result);
		
	}

}
