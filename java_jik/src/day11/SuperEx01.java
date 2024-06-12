package day11;

public class SuperEx01 {

	public static void main(String[] args) {
		Child1 c = new Child1(10,20);
		c.printChild();

	}

}

class Parent1{
	int num = 1;
	
	public void print() {
		System.out.println("num : " + num);
	}
	public Parent1(int num) {
		this.num = num;
	}

}

class Child1 extends Parent1{
	int num2 = 2;
	
	public void printChild() {
		//부모클래스에 있는 print를 호출
		super.print();
		System.out.println("num2 : " + num2);
	}
	public Child1(int num1, int num2) {
		//부모 클래스의 기본 생성자가 없어서 있는 생성자를 호출
		super(num1);
		this.num2 = num2;
	}
}

