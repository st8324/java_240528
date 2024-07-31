package db.community.main;

import java.util.Scanner;

import db.community.controller.PrintController;
import db.community.model.vo.MemberVO;
import program.Program;

public class ProgramImp implements Program {

	private Scanner scan = new Scanner(System.in);
	private MemberVO member = null;
	
	@Override
	public void printMenu() {
		PrintController.printMainMenu();
	}

	@Override
	public void run() {
		char menu = '0';
		
		do {
			printMenu();
			
			
			try {
				menu = scan.next().charAt(0);
				
				PrintController.printBar();

				runMenu(menu);
				
				PrintController.printBar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(menu != '3');
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		char ch = (char)menu;
		switch(ch) {
		case '1':
			login();
			break;
		case '2':
			signup();
			break;
		case '3':
			PrintController.exit();
			break;
		default:
			PrintController.wrongMenu();
			
		}
		
		
	}

	private void login() {
		
		
	}

	private void signup() {
		// TODO Auto-generated method stub
		
	}

}
