package edu.kh.col.model.vo;

import java.util.Objects;

public class Member {
	
	private String id;
	private String pw;
	private int age;
	
	public Member() {
		
	}
	
	public Member(String id, String pw, int age) {
		this.id = id;
		this.pw = pw;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	// toString 오버라이딩
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", age=" + age + "]";
	}

	// Set 사용시 아래의 해쉬코드 and 이퀄스 오버라이딩 만드는것 잊지않기
	
	@Override
	public int hashCode() {
		return Objects.hash(age, id, pw);
	}
	// <= 중복제거 검사함
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age 
				&& Objects.equals(id, other.id) 
				&& Objects.equals(pw, other.pw);
	}
	
	
	
	
	
	/*
	// 오버라이딩
	// <= 둘다 기본클래스 오브젝트에서 오버라이딩
	
	// object.equals() 오버라이딩
	// - 현재 객체와 매개변수로 전달받은 객체의 필드가 같은지 비교하는 형태로 오버라이딩
	
	public boolean equals(Object obj) { 
		// 최상위 객체인 obj로 일단 받고 이 obj를 강제형변환 Member로 다운캐스팅 
		Member other = (Member)obj; // 다운캐스팅
		
		return this.id.equals(other.id) 
		&& this.pw.equals(other.pw) 
		&& this.age==(other.age);
		
		// <= 자동완성 alt shift s => generate hashcode 
		
		
	}
	
	// object.hashcode() 오버라이딩
	
	
	
	
	*/
	

}
