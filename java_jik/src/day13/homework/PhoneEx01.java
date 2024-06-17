package day13.homework;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneEx01 {

	/* 연락처 관리를 위한 프로그램을 만드세요.
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 1
	 * ----------
	 * 이름 : 홍길동
	 * 번호 : 010-1231-2333
	 * ----------
	 * 등록이 완료됐습니다.
	 * ----------
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 1
	 * ----------
	 * 이름 : 홍길동
	 * 번호 : 010-1234-2333
	 * ----------
	 * 등록이 완료됐습니다.
	 * ----------
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 1
	 * ----------
	 * 이름 : 고길동
	 * 번호 : 010-1234-2333
	 * ----------
	 * 이미 등록된 번호입니다.
	 * ----------
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 2
	 * ----------
	 * 이름 : 홍
	 * 1. 홍길동 : 010-1231-2333
	 * 2. 홍길동 : 010-1234-2333
	 * 번호 선택 : 1
	 * 이름 : 홍길동
	 * 번호 : 010-7894-5678
	 * -----------
	 * 수정이 완료됐습니다.
	 * -----------
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 2
	 * ----------
	 * 이름 : 홍
	 * 1. 홍길동 : 010-7894-5678
	 * 2. 홍길동 : 010-1234-2333
	 * 번호 선택 : 1
	 * 이름 : 홍길동
	 * 번호 : 010-1234-2333
	 * -----------
	 * 이미 등록된 번호입니다.
	 * -----------
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 4
	 * ----------
	 * 검색할 이름을 작성하세요(전체 검색 : 엔터) : 
	 * 1. 홍길동 : 010-7894-5678
	 * 2. 홍길동 : 010-1234-2333
	 * ----------
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 3
	 * ----------
	 * 이름 : 홍
	 * 1. 홍길동 : 010-7894-5678
	 * 2. 홍길동 : 010-1234-2333
	 * 삭제할 번호 선택 : 1
	 * ----------
	 * 번호를 삭제했습니다.
	 * */
	//클래스(정적) 멤버 변수로 Scanner를 만들면 어디에서든 매개변수로 넘기지 않고 사용가능하다 
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		//반복문 안에 들어가면 조건식에서 사용하지 못하기 때문에 여기에 선언
		final int EXIT = 5;
		int menu = EXIT + 1;
		Contact [] list = new Contact[10];
		int count = 0;
		do {
			//메뉴 출력
			printMenu();
			
			try {
				//메뉴 선택
				menu = scan.nextInt();
				System.out.println("--------------");
				//선택한 메뉴에 따른 기능 실행
				count = runMenu(menu, list, count);
				System.out.println("--------------");
			}catch(InputMismatchException e) {
				System.out.println("메뉴를 잘못 입력 했습니다.");
				//메뉴를 잘못 선택했을 때 입력 버퍼에 남은 값을 제거
				scan.next();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu != EXIT);
		
	}
	
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 연락처 추가");
		System.out.println("2. 연락처 수정");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 연락처 검색");
		System.out.println("5. 프로그램 정료");
		System.out.print("메뉴 선택 : ");
	}
	/**
	 * 기능 : 연락처들(연라처리스트, 저장된 개수)을 이용하여 주어진 메뉴에 맞는 기능을 실행하고 연락처 개수를 반환하는 메소드
	 * @param menu 주어진 메뉴
	 * @param list 연락처 리스트
	 * @param count 저장된 개수
	 * @return 저장된 개수(추가 시 +1, 삭제 시 -1)
	 * @throws Exception 
	 */
	public static int runMenu(int menu, Contact [] list, int count) throws Exception {
		switch(menu) {
		case 1:
			count = insert(list, count);
			break;
		case 2:
			update(list, count);
			break;
		case 3:
			count = delete(list, count);
			break;
		case 4:
			search(list, count);
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		return count;
	}
	
	

	/**기능 : 연락처 리스트에 연락처가 몇번지에 있는지 알려주는 메소드
	 * @param list 연락처 리스트
	 * @param count 저장된 연락처 개수
	 * @param contact 확인할 연락처
	 * @return 연락처가 있는 번지. 없으면 -1
	 */
	public static int indexOf(Contact[] list, int count, Contact contact) {
		if(list == null || count == 0) {
			return -1;
		}
		for(int i = 0 ; i < count; i++) {
			if(list[i].equals(contact)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 기능 : 연락처리스트에 새 연락처를 입력받아 저장하는 메소드 
	 * @param list 연락처 리스트
	 * @param count 저장된 개수
	 * @return 저장된 개수(추가에 성공하면 count+1, 아니면 count)
	 * @throws Exception 전화번호를 잘못 입력한 경우
	 */
	public static int insert(Contact[] list, int count) throws Exception {
		//정보를 입력(이름, 번호)
		scan.nextLine();//엔터 처리
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("번호 : ");
		String number = scan.nextLine();
		
		//입력한 정보를 이용하여 객체를 생성
		Contact contact = new Contact(name, number);
		
		//연락처 리스트에 입력한 번호 객체가 있는지 없는지 확인해서
		int index = indexOf(list, count, contact);
		
		//있으면 이미 등록된 번호입니다라고 출력하고 
		if(index >= 0) {
			System.out.println("이미 등록된 번호입니다.");
			return count;
		}
		//없으면 연락처를 등록하고 
		list[count] = contact;
		count++;
		//등록이 완료되었습니다라고 출력
		System.out.println("등록이 완료되었습니다.");
		return count;
	}
	
	/**
	 * 기능 : 연락처 리스트에서 이름에 맞는 연락처를 출력하는 메소드
	 * @param list 연락처 리스트
	 * @param count 저장된 연락처 개수
	 * @param name 검색할 이름
	 * @return 일치하는 연락처가 없으면 false 있으면 true
	 */
	public static boolean printContact(Contact[] list, int count, String name) {
		if(list == null || count == 0) {
			System.out.println("등록된 연락처가 없습니다.");
			return false;
		}
		int sameCount = 0;//이름과 일치하는 연락처 개수 => 없는 경우 안내문구를 위해
		for(int i = 0; i<count; i++) {
			if(list[i].getName().contains(name)) {
				System.out.println(i+1+". "+list[i].toString());
				sameCount++;
			}
		}
		if(sameCount == 0) {
			System.out.println("일치하는 연락처가 없습니다.");
			return false;
		}
		return true;
	}
	/**
	 * 기능 : 연락처 리스트에서 번지와 이름이 주어지면 유효한지를 알려주는 메소드
	 * @param list 연락처 리스트
	 * @param count 저장된 연락처 개수
	 * @param name 확인하려는 이름
	 * @param index 번지
	 * @return 선택한 번지에 이름이 주어진 이름과 같은지 다른지를 반환
	 */
	public static boolean checkContact(Contact[] list, int count, String name, int index) {
		if(list == null || count == 0) {
			return false;
		}
		if(index < 0 || index >= count) {
			return false;
		}
		return list[index].getName().contains(name);
	}
	/**
	 * 기능 : 연락처 리스트에서 연락처 입력받아를 수정하는 메소드
	 * @param list 연락처 리스트
	 * @param count 저장된 개수
	 * @throws Exception 
	 */
	public static void update(Contact[] list, int count) throws Exception {
		//이름 입력
		scan.nextLine();//공백 처리
		System.out.print("이름 : ");
		String name = scan.nextLine();
		//연락처 리스트에서 이름과 일치하는 연락처를 번지+1과 함께 출력 
		if(!printContact(list, count, name)) {
			return;
		}
		
		//번호 선택
		System.out.print("번호 선택 : ");
		int index = scan.nextInt() - 1;
		//번호가 올바르지 않으면 잘못선택했습니다 하고 종료
		boolean res = checkContact(list, count, name, index);
		if(!res) {
			System.out.println("잘못 선택했습니다.");
			return;
		}
		//올바르면 이름, 번호를 입력받음
		scan.nextLine();//엔터 처리
		System.out.print("이름 : ");
		String newName = scan.nextLine();
		System.out.print("번호 : ");
		String newNumber = scan.nextLine();
		//이름, 번호를 이용하영 객체를 생성
		Contact contact = new Contact(newName, newNumber);
		//생성된 객체가 중복된 번호이면 안내문구 출력하고 아니면 객체를 추가
		if(indexOf(list, count, contact) >= 0) {
			System.out.println("이미 등록된 번호입니다.");
			return;
		}
		list[index] = contact;
	}
	/**
	 * 기능 : 연락처 리스트에 삭제할 연락처 정보를 입력받아 삭제하고 저장된 개수를 알려주는 메소드
	 * @param list 연락처 리스트
	 * @param count 저장된 개수
	 * @return 삭제 후 저장된 개수(삭제 성공이면 -1, 실패면 그대로)
	 */
	public static int delete(Contact[] list, int count) {
		//이름 입력
		System.out.print("이름 : ");
		scan.nextLine();//엔터 처리
		String name = scan.nextLine();
		
		//이름과 일치하는 연락처들을 출력하고 없으면 종료
		if(!printContact(list, count, name)) {
			return count;
		}
		
		//번호를 선택
		int index = scan.nextInt() - 1;
		
		//번호가 유효한지 확인해서 유효하지 않으면 안내문구 출력 후 종료
		if(!checkContact(list, count, name, index)) {
			System.out.println("잘못 선택했습니다.");
			return count;
		}
		
		//번호를 삭제
		//해당 번지에서 앞으로 한칸씩 당겨줘야 함
		
		count--;
		//번지가 마지막 번지가 아니면
		if(index != count) {
			Contact [] tmp = new Contact[list.length];
			//4, 2 
			System.arraycopy(tmp, index + 1, list, index, count - index );
		}
		
		//연락처 개수를 1감소
		list[count] = null;
		System.out.println("연락처를 삭제했습니다.");
		return count;
	}
	/**
	 * 기능 : 연락처 리스트에 이름을 입력받아 일치하는 연락처를 출력하는 메소드
	 * @param list 연락처 리스트
	 * @param count 저장된 개수
	 */
	public static void search(Contact[] list, int count) {
		//이름을 입력
		System.out.print("검색할 이름을 작성하세요(전체 검색 : 엔터) : ");
		scan.nextLine();
		String name = scan.nextLine();
		//이름에 맞는 연락처를 출력
		printContact(list, count, name);
	}
}

class Contact{
	private String name;
	private String number;

	public Contact(String name, String number) throws Exception {
		this.name = name;
		setNumber(number);
	}
	
	//hashCode equals는 전화번호가 같으면 등록이 되면 안되고, 수정할 때도 있는 번호는 등록되면 안되기 때문에
	//equals를 오버라이딩 하면 같은 번호인지 아닌지 비교하기가 쉽다
	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(number, other.number);
	}
	//toString을 오버라이딩하면 이름 : 번호 형태의 문자열이 필요할 때 사용하기가 좋다(여러번 필요하기 때문에)
	@Override
	public String toString() {
		//홍길동 : 010-1234-2333
		return name + " : " + number;
	}
	//getter & setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) throws Exception {
		//주어진 번호가 전화 번호 형태가 아니면 예외를 발생 시키고 맞으면 번호에 저장
		//010-1234-5677 또는 02-123-4568 또는 041-234-5678 형태의 문자열을 처리하기 위한 정규표현식
		String regex = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
		if(!Pattern.matches(regex, number)) {
			throw new Exception("주어진 번호는 번호 형태가 아닙니다.");
		}
		this.number = number;
	}
	
}















