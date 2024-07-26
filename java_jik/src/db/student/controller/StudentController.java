package db.student.controller;

import java.util.Scanner;

import db.student.service.StudentServiceImp;

public class StudentController {

	private StudentServiceImp studentService = new StudentServiceImp();
	private Scanner scan;
	
	public StudentController(Scanner scan) {
		this.scan = scan;
	}
}
