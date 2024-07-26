package db.student.controller;

import java.util.Scanner;

import db.student.model.vo.StudentVO;
import db.student.service.StudentServiceImp;

public class StudentController {

	private StudentServiceImp studentService = new StudentServiceImp();
	private Scanner scan;
	
	public StudentController(Scanner scan) {
		this.scan = scan;
	}

	public void insertStudent() {
		//입력한 정보를 이용하여 객체를 생성
		StudentVO std = inputStudentExpand();

		//학생 추가에 성공하면 성공했다고 알림, 실패하면 실패했다고  알림
		if(studentService.insertStudent(std)) {
			System.out.println("학생이 추가되었습니다.");
		}
		else {
			System.out.println("이미 등록된 학생 정보이어서 추가하지 못했습니다.");
		}
		
	}

	public StudentVO inputStudent() {
		//학년, 반, 번호, 이름을 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		return new StudentVO(grade, classNum, num, "");
	}
	
	public StudentVO inputStudentExpand() {
		StudentVO std = inputStudent();
		
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		std.setSt_name(name);
		return std;
	}

	public void updateStudent() {
		//수정하려는 학년, 반, 번호를 입력
		//입력한 정보를 이용해서 학생 객체를 생성
		StudentVO std = inputStudent();
		
		//수정하려는 학생이 있는지 없는지 확인
		if(!studentService.contains(std)) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		
		//유효한번지이면 수정할 학년,반,번호, 이름을 입력
		//위에서 입력한 학년,반,번호, 이름으로 객체를 생성
		StudentVO newStudent = inputStudentExpand();
		
		
		if(studentService.updateStudent(std, newStudent)) {
			System.out.println("학생 정보를 수정했습니다.");
			return;
		}
		System.out.println("이미 등록된 학생 정보로 수정할 수 없습니다.");
		
	}

	public void deleteStudent() {

		//삭제할 학생정보 입력 
		StudentVO std = inputStudent();
		
		if(studentService.deleteStudent(std)) {
			System.out.println("학생을 삭제했습니다.");
			return;
		}
		
		System.out.println("일치하는 학생이 없습니다.");
	}

	public void selectStudent() {
		//학년 반 번호를 입력 후 객체를 생성
		StudentVO std = inputStudent();
		
		StudentVO dbStd = studentService.selectStudent(std);
		if(dbStd == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println(dbStd);
		//학생 성적을 가져옴
		
		//가져온 학생 성적을 출력
		
	}
}
