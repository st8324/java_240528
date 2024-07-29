package db.student.service;

import db.student.model.vo.ScoreVO;
import db.student.model.vo.StudentVO;
import db.student.model.vo.SubjectVO;

public interface ScoreService {

	boolean insertScore(StudentVO std, SubjectVO subject, ScoreVO score);

	boolean deleteScore(StudentVO std, SubjectVO subject);

	boolean updateScore(StudentVO std, SubjectVO subject, ScoreVO score);

}
