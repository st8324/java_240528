package db.student.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.student.dao.StudentDAO;
import db.student.dao.SubjectDAO;
import db.student.model.vo.SubjectVO;

public class SubjectServiceImp implements SubjectService {

	private SubjectDAO subjectDao;
	
	public SubjectServiceImp() {
		String resource = "db/student/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			subjectDao = session.getMapper(SubjectDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean insertSubject(String subject) {
		if(subject == null || subject.length() == 0) {
			return false;
		}
		//해당 과목이 있는지 확인
		int count = subjectDao.selectCountSubject(subject);
		if(count !=0 ) {
			return false;
		}
		return subjectDao.insertSubject(subject);
	}

	public boolean updateSubject(String subject, String newSubject) {
		//없는 과목을 수정하려고 하면 실패
		int oldCount = subjectDao.selectCountSubject(subject);
		if(oldCount == 0) {
			return false;
		}
		//수정될 과목명이 이미 있는 경우면 실패 
		int newCount = subjectDao.selectCountSubject(newSubject);
		if(newCount != 0) {
			return false;
		}
		return subjectDao.updateSubject(subject, newSubject);
	}

	public boolean deleteSubject(String subject) {
		int count = subjectDao.selectCountSubject(subject);
		if(count == 0) {
			return false;
		}
		return subjectDao.deleteSubject(subject);
	}

	public ArrayList<SubjectVO> selectSubjectNameList() {
		return subjectDao.selectSubjectNameList();
	}
}
