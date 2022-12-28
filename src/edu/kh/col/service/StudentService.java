package edu.kh.col.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.col.model.vo.Student;

public class StudentService {
	// 필드
	private Scanner sc = new Scanner(System.in);
	
	

	// 학생 정보를 저장할 List를 생성(객체 배열 Upgrade 버전)
	
	// java.utill.List 인터페이스 : List에 반드시 필요한 필수 기능을 모아둔 인퍼테이스
	// *인터페이스는 객체 생성 X, 부모 참조 변수 O
	
	// java.utill.ArrList : 배열 형태 List(가장 대표적인 List 지식클래스)
	
	// ArrayList() 기본생성자 : 기본크기 10짜리 리스트 생성
						//   리스트 크기가 늘었다 줄었다 하기 때문에 큰의미가 없슴
	// ArrayList(용량) : 용량만큼의 리스트 생성
					//  너무 큰값을 작성하면 메모리를 많이 소모
	
	// List studentList = new ArrayList();
	
	private List<Student> studentList = new ArrayList<Student>();
	// <= (검색) 조회 효율적
	// List<Student> studentList = new LinkedList<Student>();
	// <= 추가, 수정, 삭제 효율적
	// Student로 저장되는 타입이 제한된 리스트 생성
	

	public StudentService() {
		studentList.add(new Student("홍길동", 25, "서울시 중구", 'M', 90));
		studentList.add(new Student("고영희", 23, "경기도 안산시", 'F', 100));
		studentList.add(new Student("김아지", 30, "서울시 강남구", 'M', 80));
		studentList.add(new Student("오미나", 27, "충북 청주시", 'F', 90));
		studentList.add(new Student("박주희", 24, "서울 서대문구", 'F', 70));
	}
	
	
	
	public void ex() {
		// List 리스트
		
		// List.add(object e) : 리스트에 객체를 추가하는...(모든객체 를 매개변수로 해서 == object)
		// * 매개변수 타입이 object == 모든 객체를 object로 전달할 수 있음
		// (매개변수 object == 최상위 부모 참조 변수 == 다형성 적용 가능
		
		studentList.add(new Student());
		//studentList.add(sc);
		//studentList.add("문자");
		//studentList.add(new object());
		
		// =>> 컬렉션 특징 : 여러타입의 데이터 저장 가능
		
		// (반환형)
		// List.get(index i) : 리스트에서 i번째 인덱스에 잇는 객체(object)를 반환
		// 반환형이 object == 모든객체를 반환할 수 있다.
		
		System.out.println( studentList.get(0).toString() );
		
		// [Student의 이름만 얻어오기]
		// Student 객체가 맞는지 instanceof로 확인하고,
		// 다운 캐스팅 해야(get(int index) 메소드가 반환형이 object이기 때문에
		// Student 기능을 사용할 수 있다.
		if( studentList.get(0) instanceof Student ) {
			System.out.println(((Student)studentList.get(0)).getName());
		}
		
		// => 길고 복잡함
		// => 컬렉션의 장점인 여러 객체의 저장이 방해될 정도임,.
		
		// *********** 제네릭스(Generics) ************
		// <>
		// => 컬렉션에 저장되는 객체 타입을 한가지로 제한
		
		System.out.println( studentList.get(0).getName());
		
	}

	
	/** 메뉴 출력용 메서드
	 * alt + shift + j
	 * @author wogurdlek2@gmail.com
	 */
	
	public void displayMenu() {
		
		int menuNum=0;
		
		do {
			
			System.out.println("학생 관리 프로그램");
			System.out.println("1. 학생정보추가");
			System.out.println("2. 학생전체조회");
			System.out.println("3. 학생정보수정");
			System.out.println("4. 학생정보제거");
			System.out.println("5. 이름으로검색(일치)");
			System.out.println("6. 이름으로검색(포함)");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("\n 메뉴 번호 선택 >>>");
			
			try{
				menuNum = sc.nextInt();
				System.out.println(); // 줄바꿈 용도
				
				switch(menuNum) {
				case 1: System.out.println( addStudent() );break;
				case 2: selectAll(); break;
				case 3: System.out.println( updateStudent() ); break;
				case 4: System.out.println( removeStudent() ); break;
				case 5: searchName1(); break;
				case 6: searchName2(); break;
				case 0: System.out.println("프로그램 종료");break;
				default : System.out.println("번호 재입력");
				
				}
			
			}catch (InputMismatchException e) {
				
				System.out.println("\n error : 재입력");
				sc.nextLine();
				menuNum = -1; // 첫 반복 시 잘못 입력하는경우 menuNum에서
			}
			
		}while(menuNum != 0);
		
	}
		
		
		/** 메뉴 출력용 메서드
		 * @return
		 * @throws InputMismatchException
		 */
		public String addStudent() throws InputMismatchException {
			System.out.println("학생 정보 추가");
		
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("나이 : ");
			int age = sc.nextInt();
			System.out.print("지역 : ");
			String region = sc.next();
			System.out.print("성별 : ");
			char gender = sc.next().charAt(0);
			System.out.print("점수 : ");
			int score = sc.nextInt();
		
		if( studentList.add(new Student(name, age, region, gender, score))) {
			return "성공";
		} else {
			return "실패";
			
		}
	}
		
	/** 학생 전체조회
	 * 
	 */
	public void selectAll() {
		// List 인덱스가 있다.(0번부터 시작)
		// List에 저장된 데이터 개수를 얻어오는 방법 : int List.size()
		// => 배열명.length 대신 사용
		
		System.out.println("학생 전체 조회");
		// studentList가 비어있는 경우 "학생 정보가 없습니다" 출력
		
		
		// List 가 비어있는지 확인하는 방법:
		// boolean List.isEmpty() : 비어있으면 true 반환
		
		
		// if (studentList.size() == 0) {
		if( studentList.isEmpty() ) {  // studentList가 비어있으면 true 반환
			System.out.println("학생 정보가 없습니다.");
			
			return; // 반환형 없는(void) return구문은 현재 메소드를 종료하고 호출한 곳으로 돌아감
					// 자동으로 else 구문을 쓴것 같은 효과..
		} 
		
		// 일반 for문
		/*
		 * for ( int i = 0; i<studentList.size(); i++) {
			System.out.println( studentList.get(i) );
			// studentList에서 i번째 인덱스 요소를 얻어와 출력
		}
		*/
		
		// 향상된 for문 ( for each문 )
		// - 컬렉션, 배열의 모든 요소를 순차적으로 반복접근할 수 있다.
		// (순차적 0번 인덱스부터 마지막요소까지 인덱스를 1씩 증가)
		
		// [작성법]
		// for(컬렉션 or 배열에서 꺼낸 한개의 요소를 저장할 변수 : 컬렉션명 or 배열명) {} 
		
		int index = 0;
		
		for ( Student std : studentList ) {
			// std에는 for문 반복 시 마다 0,1,2,... 인덱스 요소들을 한 번씩 저장됨.
			System.out.println((index++) + "번 : ");
			System.out.println(std);
		}
		

	}
	
	public String updateStudent() throws InputMismatchException {
		
		// List.set(int index, Student e)
		// ==> List의 index의 요소를 전달받은 e로 변경
		// => 반환값 Student == 변경전의 Student 객체가 담겨있음
		
		System.out.println("학생정보수정");
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		// 1) 학생 정보가 studentList 에 있는가?
		
		if(studentList.isEmpty()) {
			return "정보없음";
		
		// 2) 입력된 숫자가 0보다 작은가?(음수 x)
		} else if ( index < 0 ) {
			return "음수는 안됨";
			
		// + 문자열을 입력한 경우 => throws로 예외처리
		// 3) 입력된 숫자가 studentList 범위 내 인덱스 
		
		} else if (index >= studentList.size()) {
			return "범위를 넘어선 값을 입력할 수 없음";
		
		} else {
			// 수정 코드 작성
			System.out.println(index + "번째 인덱스에 저장된 학생 정보");
			System.out.println( studentList.get(index) );
			
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("나이 : ");
			int age = sc.nextInt();
			System.out.print("지역 : ");
			String region = sc.nextLine();
			System.out.print("성별 : ");
			char gender = sc.next().charAt(0);
			System.out.print("점수 : ");
			int score = sc.nextInt();
			
			// 입력받은 index번째 새로운 학생 정보를 세팅 == 수정
			
			Student temp = studentList.set(index, new Student(name, age, region, gender, score));
			
			
			
			return temp.getName() + "의 정보가 변경되었습니다.";
		}
		
	}

	/**
	 * 4. 학생 정보 제거 메서드
	 * @return
	 */
	public String removeStudent() {
		
		
		// List.remove(int index)
		// 리스트에서 index 번째 요소를 제거
		// 이 때, 제거된 요소가 반환된다.
		// *List는 중간에 비어있는 인덱스가 없게 하기 위해서
		// remove() 동작 시 뒤쪽 요소를 한 칸씩 당겨온다.
		
		System.out.println("학생정보제거");
		System.out.print("인덱스 번호 입력");
		int index = sc.nextInt();
		sc.nextLine();
		
		if(studentList.isEmpty()) {
			return "정보없음";
		
		// 2) 입력된 숫자가 0보다 작은가?(음수 x)
		} else if ( index < 0 ) {
			return "음수는 안됨";
			
		// + 문자열을 입력한 경우 => throws로 예외처리
		// 3) 입력된 숫자가 studentList 범위 내 인덱스 
		
		} else if (index >= studentList.size()) {
			return "범위를 넘어선 값을 입력할 수 없음";
		
		} else {
			// 학생 정보 제거
			
			System.out.println("정말 삭제 하겠습니까? (Y/N) : ");

			char ch = sc.next().toUpperCase().charAt(0);
						// String => 대문자 String => 대문자 0번째 인덱스 문자
						// String.toUpperCase() : 문자열을 대문자로 변경
						// String.toLowerCase() : 문자열을 소문자로 변경
			// char형이라 ==  '' 으로 판단 String 형이면 equals를 써야함
			if(ch == 'Y') {
				Student temp = studentList.remove(index);
				return temp.getName()+"의 정보가 제거되었습니다.";
			} else {
				return "취소";
			}
		}
		
	}
	
	/**
	 * 5. 이름이 일치하는 학생을 찾아서 조회
	 */
	public void searchName1() {
		
		System.out.println("학생 검색(이름 일치)");
		
		System.out.print("검색할 이름 : ");
		String input = sc.next();
		
		boolean flag = true; // flag가 true인 경우 ==> 검색결과가 없습니다.
		
		for( Student std : studentList ) {
			
			if(input.equals(std.getName())) {
				System.out.println(std);
				flag = false;
			}
		}
		
		if (flag) {
			System.out.println("검색결과가 없습니다.");
		}
	}
	
	/**
	 * 6. 이름에 특정 문자열이 포함되는 학새을 찾아서 조회
	 */
	public void searchName2() {
		
		System.out.println("학생 검색(이름 일치)");
		
		System.out.print("이름에 포함될 문자열 : ");
		String input = sc.next();
		
		boolean flag = true; // flag가 true인 경우 ==> 검색결과가 없습니다.
		
		for( Student std : studentList ) {
			
			// contains : 포함
			// boolean String.contains(문자열) : String 에 문자열이 포함되어있으면 true
			if(std.getName().contains(input)) { // true, false
				System.out.println(std);
				flag = false;
			}
		}
		
		if (flag) {
			System.out.println("검색결과가 없습니다.");
		}
	}
	
	
	
}
