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
}
