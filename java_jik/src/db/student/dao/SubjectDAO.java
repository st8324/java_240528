package db.student.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.student.model.vo.SubjectVO;

public interface SubjectDAO {

	int selectCountSubject(@Param("subject")String subject);

	boolean insertSubject(@Param("subject")String subject);

	boolean updateSubject(@Param("old")String subject, @Param("new")String newSubject);

	boolean deleteSubject(@Param("subject")String subject);

	ArrayList<SubjectVO> selectSubjectNameList();

}
