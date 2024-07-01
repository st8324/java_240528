package day24;

import program.Program;

public class Ex15 {

	public static void main(String[] args) {
		//아래에세 작성한 TestProgram의 run을 실행하는 코드를 작성하세요.
		TestProgram tp = new TestProgram();
		tp.run();

	}

}
/* Program 인터페이스를 구현한 구현 클래스를 만들려고 했다
 * 원인 : 인터페이스에 있는 추상 메소드들을 오버라이딩하지 않아서
 * 해결 방법 : 추상 메소드들을 오버라이딩하면 된다
 * */
class TestProgram implements Program{

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runMenu(int menu) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		System.out.println("프로그램을 실행했습니다.");
	}
	
}