package db.student.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.student.dao.StudentDAO;
import db.student.model.vo.StudentVO;

public class StudentServiceImp implements StudentService{

	private StudentDAO studentDao;
	
	public StudentServiceImp() {
		String resource = "db/student/config/mybatis-config.xml";
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

	public boolean insertStudent(StudentVO std) {
		if(std == null) {
			return false;
		}
		//이미 등록된 학생인지 확인 
		//학년, 반, 번호가 있는 학생 정보를 주면서 학년, 반, 번호와 일치하는 학생 정보를 가져오라고 시킴
		StudentVO dbStd = studentDao.selectStudent(std);
		//등록된 학생이면
		if(dbStd != null) {
			return false;
		}

		return studentDao.insertStudent(std);
	}

	public boolean contains(StudentVO std) {
		if(std == null) {
			return false;
		}
		StudentVO dbStd = studentDao.selectStudent(std);
		return dbStd != null;
	}

	public boolean updateStudent(StudentVO std, StudentVO newStudent) {
		if(std == null || newStudent == null) {
			return false;
		}
		//기본키를 가져오기 위해서
		std = studentDao.selectStudent(std);
		
		//새 학생 정보가 있는 학생이면 안되기 때문에 확인 
		StudentVO dbStd = studentDao.selectStudent(newStudent);
		if(dbStd != null && !std.equals(dbStd)) {
			return false;
		}
		newStudent.setSt_key(std.getSt_key());
		return studentDao.updateStudent(newStudent);
	}

	public boolean deleteStudent(StudentVO std) {
		if(std == null) {
			return false;
		}
		return studentDao.deleteStudent(std);
	}

	public StudentVO selectStudent(StudentVO std) {
		return studentDao.selectStudent(std);
	}
}
