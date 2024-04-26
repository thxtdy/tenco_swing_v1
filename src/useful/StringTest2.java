package useful;

public class StringTest2 {
	
	public static void main(String[] args) {
		
		String str1 = new String("abc");
		String str2 = new String("abc");

		System.out.println(str1 == str2);
		
		String str3 = "abc";
		String str4 = "abc"; // 불변
		
		// 상수 풀에 올라간 String 값은
		// 먼저 존재하는지 확인부터 한다.
		
		// 완전 똑같은 문자열 abc가 존재한다면
		// 새로 생성하지 않고 다시 재사용한다.
		
		// 그래서 위에 코드들은 3개 메모리를 생성한것임.
		
		// 리터럴 영역, 상수 
		System.out.println(str3 == str4);
		
		// == 객체의 주소값을 비교하는 녀석 (참조 타입)
		// equals는 문자열 값을 비교하는 녀석 
		// 결론적으로 문자열 비교는 논리적인 판단으로
		// 같은지 다른지 true, false 값을 반환한다.
		
		System.out.println(str1 == str4);
		System.out.println(str1.equals(str4));
		
		
		
		
		
	}// end of main

}// end of class
