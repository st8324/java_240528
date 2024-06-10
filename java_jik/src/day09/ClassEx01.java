package day09;

public class ClassEx01 {

	public static void main(String[] args) {
		//학생 객체를 생성할 때 생성자를 이용하여 초기화
		Student1 std1 = new Student1();
		Student1 std2 = new Student1(1, 1, 1, "홍길동");
		std2.print();
		/* 멤버변수와 메서드는 객체명.메버변수 또는 객체명.메소드명(매개변수들)을 이용하여 호출할 수 있다
		 * 단, 접근제어자에 따라 제한될 수 있다 */
		std1.name = "임꺽정";
		std1.print();
	}

}

/* 고등학생 성적을 관리하기 위해 학생 클래스를 추상화하려고 한다. 
 * 학생 성적은 국어, 영어, 수학 성적만 관리한다.
 * 클래스 이름은 Student1이고, 이때 필요한 멤버 변수를 선언해보세요.
 */
class Student1{
	
	//멤버변수(필드)
	//자료형 변수명;
	//과목 성적
	int kor, eng, math;
	
	//학년, 반, 번호, 이름
	int grade, classNum, num;
	String name;
	//기본 생성자
	public Student1() {}
	//생성자 오버로딩 : 학년, 반, 번호, 이름을 이용한 생성자
	public Student1(int g, int c, int n, String name1) {
		grade = g;
		classNum = c;
		num = n;
		name = name1;
	}
	
	
	//Stduent1이라는 메서드
	public void Stduent1() {}
	
	public void print() {
		System.out.println(grade + "학년 " + classNum + "반 " + num +"번 " + name);
	}
}



