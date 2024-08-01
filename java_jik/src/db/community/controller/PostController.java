package db.community.controller;

import java.util.List;
import java.util.Scanner;

import db.community.model.vo.CommentVO;
import db.community.model.vo.CommunityVO;
import db.community.model.vo.PostVO;
import db.community.pagination.Criteria;
import db.community.pagination.PageMaker;
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

	public void insertPost(String id) {
		//커뮤니티 출력(기본키와 이름을 함께)
		//서비스에게 커뮤니티 리스트를 요청
		List<CommunityVO> list = postService.getCommunityList();
		//커뮤니티 리스트를 이용하여 화면에 출력
		for(CommunityVO community : list) {
			System.out.println(community);
		}
		
		//커뮤니티 번호를 입력
		System.out.print("커뮤니티 번호 선택 : ");
		int coNum = scan.nextInt();
		//제목 입력
		System.out.print("제목 : ");
		scan.nextLine();
		String title = scan.nextLine();
		//내용 입력
		System.out.print("내용 : ");
		String content = scan.nextLine();
		//커뮤니티 번호, 제목, 내용, 작성자를 이용하여 게시글VO를 생성
		PostVO post = new PostVO(coNum, title, content, id);
		//서비스에게 게시글VO를 주면서 게시글을 등록하라고 요청하고 성공 여부를 출력
		PrintController.printBar();
		if(postService.insertPost(post)) {
			System.out.println("게시글 등록 성공!");
		}
		else {
			System.out.println("게시글 등록 실패!");
		}
		
	}

	public void printCommunityList() {
		List<CommunityVO> list = postService.getCommunityList();
		//커뮤니티 리스트를 이용하여 화면에 출력
		for(CommunityVO community : list) {
			System.out.println(community);
		}
	}

	public void printPostList(Criteria cri) {
		
		//서비스에게 페이지 정보(커뮤니티 번호, 검색어)를 주면서 게시글 리스트를 가져오라고 시킴
		List<PostVO> list = null;
		try {
			 list = postService.getPostList(cri);
		}catch(Exception e) {
			PrintController.printBar();
			//위에서 예외가 발생하면 없는 커뮤니티입니다.라고 출력하고 종료
			System.out.println("없는 커뮤니티입니다.");
			return;
		}
		//가져온 게시글 리스트의 길이가 0이면 등록된 게시글이 없습니다라고 출력하고 종료
		if(list.size() == 0) {
			System.out.println("등록된 게시글이 없습니다.");
			return;
		}
		//가져온 게시글 리스트를 반복문을 이용해서 출력. 
		//이 때, PostVO의 toString을 오버라이딩
		for(PostVO post : list) {
			System.out.println(post);
		}
		
	}

	public PostVO printPostDetail() {
		//게시글 번호 입력
		System.out.print("번호 : ");
		int poNum = scan.nextInt();
		//서비스에게 조회하려는 게시글의 조회수를 증가 시키라고 요청
		postService.updatePostView(poNum);
		//서비스에게 게시글 번호를 주면서 게시글을 가져오라고 요청
		PostVO post = postService.getPost(poNum);
		//가져온 게시글을 출력
		if(post == null) {
			System.out.println("등록되지 않은 게시글이거나 삭제된 게시글입니다.");
		}else {
			post.print();
			System.out.println("엔터를 치세요.");
			scan.nextLine();//버퍼에 남은 엔터 처리
			scan.nextLine();//사용자가 입력한 엔터 처리
			PrintController.printBar();
		}
		return post;
	}

	public PageMaker getPageMaker(Criteria cri, int maxValue) {
		int totalCount = postService.selectPostListTotalCount(cri);
		return new PageMaker(totalCount, maxValue, cri);
	}

	public boolean deletePost(int po_num) {
		return postService.deletePost(po_num);
	}

	public boolean updatePost(int po_num) {
		//새 제목 입력
		System.out.print("새 제목 : ");
		scan.nextLine();
		String title = scan.nextLine();
		//새 내용 입력
		System.out.print("새 내용 : ");
		String content = scan.nextLine();
		//게시글 번호, 새제목, 내용을 이용하여 게시글VO를 생성
		PostVO post = new PostVO(po_num, title, content);
		//서비스에게 게시글VO를 주면서 수정하라고 요청 후 수정 여부를 반환
		return postService.updatePost(post);
	}

	public void insertComment(PostVO post, String id) {
		//post null이면 댓글을 추가할 수 없습니다를 출력하고 종료
		if(post == null) {
			System.out.println("댓글을 추가할 수 없습니다.");
			return;
		}
		//댓글 입력
		System.out.print("댓글 : ");
		scan.nextLine();
		String content = scan.nextLine();
		//게시글 번호, 댓글 내용, 작성자를 이용하여 댓글VO를 생성
		CommentVO comment = new CommentVO(post.getPo_num(), content, id);
		//서비스에게 댓글VO를 주면서 추가하라고 요청후 성공하면 댓글 추가 성공!을 출력
		if(postService.insertCommnet(comment)) {
			System.out.println("댓글 추가 성공!");
		}
		//실패하면 댓글 추가 실패!를 출력
		else {
			System.out.println("댓글 추가 실패!");
		}
	}

	public void printCommentList(PostVO post) {
		//서비스에게 게시글 번호를 주면서 댓글 리스트를 가져오라고 요청
		List<CommentVO> list = null;
		try {
			list = postService.getCommentList(post.getPo_num());
		}
		//예외 발생 시 등록되지 않은 게시글이거나 삭제된 게시글입니다.라고 출력
		catch(Exception e) {
			System.out.println("등록되지 않은 게시글이거나 삭제된 게시글입니다.");
			return;
		}
		
		//댓글 리스트가 0개이면 등록된 댓글이 없습니다.라고 출력
		if(list.size() == 0) {
			System.out.println("등록된 댓글이 없습니다.");
			return;
		}
		System.out.println("댓글 목록");
		//있으면 댓글 리스트에서 하나씩 꺼내 출력.(CommentV의 toString을 오버라이딩)
		for(CommentVO comment : list) {
			System.out.println(comment);
		}
		PrintController.printBar();
		System.out.println("엔터를 치세요.");
		scan.nextLine();//버퍼에 남은 엔터 처리
		scan.nextLine();//사용자가 입력한 엔터 처리
		PrintController.printBar();
	}
	
	
}
