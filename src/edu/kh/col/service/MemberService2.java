package edu.kh.col.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MemberService2 {
	private Scanner sc = new Scanner(System.in);
	
	private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	
	
	
	public MemberService2 () {
		
	}
	
	public void display() {
		
		int menuNum = 0;
		
		do {
			System.out.println("메뉴");
			System.out.println("1.학생정보추가");
			System.out.println("2.학생정보조회");
			System.out.println("3.학생정보수정");
			System.out.println("4.학생정보삭제");
			System.out.println("5.성씨검색");
			System.out.println("6.지역검색");
			System.out.println("0.종료");
			System.out.print("번호입력 >>");
			
			try {
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1 : break; 
				case 2 : break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				case 0 ; break;
				default : System.out.println("재입력");
				
				}
				
			}catch(Exception e){
				System.out.println("재입력");
				sc.nextLine();
				menuNum=-1;
			}
			
		} while (menuNum != 0);
		
	}

}
