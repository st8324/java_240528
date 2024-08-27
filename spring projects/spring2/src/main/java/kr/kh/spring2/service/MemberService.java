package kr.kh.spring2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring2.dao.MemberDAO;
import kr.kh.spring2.model.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDao;

	public boolean signup(MemberVO member) {
		// TODO Auto-generated method stub
		return false;
	}
}
