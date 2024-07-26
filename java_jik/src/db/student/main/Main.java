package db.student.main;

public class Main {

	public static void main(String[] args) {
		/* 학생의 성적을 관리하기 위한 클래스를 만들려고 한다. 이 때 필요한 클래스를 만들어보세요.
		 * 학생 Student
		 *  - 학년, 반, 번호, 이름
		 *  - 각 과목의 점수
		 * 과목 Subject
		 *  - 과목명, 학년, 학기, 중간, 기말, 수행평가
		 * */
		StudentManager sm = new StudentManager();
		sm.run();
	}

}
