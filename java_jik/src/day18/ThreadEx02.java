package day18;

public class ThreadEx02 {

	public static void main(String[] args) {
		// Runnable 인터페이스를 이용한 쓰레드 생성 예제
		MyTread2 mt = new MyTread2();
		
		Runnable r = ()->{
			for(int i = 0; i<10000; i++) {
				System.out.print("-");
			}
		};
		
		//Thread tread = new Thread(mt);
		Thread tread = new Thread(r);
		tread.start();
		
		
		for(int i = 0; i<10000; i++) {
			System.out.print("|");
		}
	}

}

class MyTread2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i<10000; i++) {
			System.out.print("-");
		}
		
	}
	
}