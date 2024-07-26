package db.day02.ex01.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.day02.ex01.dao.StudentDAO;
import db.day02.ex01.vo.StudentVO;

public class DBEx01 {

	private static StudentDAO studentDao;
	
	public static void main(String[] args) {
		init();
		//studentDao.insertStudent(1, 1, 4, "김철수");
		ArrayList<StudentVO> list = studentDao.selectStudentList();
		System.out.println(list);
		ArrayList<StudentVO> list2 = studentDao.selectStudentList2();
		System.out.println(list2);
		StudentVO student = studentDao.selectStudentByKey(1);
		System.out.println(student);
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
