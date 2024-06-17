package program;

public interface Program {

	void printMenu();
	
	void runMenu(int menu) throws Exception;
	
	void run(); 
	
	default void save(String fileName) {
		System.out.println("저장 기능을 구현할 예정입니다.");
	}
	default void load(String fileName) {
		System.out.println("불러오기 기능을 구현할 예정입니다.");
	}
}
