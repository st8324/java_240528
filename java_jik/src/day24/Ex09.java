package day24;

import lombok.Setter;

public class Ex09 {

	public static void main(String[] args) {
		PointA p1 = new PointA(10,20);
		p1.print();
		/* x의 값을 100, y의 값을 200으로 수정하려 했다
		 * 원인 : 접근제어자가 private이어서
		 * 해결방법 : 접근제어자를 public으로 만들던지 setter를 추가
		 * */
		//p1.x = 100;
		//p1.y = 200;
		p1.setX(100);
		p1.setY(200);
		
		p1.print();
		/* 기본 생성자를 이용해서 객체를 생성하려 했다
		 * 원인 : 기본생성자가 없어서. 생성자가 1개라도 있으면 기본 생성자가 자동으로 추가되지 않음
		 * 해결방법 : 기본 생성자를 추가
		 * */
		PointA p2 = new PointA();
		p2.print();
	}
	
}

class PointA{
	@Setter
	private int x, y;
	
	public PointA() {}
	
	public PointA(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void print() {
		System.out.println(x + "," + y);
	}
}