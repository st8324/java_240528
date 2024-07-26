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

	public void updateSubject() {
		//수정할 과목을 입력
		System.out.print("과목 : ");
		scan.nextLine();
		String subject = scan.nextLine();
		
		//새 과목명 입력
		System.out.print("새 과목 : ");
		String newSubject = scan.nextLine();
		
		if(subjectService.updateSubject(subject, newSubject)) {
			System.out.println("과목을 수정했습니다.");
		}
		else {
			System.out.println("없는 과목이거나 있는 과목으로 수정하려고 해서 과목을 수정하지 못했습니다.");
		}
		
	}
}
