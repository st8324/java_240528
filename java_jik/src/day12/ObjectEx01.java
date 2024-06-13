package day12;

import java.util.Arrays;
import java.util.Objects;

public class ObjectEx01 {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		//toString 확인 예제
		Test3 t1 = new Test3();
		System.out.println(t1);
		Test3 []list = new Test3[3];
		list[0] = new Test3();
		list[1] = new Test3();
		list[2] = new Test3();
		System.out.println(Arrays.toString(list));
		
		//hashCode와 equals 확인 예제
		Student std1 = new Student(1, 1, 1, "홍길동");
		Student std2 = new Student(1, 1, 1, "홍길동");
		Student std3 = new Student(1, 1, 1, "임꺽정");
		Student std4 = new Student(1, 1, 2, "홍길동");
		
		// == 를 이용하여 비교
		System.out.println("-------------------------------------");
		System.out.println("std1 == std2 : " + (std1 == std2));
		System.out.println("std1 == std3 : " + (std1 == std3));
		System.out.println("std1 == std4 : " + (std1 == std4));
		
		//equals를 이용하여 비교
		System.out.println("-------------------------------------");
		System.out.println("std1.equals(std2) : " + (std1.equals(std2)));
		System.out.println("std1.equals(std3) : " + (std1.equals(std3)));
		System.out.println("std1.equals(std4) : " + (std1.equals(std4)));
		
		//clone 예제
		Student std5 = (Student) std1.clone();
		System.out.println("std1 : " + std1);
		System.out.println("std5 : " + std5);
		System.out.println("std1 == std5 : " + (std1 == std5));//std1과 std5는 다른 객체
		System.out.println("std1.equals(std5) : " + std1.equals(std5));
	}
}

class Student implements Cloneable{
	int grade, classNum, num;
	String name;

	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", classNum=" + classNum + ", num=" + num + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}

	@Override
	public boolean equals(Object obj) {
		//주소가 같은 경우 => 같은 객체를 공유
		if (this == obj)
			return true;
		//비교 대상이  null인 경우 => 비교할 수가 없음
		if (obj == null)
			return false;
		//내 클래스와 매개변수의 클래스가 다른 경우
		if (getClass() != obj.getClass())
			return false;
		//내 클래스와 매개 변수의 클래스가 같은 경우
		Student other = (Student) obj;//다운 캐스팅
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}




class Test3{
	int num1, num2;

	@Override
	public String toString() {
		return "Test3 [num1=" + num1 + ", num2=" + num2 + "]";
	}
	
}