package db.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;

import com.mysql.cj.protocol.Message;

public class DbEx02 {

	public static Statement st = null;
	public static Connection con = null;
	
	//Statement를 이용한 예제
	public static void main(String[] args) {
		String db = "student"; //연결할 db를 선택 
		String url = "jdbc:mysql://localhost:3306/" + db;
		String id = "root";
		String pw = "root";
		
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//
			con = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e){
			System.out.println("연결 실패");
			return;
		} catch (ClassNotFoundException e){
			System.out.println("드라이버를 찾을 수 없습니다.");
			return;
		}

		//1학년 1반 4번 김철수 학생을 추가하는 작업 
		/*if(insertStudent(1,1,4,"김철수")) {
			System.out.println("등록되었습니다.");
		}else {
			System.out.println("등록하지 못했습니다.");
		}*/
		//1학년 1반 4번 김철수 학생을 3학년 3반 3번 김철수로 수정
		/*if(updateStudent(1, 1, 4, 3, 3, 3, "김철수")) {
			System.out.println("수정했습니다.");
		}else {
			System.out.println("수정하지 못햇습니다.");
		}*/
		//3학년 3반 3번학생을 삭제
		/*if(deleteStudent(3, 3, 3)) {
			System.out.println("삭제했습니다.");
		}else {
			System.out.println("삭제하지 못했습니다.");
		}*/
		//insertStudent(2,2,1,"배철수");
		//insertStudent(2,2,2,"박영희");
		ArrayList<Student> list = selectStudent();
		if(list == null) {
			System.out.println("검색 중 문제가 발생했습니다.");
			return;
		}
		if(list.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		for(Student std : list) {
			System.out.println(std);
		}
	}
	
	public static ArrayList<Student> selectStudent(){
		if(con == null) {
			return null;
		}
		String sql = "select studentNum, grade, class, num, name from student";
		try {
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			ArrayList<Student> list = new ArrayList<Student>();
			while(rs.next()) {
				int studentNum = rs.getInt(1);
				int grade = rs.getInt(2);
				int classNum = rs.getInt(3);
				int num = rs.getInt(4);
				String name = rs.getString(5);
				Student std = new Student(studentNum, grade, classNum, num, name);
				list.add(std);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static boolean deleteStudent(int grade, int classNum, int num) {
		if(con == null) {
			return false;
		}
		String sql = "delete from student "
				+ "where grade = "+grade+" and class = "+classNum+" and num = "+num;

		try {
			st = con.createStatement();
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateStudent(int oldGrade, int oldClass, int oldNum, 
			int newGrade, int newClass, int newNum, String newName) {
		if(con == null) {
			return false;
		}
		String pattern = "update student set grade = {0}, class={1}, num = {2}, name=\"{3}\" "
				+ "where grade = {4} and class = {5} and num = {6}";
		String sql = MessageFormat.format(pattern, newGrade, newClass, newNum, newName, 
				oldGrade, oldClass, oldNum);
		try {
			st = con.createStatement();

			st.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static boolean insertStudent(int grade, int classNum, int num, String name) {
		if(con == null) {
			return false;
		}
		String sql = "insert into student(grade, class, num, name)"
				+ " values("+grade+", "+classNum+", "+num+", '"+name+"')";
		try {
			st = con.createStatement();
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
