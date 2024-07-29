package db.student.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.student.dao.ScoreDAO;
import db.student.dao.StudentDAO;
import db.student.dao.SubjectDAO;
import db.student.model.vo.ScoreVO;
import db.student.model.vo.StudentVO;
import db.student.model.vo.SubjectVO;

public class ScoreServiceImp implements ScoreService {

	private ScoreDAO scoreDao;
	private SubjectDAO subjectDao;
	private StudentDAO studentDao;
	
	public ScoreServiceImp() {
		String resource = "db/student/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			scoreDao = session.getMapper(ScoreDAO.class);
			subjectDao = session.getMapper(SubjectDAO.class);
			studentDao = session.getMapper(StudentDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertScore(StudentVO std, SubjectVO subject, ScoreVO score) {

		//등록되지 않은 과목이면 false를 반환
		//입력한 과목 정보를 DB에서 가져옴
		SubjectVO dbSubject = subjectDao.selectSubject(subject);
		
		if(dbSubject == null) {
			return false;
		}
		
		//선택한 과목이 이미 학생 성적에 등록되어 있으면 false를 반환
		StudentVO dbStd = studentDao.selectStudent(std);
		if(dbStd == null) {
			return false;
		}
		ScoreVO dbScore = scoreDao.selectScore(dbStd.getSt_key(), dbSubject.getSu_key());
		if(dbScore != null) {
			return false;
		}
		
		score.setSc_st_key(dbStd.getSt_key());
		score.setSc_su_key(dbSubject.getSu_key());
		return scoreDao.insertScore(score);
	}

	@Override
	public boolean deleteScore(StudentVO std, SubjectVO subject) {
		StudentVO dbStd = studentDao.selectStudent(std);
		SubjectVO dbSubject = subjectDao.selectSubject(subject);
		if(dbStd == null || dbSubject == null) {
			return false;
		}
		return scoreDao.deleteScore(dbStd.getSt_key(), dbSubject.getSu_key());
	}

	@Override
	public boolean updateScore(StudentVO std, SubjectVO subject, ScoreVO score) {
		//등록되지 않은 과목이면 false를 반환
		//입력한 과목 정보를 DB에서 가져옴
		SubjectVO dbSubject = subjectDao.selectSubject(subject);
		
		if(dbSubject == null) {
			return false;
		}
		
		//선택한 과목이 학생 성적에 등록되어 있지 않으면 false를 반환
		StudentVO dbStd = studentDao.selectStudent(std);
		if(dbStd == null) {
			return false;
		}
		ScoreVO dbScore = scoreDao.selectScore(dbStd.getSt_key(), dbSubject.getSu_key());
		if(dbScore == null) {
			return false;
		}
		
		score.setSc_st_key(dbStd.getSt_key());
		score.setSc_su_key(dbSubject.getSu_key());
		return scoreDao.updateScore(score);
	}
}
