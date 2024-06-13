package day12;

public class InterfaceEx01 {

	public static void main(String[] args) {
		Dog1 dog = new Dog1();
		dog.bark();
		dog.sleep();
		//인터페이스는 직접 객체를 만들 수 없고 구현 클래스를 이용하여 객체를 만들수 있다(포함 다형성)
		AnimalAction aa = new Dog1();
		aa.bark();
		System.out.println(AnimalAction.num);//AnimalAction에 있는 10과 20이 출력되도록 코드를 작성
		System.out.println(AnimalAction.num2);
		AnimalAction.print();
	}

}

interface AnimalAction{
	public static final int num = 10;
	int num2 = 20;
	public abstract void bark();
	//default 메소드는 오버라이딩을 하지 않아도 됨
	default void sleep() {
		System.out.println("잠을 잡니다.");
	}
	void eat(String food);//public abstract가 자동으로 붙음
	//static 메소드
	public static void print() {
		System.out.println("동물의 동작입니다.");
	}
}

abstract class Animal2 implements AnimalAction{
	String name;
}

class Dog1 extends Animal2{

	@Override
	public void bark() {
		System.out.println("멍멍");
	}

	@Override
	public void eat(String food) {
		System.out.println(food+"를 먹습니다.");
	}
	
}


