package com.kh.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class A_String {
	
	/*
	 * String 클래스
	 * - 불변의 클래스(객체 생성하면 변경X)
	 * */
	public void method1() {
		String str1 = "hello";
		String str2 = "hello";

	}

	public void method2() {
		// 1. charAt(int index) : char
		// 전달받은 index 위치의 하나의 문자만
		String str = "Hello, Java!";
		char str1 = str.charAt(2);
		System.out.println("1. charAt : " + str1);

		// 2. concat(String str) : string
		// 전달받은 문자열과 원본문자열을 하나로 합친 새로운 문자열 생성해서 리턴
		String str2 = str.concat("!!!!!");
		str2 = str + "!!!!!";
		System.out.println("2. concat : " + str2);

		// 3. substring(int beginIndex, int endIndex) : String
		// 문자열의 beginIndex부터 endIndex- 1까지(endIndex생략하면 끝까지)의 문자열을 새로 생성해서 리턴
		String str3 = str.substring(7);
		String str4 = str.substring(0, 5);
		System.out.println("3. substring : " + str3);

		// 4. indexOf(String str) : int
		// 전달받은 str의 시작 인덱스를 리턴(포함되어있지 않으면 -1)
		int index = str.indexOf("!");
		System.out.println("4. indexOf : " + index);

		int index2 = str.indexOf("Java");
		System.out.println(index2); // 7

		int index3 = str.indexOf("?");
		System.out.println(index3); // -1 (못찾는 경우)

		// 5. replace(char oldChar, char newChar) : String
		// 문자열에서 old문자를 new 문자로 변경된 새로운 문자열을 생성해서 리턴
		String str5 = str.replace('l', 'c');
		System.out.println("5. replace : " + str5);

		// 6. toUpperCase() / toLowerCase() : String
		// 문자열을 모두 대/소문자로 변경한 새로운 문장뎔을 생성해서 리턴
		String str6 = str.toUpperCase(); // 모두 대문자
		String str7 = str.toLowerCase(); // 모두 소문자
		System.out.println("6. toUpperCase : " + str6);
		System.out.println("7. toLowerCase : " + str7);

		// 7. trim() : String (많이 쓰임)
		// 문자열의 앞뒤 공백을 제거한 새로운 문자열을 생성해서 리턴
		String str8 = "        Hello,        Java!          ";
		System.out.println("7. trim 전 : " + str8);
		String str9 = str8.trim();
		System.out.println("   trim 후 : " + str9);

		// 8. toCharArray() : char[]
		// 문자열의 문자들을 문자 배열에 담아서 해당 배열의 주소값 리턴
		char[] arr = str.toCharArray();
		System.out.println("8. toCharArray : " + arr);
		System.out.println(Arrays.toString(arr));

		// 배열을 리스트(ArrayList)로 변환
		List<Character> arrList = new ArrayList<>();
		for (char word : arr) {
			arrList.add(word);
		}
		System.out.println(arrList);
		
		// 9. static valueOf(문자 배열) : String
		// 문자열로 변경해서 리턴
		String str10 = String.valueOf(arr);
		System.out.println("9. valueOf : " + str10); // str과 일치
		
		System.out.println(str);
	}
	
	/*
	 * StringBuilder & StringBuffer
	 * - 가변 클래스 : String 클래스와 달리 내부 문자열을 수정할 수 있다.
	 * - 16개의 문자를 저장할 수 있는 버퍼가 미리 생성되고 문자가 저장됨에 따라 자동 증가
	 * - StringBuilder : 동기화 X -> 단일 스레드 환경 권장
	 * - StringBuffer : 동기화 O -> 멀티 스레드 환경 권장
	 * */
	public void method3() {
		StringBuilder sb = new StringBuilder("Hello, ");
		System.out.println(sb);
		
		// 1. append(String str) : StringBuilder
		// 기존 문자열 뒤에 문자열 추가
		sb.append("Java!");
		System.out.println(sb);
		
		// 2. insert(int offset, String str) : StringBuilder
		// 문자열의 offset 위치부터 전달받은 문자열 추가
		sb.insert(1, "eeeee");
		System.out.println(sb);
		
		// 3. delete(int str, int end) : StringBuilder
		// start에서 (end-1) 까지 인덱스에 해당하는 문자열 삭제
		sb.delete(1, 6);
		System.out.println(sb);
		
		// 4. reverse() : StringBuilder
		// 문자열의 순서를 역으로 바꾼다
		sb.reverse();
		System.out.println(sb);
		
		// 메서드 체이닝 : 메서드 이어서 쓸 수 있다!
		StringBuilder sb2 = new StringBuilder("Java Program");
		// IPA avaJ
//		sb2.delete(5, 12);
//		sb2.insert(5, "API");
//		sb2.reverse();
		// 한 번에 표현 가능
		sb2.delete(5, 12).insert(5, "API").reverse();
		System.out.println(sb2);
	}
	/*
	 * StringTokenizer
	 * - java.util 패키지에서 제공하는 클래스
	 * - 객체 생성 시 생성자로 전달받은 문자열을 구분자로 이용하여 분리
	 * - 분리된 최소 단위를 토큰이라고 부른다
	 * */
	public void method4() {
		String str = "Java,JDBC,Servlet,JSP,NyBatis,Spring";
		
		// 1. String 클래스의 split 메서드
		//    split(String regex) : String[]
		//    입력받은 구분자로 문자열을 분리해서 문자열의 배열로 담아서 리턴
		String[] strArr = str.split(",");
		for(String s : strArr) {
			System.out.println(s);
		}
		System.out.println("과목 개수 : " + strArr.length); // 6
		System.out.println("-------");
		// 2. StringTokenizer 객체 이용
		StringTokenizer st = new StringTokenizer(str, ",");
		
		// hasMoreTokens : 남아 있는 토큰이 있는지
//		System.out.println(st.hasMoreTokens()); // true
//		// nextToken : 토큰을 하나씩 꺼내옴
//		System.out.println(st.nextToken()); // Java
//		System.out.println(st.nextToken()); // JDBC
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println("과목 개수 : " + st.countTokens()); // 0 바로 위에서 배열 안 값을 모두 빼냈기 때문

		
	}

	public static void main(String[] args) {
		A_String a = new A_String();
//		a.method1();
//		a.method2();
//		a.method3();
		a.method4();
	}
}
