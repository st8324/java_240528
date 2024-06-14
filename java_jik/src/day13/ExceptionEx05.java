package day13;

public class ExceptionEx05 {

	public static void main(String[] args) {

		try {
			test();
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void test() throws MyException {
		try {
			System.out.println(1/0);
		}catch(Exception e) {
			throw new MyException("test", "0으로 나눌 수 없습니다.");
		}
	}
}

class MyException extends Exception{
	
	String who;
	
	public MyException(String who, String message) {
		super(message);
		this.who = who;
	}
	
	@Override
	public String getMessage() {
		return who + " : " + super.getMessage();
	}
}

