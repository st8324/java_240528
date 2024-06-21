package day18;

public class ThreadEx01 {

	public static void main(String[] args) {
		//Thread 클래스를 이용하여 쓰레드를 생성하는 예제
		MyThread1 thread = new MyThread1();
		
		thread.start();
		for(int i = 0; i<10000; i++) {
			System.out.print("|");
		}

	}

}

class MyThread1 extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i<10000; i++) {
			System.out.print("-");
		}
	}
}
