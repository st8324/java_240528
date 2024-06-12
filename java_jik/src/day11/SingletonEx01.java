package day11;

public class SingletonEx01 {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		s1.message();
		
		Singleton s2 = Singleton.getInstance();
		s2.message();
		
		System.out.println(s1);
		System.out.println(s2);
		
		A a1 = new A();
		A a2 = new A();
		//일반 클래스는 객체를 각각 만들면 서로 다른 객체를 생성한다. 그래서 주소가 다름
		System.out.println(a1);
		System.out.println(a2);
		//참조형 변수는 =을 이용하면 같은 객체를 공유
		a1 = a2;
		System.out.println(a1);
		System.out.println(a2);
		

	}

}

class A{}

class Singleton{
	private static Singleton instance = new Singleton(); 
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		return instance;
	}
	public void message() {
		System.out.println("싱글톤입니다.");
	}
}