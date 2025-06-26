package com.kh.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.map.model.Snack;

/*
 * Map
 * - key - value 쌍으로 저장
 * - 순서 없음
 * - 중복 : 키(key) 중복 안됨, 값(value) 중복 가능
 * 
 * HashMap
 * - Map 인터페이스를 구현한 대표적인 컬렉션 클래스
 * */
public class A_HashMap {

	public void method1() {
		HashMap<String, Integer> map = new HashMap();
		// put : 키 = 값 추가
		map.put("웨하스", 250);
		map.put("고래밥", 100);
		map.put("웨하스", 300); // 키가 중복되면 덮어씀(값 수정)
		map.put("칸쵸", 100);

		// keySet : 키만 가져오기
		Set<String> key = map.keySet();
		System.out.println(key);

		// values : 값만 가져오기
		Collection<Integer> values = map.values();
		System.out.println(values);

		// get : 특정 값만 가져오기
		System.out.println(map.get("웨하스")); // 300

		/*
		 * entrySet - Map 컬렉션에 있는 Entry 객체를 Set 컬렉션에 담아서 반환
		 */
		Set<Entry<String, Integer>> entry = map.entrySet();
		System.out.println(entry); // {웨하스=300, 고래밥=100, 칸쵸=100}
		for (Entry<String, Integer> e : entry) {
			System.out.println(e.getKey() + "-" + e.getValue());
		}
		// 또는
		for (String k : key) {
			System.out.println(k + "-" + map.get(k));
		}

		System.out.println(map);
	}
	
	public void method2() {
		Map<String, Snack> map = new HashMap<>();
		
		map.put("웨하스", new Snack("딸기", 255));
		map.put("웨하스", new Snack("치즈", 240));
		map.put("고래밥", new Snack("양념치킨", 175));
		map.put("자유시간", new Snack("아몬드", 255));
		map.put("칸쵸", new Snack("딸기 요거트", 880));
		map.put("홈런볼", new Snack("초코", 270));
		map.put("스윙칩", new Snack("볶음고추", 347));
		map.put("후렌치파이", new Snack("딸기", 900));
		map.put("나쵸", new Snack("치즈", 486));
		

		// 과자의 개수는 몇개인가요?
		System.out.println("과자의 개수 : " +map.size() + "개");
		// 웨하스의 맛과 칼로리는 ?
		Snack snack = map.get("웨하스");
		System.out.println("웨하스 맛 : " + snack.getFlavor());
		System.out.println("웨하스 칼로리 : " + snack.getCalorie());

		// 딸기맛인 과자(딸기 요거트 포함)의 칼로리 총합과 평균
		int sum = 0;
		int count = 0;
		for(Snack value : map.values()) {
			if(value.getFlavor().contains("딸기")) {
				sum += value.getCalorie();
				count++;
			}
			
		}
		System.out.println("딸기 과자들의 칼로리 합 : " + sum);
		System.out.println("딸기 과자들의 칼로리 평균 : " + (sum/count));
	}

	public static void main(String[] args) {
		A_HashMap a = new A_HashMap();
//		a.method1();
		a.method2();

	}

}
