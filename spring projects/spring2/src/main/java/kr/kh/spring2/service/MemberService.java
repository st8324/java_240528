package kr.kh.spring2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring2.dao.MemberDAO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDao;
}
