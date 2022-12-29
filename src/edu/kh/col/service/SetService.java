package edu.kh.col.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.col.model.vo.Member;

public class SetService {
	
	// Set(집합)
	// - 순서를 유지하지않음. (== 인덱스 없음)
	// - 중복을 허용하지않음. (+null도 중복허용 X, 한개만 저장가능)
	
	
	// **** Set이 중복을 확인하는 방법 ****
	// 컬렉션은 객체만 저장할 수 있음(Set은 컬렉션이기때문에 객체만 저장)
	// => 객체가 가지고 있는 필드 값이 모두 같으면 중복으로 판단
	// ==> 이 때 필드값이 모두 같은지 비교하기 위해서
	//     객체에 "equals()"가 반드시*** 오버라이딩 되어야 한다.
	
	public void ex1() {
		
		Set<String> set = new HashSet<String>();
		
		// HashSet : Set의 대표적인 자식 클래스
		// 사용 조건 1 : 저장되는 객체 equals() 오버라이딩 필수
		// 사용 조건 2 : 저장되는 객체 hashcode() 오버라이딩 필수
		// String 은 굉장히 완성도 높은 클래스로,
		// 이미 equals, hashdood 가 오버라이딩 되어있음
		// 다른클래스 만들때는 equals, hashcode를 오버라이딩 해야됨
		
		// Set.add(String e) : 추가
		
		set.add("네");
		set.add("카");
		set.add("쿠");
		set.add("쿠");
		set.add("쿠");
		set.add("쿠");
		set.add("쿠");
		set.add("배");
		
		System.out.println(set);
		
		// 확인되는 것 : 1. 순서유지x 2.중복x 3.null중복x
		
		// size() : 저장된 데이터의 개수 반환
		
		System.out.println("저장된 데이터의 수 : "+ set.size());
		
		// remove(String e) : Set에 저장된 객체 중 매개변수 e와
						//     필드값이 같은 객체를 제거
		//              +Hash 라는 단어가 포함된 Set이면 hasgcode()도 갈아야됨
		
		
		System.out.println(set.remove("배") );  // 삭제하면 true
		System.out.println(set.remove("당근")); // 못지우면 false
		
		System.out.println(set); // 제거 확인 용도
		
		// List는 index가 있어서 get()으로 요소 하나를 얻어올 수 있었지만
		// Set은 순서가 없어서 저장된 객체 하나를 얻어올 수 있는 방법이 없다.
		// => 대신 Set 전체의 데이터를 하나씩 반복적으로 얻어올 순 있다.
		
		
		// 1. Iterator (반복자)
		// - 컬렉션에서 제공하는 컬렉션 객체 반복 접근자
		// (컬렉션에 저장된 데이터를 임의로 하나씩 반복적으로 꺼내는 역할)
		
		Iterator<String> it = set.iterator();
		// set.iteratr() : Set을 Iterator 하나씩 꺼내갈 수 없는 모양으로 변화
		
		while(it.hasNext()) {// => 다음 값이 있는지 물어보는 구조
			
			// it.hasNext() : 다음 값이 있으면 true반환
			// it.next() : 다음 값(객체)을 얻어옴.
			
			
			String temp = it.next();
			System.out.println(temp);
			
		}
		
		// 향상된 for문 사용
		// for (하나씩 꺼내서 저장할 변수 : 컬렉션) 
		
		for ( String temp : set ) {
			System.out.println(temp);
		}
		
		
		
		
		
		
	}
	
	public void ex2() {
		
		// Hash 함수 : 입력된 단어를 지정된 길이의 문자열로 변환하는 함수(절대 중복 없음)
		// ex) 입력 : 111 => "asdfg" (5글자)
		// ex) 입력 : 123455 => "qwert" (5글자)
		// == 암호화에 사용됨
		// 일정한 길이의 랜덤값 생성. 중복되지 않음
		
		// hashcode() : 필드 값이 다르면 중복되지 않는 숫자를 만드는 메서드
		// => 왜만들까? 빠른 데이터 검색을 위해서(객체가 어디에 있는지 빨리 찾음)
		
		// HashSet() : 중복 없이 데이터 저장(Set)하고 데이터 검색이 빠름(Hash)
		
		Member mem1 = new Member("User01", "pass01", 30);
		Member mem2 = new Member("User01", "pass01", 30);
		Member mem3 = new Member("User02", "pass02", 20);
		
		System.out.println( mem1= mem2); //참조형이기때문에 주소 비교
		// 얕은 복사 경우가 아니라면 다 false 
		
		if(mem1.getId().equals(mem2.getId())) {
			if(mem1.getPw().equals(mem2.getPw())) {
				if(mem1.getAge() == (mem2.getAge())) {
					System.out.println("같은객체임다 (true)");
				}
			}
		}
		
		// ==> 매번 이렇게 비교하기 힘들다;;
		// == equals() 메소드 오버라이딩
		
		System.out.println("=================================");
		
		System.out.println(mem1.equals(mem2)); // <= mem1 과 mem2의 필드가 같은가?
		
		System.out.println(mem1.equals(mem3)); // <= mem1 과 mem3의 필드가 같은가?
		
		
		// 객체 / 상속 / 다형성 복습 해야함~~~~~~~~~~~~
	}
	
	public void ex3() {
		
		// 오버라이딩 된 equals()를 이용하여 Member를 Set에 저장
		//[Key Point!] : 중복이 제거 되는가?
		
		Set<Member> memberSet = new HashSet<Member>();
		
		memberSet.add(new Member("user01", "pass01", 30));
		memberSet.add(new Member("user02", "pass02", 40));
		memberSet.add(new Member("user03", "pass03", 20));
		memberSet.add(new Member("user04", "pass04", 10));
		memberSet.add(new Member("user04", "pass04", 10));
		
		for( Member mem : memberSet ) {
			System.out.println(mem);
		}
		
		Member mem1 = new Member("user01", "pass01", 30);
		Member mem2 = new Member("user01", "pass01", 30);
		Member mem3 = new Member("user03", "pass03", 20);
		
		System.out.println(mem1.hashCode());
		System.out.println(mem2.hashCode());
		System.out.println(mem3.hashCode());
		
		// <= 중복되면 hashCode값 같음 == 걸러짐
	}
	
	public void ex4() {
		// Wrapper 클래스 : 기본자료형 => 객체로 포장하는 클래스
		
		// - 컬렉션에 기본 자료형 값을 저장하고 싶을때 사용
		// - 기본 자료형에 없던 추가 기능, 값을 이용하고 싶을 때 사용
		
		// <Wrapper 클래스 종류>
		// int => Intger
		// double => Double
		// Boolean, Byte, Short, Long, Float, Character
		
		int iNum = 10;
		double dNum = 3.14;
		
		// 기본 자료형 => 포장
		Integer w1 = new Integer(iNum); // 삭제선
		Double w2 = new Double(dNum);
		
		// Wrapper 클래스 활용
		System.out.println("int 최대값 : " + w1.MAX_VALUE); // 기울어진 글씨 == static
		System.out.println("int 최소값 : " + w1.MIN_VALUE); 
		
		System.out.println("double 최대값 : " + w2.MAX_VALUE); // 기울어진 글씨 == static
		System.out.println("double 최소값 : " + w2.MIN_VALUE); 
		
		System.out.println("===static 방식으로 Wrapper 클래스 사용====");	
		System.out.println("int 최대값 : " + Integer.MAX_VALUE);
		System.out.println("int 최소값 : " + Integer.MIN_VALUE);
	
		System.out.println("double 최대값 : " + Double.MAX_VALUE);
		System.out.println("double 최소값 : " + Double.MIN_VALUE);
		
		//parsing : 데이터 형식을 변환
		//String 데이터를 기본 자료형으로 변환
		
		int num1 = Integer.parseInt("100");
		double num2 = Double.parseDouble("1.23456");
		
		System.out.println(num1);
		System.out.println(num2);	
		
		System.out.println(num1+num2);
		
	}
	
	public void ex5() {
		// Wrapper 클래스의 AutoBoxing / AutoUnboxing
		
		Integer w1 = new Integer(100);
		
		Integer w2 = 100;
		Integer w3 = 200;
		
		// (Integer)  (Int => Integer) 자동포장
					// AutoBoxing
		// w2와 100은 원래 연산이 안되어야 하지만
		// Integer는 int의 포장형식이라는걸 Java가 인식하고 있음
		// => 위와 같은 경우 int 를 Integer로 자동 포장 해준다.
		
		System.out.println("w2 + w3 = " + (w2 + w3));
		
		// w2 + w3 == 객체 + 객체 ==> 원래 불가능
		
		// 하지막 Integer는 int의 포장형태라는걸 자바가 인식하고 있음
		// => 연산 시 포장을 자동으로 벗겨냄
		
		// Integer + Integer => int + int (자동포장해제)
		
	}
	
	public void lotto() {
		
		// 로또 번호 생성기 Ver2
		
		// HashSet
		// LinkedHashSet
		// TreeSet
		
		// Set<Integer> lotto = new HashSet<Integer>(); 순서유지x, 중복제거만
		// Set<Integer> lotto = new LinkedHashSet<Integer>(); 순서유지 Set
		Set<Integer> lotto = new TreeSet<Integer>(); // 자동 정렬 Set
		
		while( lotto.size() < 6 ) {
			// lotto 에 저장된 값이 개수가 6개 미만이면 반복
			
			int random = (int)(Math.random()*45+1);
			
			System.out.println(random);
			
			lotto.add(random);
			// int값이 자동으로 Integer로 포장(AutoBoxing)되야 lotto 추가
			
		}
		
		System.out.println("이번주의 추천 6자리" + lotto);
	}
}
