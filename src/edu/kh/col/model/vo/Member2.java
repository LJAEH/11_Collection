package edu.kh.col.model.vo;

import java.util.Objects;

public class Member2 {
	
	private String id;
	private String pw;
	private int age;
	private String region;
	
	public Member2() {}

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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Member2 [id=" + id + ", pw=" + pw + ", age=" + age + ", region=" + region + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, pw, region);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member2 other = (Member2) obj;
		return age == other.age && Objects.equals(id, other.id) && Objects.equals(pw, other.pw)
				&& Objects.equals(region, other.region);
	}
	
	
	

}
