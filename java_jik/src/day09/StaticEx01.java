package day09;

public class StaticEx01 {

	public static void main(String[] args) {
		Student4 std1 = new Student4(1, 1, 1, "홍길동");
		Student4 std2 = new Student4(1, 1, 2, "임꺽정");
		
		//학생1과 학생2의 정보를 출력하는 코드를 작성(print)
		std1.print();
		std2.print();
		
		//학생1과 학생2의 고등학교를 출력하는 코드를 작성(printSchoolName)
		Student4.printSchoolName();
	}

}

class Student4{
	
	public int grade, classNum, num;
	public String name;
	
	public static String schoolName = "KH고등학교";
	
	public void print() {
		System.out.println(grade+"학년 " + classNum +"반 " + num +"번 " + name);
	}
	
	public static void printSchoolName() {
		System.out.println(schoolName);
	}

	public Student4(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	//test1() : 클래스 메소드
	public static void test1() {
		//클래스 메소드에서 클래스 변수를 호출할 수 있다(O) => printSchoolName
		System.out.println("학교명 : " + schoolName);
		//클래스 메소드에서 객체 변수를 호출할 수 있다(X) => 객체를 생성한 후 호출
		//System.out.println("학년 : " + grade);
		Student4 std = new Student4(1, 1, 1, "둘리");
		System.out.println("학년 : " + std.grade);
		//클래스 메소드에서 클래스 메소드를 호출할 수 있다(O)
		printSchoolName();
		//클래스 메소드에서 객체 메소드를 호출할 수 있다(X) => 객체 생성 후 호출
		//print();
		std.print();
	}
	
	//test2() : 객체 메소드
	public void test2() {
		//객체 메소드에서 클래스 변수를 호출할 수 있다(O)
		System.out.println("학교명 : " + schoolName);
		//객체 메소드에서 객체 변수를 호출할 수 있다(O)
		System.out.println("학년 : " + grade);
		//객체 메소드에서 클래스 메소드를 호출할 수 있다(O)
		printSchoolName();
		//객체 메소드에서 객체 메소드를 호출할 수 있다(O)
		print();
	}
}




