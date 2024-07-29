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
		
		//학년, 학기, 과목명, 중간, 기말, 수행평가를 입력한 후 과목 객체를 생성
		SubjectVO subject = inputSubject();
		
		
		//리스트에 입력한 학생 객체가 몇번지에 있는지 번지를 가져옴
		int index = list.indexOf(std);
		//번지가 유효하지 않으면 안내문구 출력 후 종료
		if(index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		//리스트에서 번지에 있는 학생 정보를 가져옴
		std = list.get(index);
		//등록된 과목 리스트를 출력
		searchSubject();
		
		//입력한 과목이 과목 리스트에 없으면 안내문구 출력 후 종료
		if(!subjectList.contains(subject.getName())) {
			System.out.println("등록되지 않은 과목이어서 성적을 추가할 수 없습니다.");
			return;
		}
		
		//학생의 과목 리스트를 가져옴
		List<SubjectVO> tmpList = std.getSubjectList();
		//학생의 과목 리스트에 생성한 과목 객체가 있으면 안내문구 출력 후 종료
		if(tmpList.contains(subject)) {
			System.out.println("과목 성적이 이미 등록 되어 있습니다.");
			return;
		}
		//없으면 학생의 과목 리스트에 추가
		tmpList.add(subject);
		System.out.println("학생 성적을 등록했습니다.");
		
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
	private ScoreVO inputSubject() {
		
		System.out.print("중간 : ");
		int midterm = scan.nextInt();
		System.out.print("기말 : ");
		int finals = scan.nextInt();
		System.out.print("수행 : ");
		int performace = scan.nextInt();
		ScoreVO score = new ScoreVO(midterm, finals, performace);
		return score;
	}
	public SubjectVO inputRequiredSubject() {
		System.out.print("과목 : ");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학기 : ");
		int semester = scan.nextInt();
		return new SubjectVO(name, grade, semester);
	}
}
