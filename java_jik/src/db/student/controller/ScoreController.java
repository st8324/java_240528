package db.student.controller;

import java.util.List;
import java.util.Scanner;

import db.student.model.vo.ScoreVO;
import db.student.model.vo.StudentVO;
import db.student.model.vo.SubjectVO;
import db.student.service.ScoreService;
import db.student.service.ScoreServiceImp;
import db.student.service.SubjectService;
import db.student.service.SubjectServiceImp;

public class ScoreController {

	private ScoreService scoreService = new ScoreServiceImp();
	private SubjectService subjectService = new SubjectServiceImp();
	private Scanner scan;
	
	public ScoreController(Scanner scan) {
		this.scan = scan;
	}

	public void insertScore() {
				
		//등록된 과목을 가져옴
		List<SubjectVO> subjectList = subjectService.selectSubjectNameList();
		if(subjectList.size() == 0) {
			System.out.println("등록된 과목이 없어서 추가할 수 없습니다. 과목을 등록해주세요.");
			return;
		}
		
		//학생 정보 입력(학년, 반, 번호)를 입력해서 학생 객체를 생성
		StudentVO std = inputStudent();
		
		//과목 정보를 입력
		SubjectVO subject = inputSubject();
		//성적 정보를 입력
		ScoreVO score = inputScore();
		
		if(scoreService.insertScore(std, subject, score)) {
			System.out.println("학생 성적을 등록했습니다.");
		}
		else {
			System.out.println("학생 성적을 등록하지 못했습니다.");
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
	private ScoreVO inputScore() {
		
		System.out.print("중간 : ");
		int midterm = scan.nextInt();
		System.out.print("기말 : ");
		int finals = scan.nextInt();
		System.out.print("수행 : ");
		int performace = scan.nextInt();
		ScoreVO score = new ScoreVO(midterm, finals, performace);
		return score;
	}
	public SubjectVO inputSubject() {
		System.out.print("과목 : ");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학기 : ");
		int semester = scan.nextInt();
		return new SubjectVO(name, grade, semester);
	}

	public void deleteScore() {
		//학생 정보를 입력하여 객체를 생성
		StudentVO std = inputStudent();
		
		//삭제할 과목, 학년, 학기 정보를 입력
		//과목, 학년, 학기를 이용해서 객체를 생성
		SubjectVO subject = inputSubject();
		
		if(scoreService.deleteScore(std, subject)) {
			System.out.println("과목 성적을 삭제했습니다.");
			return;
		}
		else {
			System.out.println("과목 성적을 삭제하지 못했습니다.");
		}
	}

	public void updateScore() {
		//학생 정보를 입력하여 객체를 생성
		StudentVO std = inputStudent();
		
		//수정할 과목을 입력
		SubjectVO subject = inputSubject();
		
		//수정할 성적을 입력 
		ScoreVO score = inputScore();
		
		if(scoreService.updateScore(std, subject, score)) {
			System.out.println("과목 성적을 수정했습니다.");
		}
		else {
			System.out.println("과목 성적을 수정하지 못했습니다.");
		}
	}
}
