package edu.kh.col.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kh.col.model.vo.Member;

public class MapService {
	
	// Map : Key와 Value 한 쌍이 데이터가 되어 이를 모아둔 객체 
	
	// - key를 모아두면 Set의 특징(중복X)
	// - Value를 모아두면 List의 특징(중복O)
	
	public void ex1() {
		
		// HashMap<K,V> : Map의 자식 클래스 중 가장 대표되는 Map
		
		Map<Integer, String>map = new HashMap<Integer,String>();
		
		// Map.put(Integer Key, String Value) : 추가 (put:놓다)
		
		map.put(1, "홍길동");
		map.put(2, "고길동");
		map.put(3, "이길동");
		map.put(4, "댕길동");
		map.put(5, "냥길동");
		map.put(6, "멍길동");
		
		// Key 중복
		map.put(1, "홍홍홍"); // Key값에 중복을 허용하지않음 , 대신 Value를 덮어쓴다
		
		// Value 중복
		map.put(7, "최길동"); // 노상관
		
		
		System.out.println(map); // map.toString() 오버라이딩 되어있음.
	}

	public void ex2() {
		// Map 사용 예제
		
		// VO ( 값 저장용 객체 ) 는 특정 데이터 묶음의 재사용이 많은 경우 주로 사용
		// => 재사용이 적은 VO는 오히려 코드 낭비
		// => Map을 이용해서 VO와 비슷한 코드를 작성할 수 있다.
		
		// 1) VO버전
		
		Member mem = new Member();
		
		// 값 세팅
		mem.setId("user1");
		mem.setPw("pass1");
		mem.setAge(30);
		
		// 값 출력
		System.out.println(mem.getId());
		System.out.println(mem.getPw());
		System.out.println(mem.getAge());
		
		System.out.println("======================");
		
		// 2) Map버전
		
		Map<String, Object> map = new HashMap<String, Object>();
		// value가 object 타입 == 어떤 객체든 Value에 들어올 수 있다.
		
		// 값 세팅
		map.put("id", "user02");
		map.put("pw", "pass02");
		map.put("age", 25); // int => Integer(AutoBoxing)
		
		// 값 출력
		
		
		System.out.println(map.get("id").toString());
		// String java.lang.object.toString() => 정적바인딩
		// 실행중 확인해보니 String 자식 객체 => 자식 
		System.out.println(map.get("pw"));
		System.out.println(map.get("age"));
		
		System.out.println("=====================");
		
		// ** Map에 저장된 데이터 순차적으로 접근하는 방법 **
		
		// Map에서 Key만 모아두면 Set의 특징
		// => 이를 활용할 수 있도록 Map에서 KeySet() 메서드 제공
		// => Key만 모아서 Set으로 반환
		
		Set<String> set = map.keySet(); // id, pw, age 가 저장된 Set을 반환
		
		System.out.println(set);
		
		//향상된 for문
		
		for( String key : set ) {
			System.out.println(map.get(key));
		}
		//map에 저장된 데이터가 많을 때,
		//어떤 key가 있는지 불분명 할 때,
		//map에 저장된 모든 데이터에 접근 해야할 때
		//KeySet() + 향상된 for문 코드를 사용한다.
	}
	
	public void ex3() {
		
		// List + Map
		// user 10명, user의 id 쭉 뽑는다.
		// k : v
		// "id : "user1"
		// "id : "user1"
		// "id : "user1"
		// "id : "user1"
		/// .....
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i <10; i++) {
			//Map생성
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", "user0"+i);
			map.put("pw", "pass0"+i);
			
			
			// Map을 List에 추가
			list.add(map);
			
		}
		// for문 종료 시점에 List에는 10개의 Map 객체가 추가되어 있다.
		
		// * List에 저장된 Map 에서 key가 "id"인 경우의 value를 모두 출력 *
		
		// 향상된 for문
		
		System.out.println(list);
		
		for ( Map<String, Object> temp : list) {
			System.out.println(temp.get("id")); 
		}
		 // 구조 잘 생각해보기  :  "id" 키의 value user0+i 를 가져옴
		
	}
}
