package day11;

public class ClassCastingEx01 {

	public static void main(String[] args) {
		Circle c1 = new Circle(10, 10, 10);
		Rect r1 = new Rect(0, 10, 10, 10);
		Circle c2 = new Circle(10,10, 5);
		
		Shape [] shapes = new Shape[20];
		
		shapes[0] = c1;//업캐스팅에 의해 클래스 형변환이 실행
		shapes[1] = r1;
		shapes[2] = c2;
		
		for(Shape tmp : shapes) {
			//원이면 원을 그리고 사각형이면 사각형을 그리는 예제
			if(tmp == null) {
				continue;
			}
			if(tmp instanceof Circle) {
				Circle circle = (Circle)tmp;//다운 캐스팅 : 업 캐스팅 된 객체를 다운 캐스팅할때만 가능
				circle.drawCircle();
				((Circle)tmp).drawCircle();//위 두 줄을 한줄로 씀
			}
			else if(tmp instanceof Rect) {
				Rect rect = (Rect)tmp;//다운 캐스팅
				rect.drawRect();
				((Rect)tmp).drawRect();
			}
		}
	}

}

class Shape{
	String name;
	public Shape(String name) {
		this.name = name;
	}
	void print() {
		System.out.println(name+"입니다.");
	}
}
class Rect extends Shape{
	int x, y;
	int width, height;
	
	public Rect(int x, int y, int width, int height) {
		super("사각형");
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("왼쪽 위의 점 : " + x + "," + y);
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
	}
	public void drawRect() {
		System.out.println("사각형을 그립니다.");
	}
}
class Circle extends Shape{
	int x, y;
	int radius;
	
	public Circle(int x, int y, int radius) {
		super("원");
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("중심점 : " + x + "," + y);
		System.out.println("반지름 : " + radius);
	}
	public void drawCircle() {
		System.out.println("원을 그립니다.");
	}
}
