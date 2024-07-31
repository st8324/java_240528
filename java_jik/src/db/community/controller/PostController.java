package db.community.controller;

import java.util.Scanner;

import db.community.service.PostService;
import db.community.service.PostServiceImp;

public class PostController {

	private Scanner scan;
	private PostService postService = new PostServiceImp();
	
	public PostController(Scanner scan) {
		this.scan = scan;
	}

	public void insertCommunity() {
		//커뮤니티명을 입력
		System.out.print("커뮤니티명 : ");
		String community = scan.next();
		
		//서비스에게 커뮤니티명을 주면서 등록하라고 시킨 후 성공하면 성공했다고 알림
		if(postService.insertCommunity(community)) {
			System.out.println("커뮤니티 등록 성공!");
		}
		//실패하면 실패했다고 알림
		else {
			System.out.println("커뮤니티 등록 실패!");
		}
		
	}

	public void updateCommunity() {
		//이전 커뮤니티명을 입력
		System.out.print("커뮤니티명 : ");
		String oldName = scan.next();
		
		//이후 커뮤니티명을 입력
		System.out.print("새 커뮤니티명 : ");
		String newName = scan.next();
		
		//서비스에게 이전 커뮤니티명과 이후 커뮤니티명을 주고 커뮤니티명을 수정하라고 요청한 후 성공하면
		//커뮤니티 수정 성공!을 출력
		PrintController.printBar();
		if(postService.updateCommunity(oldName, newName)) {
			System.out.println("커뮤니티 수정 성공!");
		}
		//실패하면 커뮤니티 수정 실패!를 출력
		else {
			System.out.println("커뮤니티 수정 실패!");
		}
	}

	public void deleteCommunity() {
		//삭제할 커뮤니티명을 입력
		System.out.print("커뮤니티명 : ");
		String name = scan.next();
		
		//서비스에게 커뮤니티명을 주고 삭제하라고 요청후 성공하면 커뮤니티 삭제 성공!
		PrintController.printBar();
		if(postService.deleteCommunity(name)) {
			System.out.println("커뮤니티 삭제 성공!");
		}
		//실패하면 커뮤니티 삭제 실패!를 출력
		else {
			System.out.println("커뮤니티 삭제 실패!");
		}
		
	}
	
	
}
