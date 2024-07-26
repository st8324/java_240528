package db.student.controller;

import java.util.Scanner;

import db.student.service.SubjectServiceImp;

public class SubjectController {

	private Scanner scan = new Scanner(System.in);
	private SubjectServiceImp subjectService = new SubjectServiceImp();
	
	public SubjectController(Scanner scan) {
		this.scan = scan;
	}

	public void insertSubject() {
		//과목명을 입력
		System.out.print("과목 : ");
		scan.nextLine();
		String subject = scan.nextLine();
		
		if(subjectService.insertSubject(subject)) {
			System.out.println("과목을 추가했습니다.");
		}
		else {
			System.out.println("이미 등록된 과목입니다.");
		}
	}
}
