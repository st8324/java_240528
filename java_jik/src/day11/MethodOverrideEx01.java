package day11;

public class MethodOverrideEx01 {

	public static void main(String[] args) {
		Child21 c1 = new Child21(1, 23);
		c1.print();
		Child22 c2 = new Child22(34, 5);
		c2.print();

	}

}

class Parent2{
	int num;
	public void print() {
		System.out.println(num);
	}
	public Parent2(int num) {
		this.num = num;
	}
}

class Child21 extends Parent2{
	int num2;
	public Child21(int num1, int num2) {
		super(num1);
		this.num2 = num2;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("num2 : " + num2);
	}
}

class Child22 extends Parent2{
	int num2;
	public Child22(int num1, int num2) {
		super(num1);
		this.num2 = num2;
	}
	@Override
	public void print() {
		System.out.println("num1 : " + num + ", num2 : " + num2);
	}
}

