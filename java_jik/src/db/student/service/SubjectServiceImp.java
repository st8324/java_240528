package db.student.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.student.dao.StudentDAO;
import db.student.dao.SubjectDAO;

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
}
