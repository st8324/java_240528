package db.day02.ex01.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.day02.ex01.dao.StudentDAO;

public class DBEx01 {

	private static StudentDAO studentDao;
	
	public static void main(String[] args) {
		init();
		//studentDao.insertStudent(1, 1, 4, "김철수");
		
	}

	public static void init() {
		String resource = "db/day02/ex01/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			studentDao = session.getMapper(StudentDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
